package fr.hamtec.mynavdrawer;

import android.util.Log;
import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    
    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        
            if ( actionBarDrawerToggle.onOptionsItemSelected( item ) ){
                return true;
            }
        
        return super.onOptionsItemSelected( item );
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        drawerLayout = findViewById( R.id.drawer_layout );
        navigationView = findViewById( R.id.navigationView );
        actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout, R.string.menu_Open, R.string.menu_close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
        
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener( ) {
            @Override
            public boolean onNavigationItemSelected( @NonNull @NotNull MenuItem item ) {
                
                switch ( item.getItemId() ) {
                    case R.id.nav_home:
                        Log.i( "MENU_DRAWER_TAG", "Home item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_search:
                        Log.i( "MENU_DRAWER_TAG", "Search item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_users:
                        Log.i( "MENU_DRAWER_TAG", "Users item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_profiles:
                        Log.i( "MENU_DRAWER_TAG", "Profiles item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_setting:
                        Log.i( "MENU_DRAWER_TAG", "Setting item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_share:
                        Log.i( "MENU_DRAWER_TAG", "Share item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                    
                    case R.id.nav_donnate:
                        Log.i( "MENU_DRAWER_TAG", "Donnate item is clicled");
                        drawerLayout.closeDrawer( GravityCompat.START );
                        break;
                }
                
                return true;
            }
        } );
    }
}