package fr.hamtec.alertdialogdemo1;

import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button btn_valider;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn_valider = findViewById( R.id.btn_valider);
        
        AlertDialog.Builder dialog = new AlertDialog.Builder( this );
        dialog.setTitle( "Welcome -> Title" )
                .setMessage( "I follow the message -> Message" )
                .setNegativeButton( "Negative", ( dialog13, which ) -> {
                    Toast toast = Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_LONG);
                    toast.show();
                } ).setPositiveButton( "Positive", ( dialog12, which ) -> {
                    Toast toast = Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_LONG);
                    toast.show();
                } ).setNeutralButton( "Neutre", ( dialog1, which ) -> {
                    Toast toast = Toast.makeText(MainActivity.this, "Neutre", Toast.LENGTH_LONG);
                    toast.show();
                } );
        
        
        
        btn_valider.setOnClickListener( v -> {
            AlertDialog alertDialog = dialog.create();
            alertDialog.show();
        } );
        
        
    }
}