package fr.hamtec.deuxiemefragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    
    @Override
    protected void onResume( ) {
        super.onResume( );
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace( R.id.framelayout_main, new Fragment_home() );
        transaction.commit();
    }
    
}