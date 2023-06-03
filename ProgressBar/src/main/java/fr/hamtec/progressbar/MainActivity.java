package fr.hamtec.progressbar;

import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    ProgressBar pg1, pg2;
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        pg2 = findViewById( R.id.progressBar2 );
        pg2.setProgress( 50 );
        
    }
}