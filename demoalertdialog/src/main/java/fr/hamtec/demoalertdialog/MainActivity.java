package fr.hamtec.demoalertdialog;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        btn1 = findViewById( R.id.simple_dialog );
        
        AlertDialog.Builder bt1 = new AlertDialog.Builder( this );
        
        bt1.setTitle( R.string.message );
        bt1.setMessage( "Ton message !" );
        bt1.setIcon( R.drawable.alert );
        bt1.setNeutralButton( "Neutral", null );
        bt1.setNegativeButton( "Negative", null );
        bt1.setPositiveButton( "Positive", null );
        
        
        btn1.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                bt1.show();
            }
        } );
        
    }
}