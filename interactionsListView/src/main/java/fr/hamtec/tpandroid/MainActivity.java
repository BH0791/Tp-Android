package fr.hamtec.tpandroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    
    String[] data = new String[] {"Element1", "Element2","Element3","Element4","Element5","Element6","Element7"};
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupList();
    }
    
    void  setupList() {
        ArrayAdapter adapter=
                new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
        
        getListView().setOnItemLongClickListener( ( parent, view, position, id ) -> {
            Toast.makeText( MainActivity.this, "Clics long - id = " + id, Toast.LENGTH_LONG ).show( );
            return false;
        } );
        
        getListView().setOnItemClickListener( ( parent, view, position, id ) -> Toast.makeText( MainActivity.this, "Clics court- id = " + id, Toast.LENGTH_LONG ).show( ) );
    }
    
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    
    }
}