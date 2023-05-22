package fr.hamtec.splashscreen;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {
    
    private final int SPLASH_SCREEN_TIMEOUT = 4000;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash_screen );
          // 1ér Version
//        // Redirection
//        Runnable runnable = new Runnable( ) {
//            @Override
//            public void run( ) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity( intent );
//                finish();
//            }
//        };
//
//        // delayed
//        new Handler( ).postDelayed( runnable, 3000 );
        
        // 2ém Version lambda
        new Handler( ).postDelayed( ( ) -> {
            
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity( intent );
            finish();
            
        }, SPLASH_SCREEN_TIMEOUT );
    }
}