package fr.hamtec.boutiqueinfo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import fr.hamtec.boutiqueinfo.R;
import fr.hamtec.boutiqueinfo.models.HighTechItem;

import java.util.List;

public class HighTechItemAdapter extends BaseAdapter {
    
    private Context context;
    private List< HighTechItem > highTechItemList;
    private LayoutInflater inflater;
    
    public HighTechItemAdapter( Context context, List < HighTechItem > highTechItemList ) {
        this.context = context;
        this.highTechItemList = highTechItemList;
        this.inflater = LayoutInflater.from( context );
    }
    
    @Override
    public int getCount( ) {
        return highTechItemList.size();
    }
    
    @Override
    public HighTechItem getItem( int position ) {
        return highTechItemList.get( position );
    }
    
    @Override
    public long getItemId( int position ) {
        return 0;
    }
    
    @Override
    public View getView( int position, View view, ViewGroup parent ) {
        
        view = inflater.inflate( R.layout.adapter_item, null );
        
        return view;
    }
}
