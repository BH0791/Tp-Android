package fr.hamtec.alertdialogpersodemo1;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;



public class MainActivity extends AppCompatActivity {
    
    private Button btn_showDialog;
    
    // section onCreat()
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn_showDialog = findViewById( R.id.btn_showDialog );
    }
    
    // section onResume()
    
    @Override
    protected void onResume( ) {
        btn_showDialog.setOnClickListener( v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder( this );
            builder.setTitle( "Name" );
            
            View persoLayout = getLayoutInflater().inflate( R.layout.perso_layout, null );
            builder.setView( persoLayout );
            
            builder.setPositiveButton( "OK", (dialog, which) -> {
                EditText editText = persoLayout.findViewById( R.id.editText );
                sendDialogDataToActivity( editText.getText().toString() );
            } );
            
            AlertDialog dialog = builder.create();
            dialog.show();
        } );
        super.onResume( );
    }
    
    private void sendDialogDataToActivity( String data ) {
        Toast.makeText( this, "Hello " + data, Toast.LENGTH_LONG ).show();
    }
}