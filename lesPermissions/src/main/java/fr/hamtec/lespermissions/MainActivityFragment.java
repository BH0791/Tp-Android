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
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

public class MainActivityFragment extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {
    private static final String TAG = "TEL";
    private Button btn_testEnvoieSMS, btn_testPermAccorder, btn_testPerm;
    private TextView txt_responce;
    private final static int REQUEST_SEND_SMS = 3;
    private boolean canSendSMS = false;
    
    private static void onClick( View btn ) {
    
    }
    
    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        View view = inflater.inflate( R.layout.fragment_main, null );
        btn_testEnvoieSMS = view.findViewById( R.id.btn_testEnvoieSMS );
        btn_testPermAccorder = view.findViewById( R.id.btn_testPermAccorder );
        btn_testPerm = view.findViewById( R.id.btn_testPerm );
        txt_responce = view.findViewById( R.id.txt_responce );
        
        
        btn_testEnvoieSMS.setOnClickListener( btn -> testPermEvoie( ) );
        btn_testPermAccorder.setOnClickListener( btn -> testPermAccorder( ) );
        btn_testPerm.setOnClickListener( btn -> ensurePermission() );
        
        return view;
    }
    
    private void testPermEvoie( ) {
        PackageManager packageManager = getActivity( ).getPackageManager( );
        if ( packageManager.hasSystemFeature( PackageManager.FEATURE_TELEPHONY ) ) {
            txt_responce.setText( "Le terminal peut envoyer un SMS" );
        } else {
            txt_responce.setText( "Le terminal ne peut pas envoyer de SMS" );
        }
        
    }
    
    private void testPermAccorder( ) {
        if ( ContextCompat.checkSelfPermission( getActivity( ), Manifest.permission.SEND_SMS ) == PackageManager.PERMISSION_GRANTED ) {
            txt_responce.setText( "La permission envoie SMS est déjà accordée." );
        } else {
            if ( shouldShowRequestPermissionRationale( Manifest.permission.SEND_SMS ) ) {
                txt_responce.setText( "Il faut fournir une explication" );
            } else {
                askPermissions( );
            }
            
        }
    }
    
    private void askPermissions( ) {
        String[] permissions = new String[]{ Manifest.permission.SEND_SMS };
        requestPermissions( permissions, REQUEST_SEND_SMS );
    }
    
    private void ensurePermission( ) {
        canSendSMS = ContextCompat.checkSelfPermission (getActivity(), Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED;
        
        if ( !canSendSMS ){
            
            if ( shouldShowRequestPermissionRationale( Manifest.permission.SEND_SMS ) ){
                AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );
                builder.setTitle( "Demande de permission" );
                builder.setMessage( "La permission d'envoi de SMS est nécessaire pour l'exécution de cette application. Voulez-vous réévaluer votre décision ?" );
                builder.setNegativeButton( "Non", (dialog, which) -> txt_responce.setText( "L'utilisateur ne veut pas FERMETURE APP!" ) );
                builder.setPositiveButton( "Oui", (dialog, which) -> askPermissions() );
                builder.show();
            }else {
                askPermissions( );
            }
        }
        
    }
    
    @Override
    public void onRequestPermissionsResult( int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults ) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        if ( requestCode == REQUEST_SEND_SMS ){
            for ( int i = 0; i < permissions.length; i++ ) {
                if ( permissions[i].equals( Manifest.permission.SEND_SMS ) && grantResults[i] == PackageManager.PERMISSION_GRANTED ){
                    canSendSMS = true;
                }
            }
        }
    }
}
