package fr.hamtec.simpleadaptateur_01;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    
    ListView simpleListView;
    // array objects
    String courseList[] = {"C-Programming", "Data Structure", "Database", "Python",
            "Java", "Operating System", "Compiler Design", "Android Development"};
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        simpleListView = findViewById( R.id.simpleListView );
        
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>( this, R.layout.item_view, R.id.itemTextView, courseList );
        simpleListView.setAdapter( arrayAdapter );
    }
}