package fr.hamtec.volleydemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
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
        SearchFragment searchFragment = new SearchFragment();
        openFragment(searchFragment);
    }
    private void openFragment( Fragment fragment ) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace( R.id.main_placeHolder, fragment );
        transaction.addToBackStack( null );
        transaction.commit();
    }
}