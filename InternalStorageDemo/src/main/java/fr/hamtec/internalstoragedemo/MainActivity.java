package fr.hamtec.internalstoragedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private Button readButton;

    private TextView textView;
    private EditText editText;

    private String simpleFileName = "note.txt";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        saveButton = findViewById( R.id.button_save );
        readButton = findViewById( R.id.button_read );
        editText = findViewById( R.id.editText );
        textView = findViewById( R.id.textView );

        saveButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                saveBufferedWriter();
                //saveDate();
            }
        } );

        readButton.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                readData();
            }
        } );
    }

    private void readData( ) {

        try {

            FileInputStream in = openFileInput(simpleFileName);
            BufferedReader br= new BufferedReader(new InputStreamReader(in));

            StringBuilder sb= new StringBuilder();
            String s = null;

            while((s = br.readLine())!= null)  {
                sb.append( s ).append("\n");
            }

            Log.i( "HB", "setText -> " + sb.toString() );
            textView.setText(sb.toString());

        } catch (Exception ex) {
            Log.i( "HB", "ERREUR-saveData()" );
            Toast.makeText(this,"Erreur:"+ ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    private void saveDate( ) {

        String data = editText.getText().toString();

        try {

            FileOutputStream out = openFileOutput( simpleFileName, MODE_PRIVATE );
            out.write( data.getBytes() );
            out.close();

            Log.i( "HB", "saveData() enregistrer" );
            Toast.makeText(this,"File saved!",Toast.LENGTH_SHORT).show();

        }catch( Exception ex ) {
            Log.i( "HB", "ERREUR-saveData()" );
            Toast.makeText(this,"Erreur:"+ ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    private  void saveBufferedWriter(){

        String data = editText.getText().toString();
        Log.i( "HB", "saveBufferedWriter() " + data );

        try {
            FileOutputStream fout = openFileOutput( simpleFileName, MODE_PRIVATE );
            PrintWriter pwout = new PrintWriter( fout ) ;
            pwout.write( data );
            pwout.close();

        }catch( Exception ex ) {
            Log.i( "HB", "saveBufferedWriter() enregistrer" );
            Toast.makeText(this,"File saved!",Toast.LENGTH_SHORT).show();
        }

    }

}