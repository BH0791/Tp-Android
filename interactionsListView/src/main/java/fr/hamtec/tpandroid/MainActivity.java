package fr.hamtec.tpandroid;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });
    }
    
    
    
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
    
    }
}