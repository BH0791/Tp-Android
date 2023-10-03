package fr.hamtec.lespermissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class MainActivityFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "TEL";
    private RelativeLayout containerView;
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View tootView = inflater.inflate( R.layout.fragment_main, null );
        Button call = tootView.findViewById( R.id.call );
        containerView = ( RelativeLayout ) tootView.findViewById( R.id.container );
        call.setOnClickListener( this );
        
        
        return tootView;
    }
    
    @Override
    public void onClick( View v ) {
        Log.i( TAG, "onClick: début" );
    
        if ( ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            Log.i( TAG, "Demander la permission " );
            if ( shouldShowRequestPermissionRationale( Manifest.permission.CALL_PHONE ) != true ){
                // explication pourquoi la permission est nécessaire
                explain();
            }else {
                // demander l'autorisation
                askForPermission();
            }
        }
        else{
            call();
        }
        
        Log.i( TAG, "onClick: fin" );
    }
    
    @Override
    public void onRequestPermissionsResult( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        if ( requestCode == 2 ){
            if ( grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                // on appelle
                call();
            }else {
                // Expliquer pourqoi nous avons besion de la permission
            }
        }
    }
    
    private void askForPermission(){
        Log.i( TAG, "askForPermission: début" );
        requestPermissions(new String[] {Manifest.permission.CALL_PHONE }, 2);
        Log.i( TAG, "askForPermission: fin" );
    }
    
    private void explain( ) {
        Snackbar.make( containerView, "Cette permission est nécessaire pour appeler", Snackbar.LENGTH_LONG ).setAction( "Activer", new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                askForPermission();
            }
        } ).show();
    }
    
    private void call( ) {
        String phone = "+33601165017";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}
