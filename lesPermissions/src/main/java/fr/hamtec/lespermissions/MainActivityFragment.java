package fr.hamtec.lespermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MainActivityFragment extends Fragment {
    private static final String TAG = "TEL";
    private Button btn_testEnvoieSMS, btn_testPermAccorder;
    private TextView txt_responce;
    
    private static void onClick( View btn ) {
    
    }
    
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_main, null );
        btn_testEnvoieSMS = view.findViewById( R.id.btn_testEnvoieSMS );
        btn_testPermAccorder = view.findViewById( R.id.btn_testPermAccorder );
        txt_responce = view.findViewById( R.id.txt_responce );
        
        btn_testEnvoieSMS.setOnClickListener( btn -> testPermEvoie());
        btn_testPermAccorder.setOnClickListener( btn -> testPermAccorder() );
        
        return view;
    }
    
    private void testPermEvoie( ){
        PackageManager packageManager = getActivity( ).getPackageManager();
        if ( packageManager.hasSystemFeature( PackageManager.FEATURE_TELEPHONY ) ){
            txt_responce.setText( "Le terminal peut envoyer un SMS" );
        }else {
            txt_responce.setText( "Le terminal ne peut pas envoyer de SMS" );
        }
        
    }
    private void testPermAccorder( ){
        if ( ContextCompat.checkSelfPermission( getActivity(), Manifest.permission.SEND_SMS ) == PackageManager.PERMISSION_GRANTED ){
            txt_responce.setText( "La permission envoie SMS est déjà accordée." );
        }else {
            if ( shouldShowRequestPermissionRationale( Manifest.permission.SEND_SMS ) ){
                txt_responce.setText( "Il faut fournir une explication" );
            }else {
                String[] permissions = new String[] {Manifest.permission.SEND_SMS};
                requestPermissions( permissions, 3 );
            }
            
        }
    }
}
