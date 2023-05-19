package fr.hamtec.boutiqueinfo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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
    public View getView( int i, View view, ViewGroup parent ) {
        
        view = inflater.inflate( R.layout.adapter_item, null );
        
        HighTechItem currentItem = getItem( i );
        String itemName = currentItem.getName();
        double itemPrice = currentItem.getPrice();
        String mnemonic = currentItem.getMnemonic();
        
        ImageView itemIconView = view.findViewById( R.id.item_icon );
        String resourceName = "item_" + mnemonic + "_icon";
        int resId = context.getResources().getIdentifier( resourceName, "drawable", context.getPackageName( ) );
        itemIconView.setImageResource( resId );
        
        TextView itemNameView = view.findViewById( R.id.item_name );
        itemNameView.setText( itemName );
        
        TextView itemPriceView = view.findViewById( R.id.item_price );
        itemPriceView.setText( itemPrice + " €" );
        
        view.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                
                Toast.makeText( context,"Vous essayez d'acheter un " + itemName + ", pour le prix de " + itemPrice + " €", Toast.LENGTH_LONG ).show();
                
            }
        } );
        
        return view;
    }
}
