package fr.hamtec.shaderpreference_01;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txtwifi;
    TextView txtcompteur;
    TextView txtcommentaire;
    @SuppressLint( "SetTextI18n" )
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        txtwifi = findViewById( R.id.txtwifi );
        txtcompteur = findViewById( R.id.txtcompteur );
        txtcommentaire = findViewById( R.id.txtcommentaire );
        
        
        SharedPreferences prefs = getSharedPreferences( "mesPrefs.xml", Context.MODE_PRIVATE );
        SharedPreferences.Editor editeur =prefs.edit();
        
        editeur.putBoolean( "modeWifi", true );
        editeur.putInt( "compteur", 42 );
        editeur.putString( "commentaire", "Ceci est un commentaire " );
        
        editeur.commit();
        
        
        
        txtwifi.setText( String.valueOf( prefs.getBoolean( "modeWifi", false ) ) );
        txtcompteur.setText( String.valueOf( prefs.getInt( "compteur", 0 ) ) );
        txtcommentaire.setText( String.valueOf( prefs.getString( "commentaire", "rien" ) ) );
        
    }
}