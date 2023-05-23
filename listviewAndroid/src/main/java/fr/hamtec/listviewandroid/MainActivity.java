package fr.hamtec.listviewandroid;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    ListView l;
    String tutorials[]
            = { "Algorithms", "Data Structures",
            "Languages", "Interview Corner",
            "GATE", "ISRO CS",
            "UGC NET CS", "CS Subjects",
            "Web Technologies" };
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        l = findViewById( R.id.list_item );
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter <>( this, android.R.layout.simple_list_item_1, tutorials );
        l.setAdapter( arrayAdapter );
        
        l.setOnItemClickListener( new AdapterView.OnItemClickListener( ) {
            @Override
            public void onItemClick( AdapterView < ? > parent, View view, int position, long id ) {
                
                Toast.makeText( MainActivity.this, "Choix id = " + id + " position = " + position, Toast.LENGTH_SHORT ).show( );
                
            }
        } );
    }
}