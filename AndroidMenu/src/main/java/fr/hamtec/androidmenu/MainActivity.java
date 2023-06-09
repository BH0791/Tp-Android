package fr.hamtec.androidmenu;

import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    
    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_principal, menu );
        
        return true;
    }
}