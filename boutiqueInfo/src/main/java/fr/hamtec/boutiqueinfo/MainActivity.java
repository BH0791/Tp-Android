package fr.hamtec.boutiqueinfo;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import fr.hamtec.boutiqueinfo.adapters.HighTechItemAdapter;
import fr.hamtec.boutiqueinfo.models.HighTechItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        // Liste des items
        List< HighTechItem > highTechItemList = new ArrayList <>();
        highTechItemList.add( new HighTechItem( "Ordinateur Fixe", "computer", 1500 ) );
        highTechItemList.add( new HighTechItem( "Processeur AMDx64", "cpu", 210 ) );
        highTechItemList.add( new HighTechItem( "Processeur I7-7820X", "cpu", 850 ) );
        highTechItemList.add( new HighTechItem( "Clavier-v200", "keyboard", 42 ) );
        
        ListView shopListView = findViewById( R.id.shop_list_view );
        shopListView.setAdapter( new HighTechItemAdapter( this, highTechItemList ) );
    }
}