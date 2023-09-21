package fr.hamtec.volleydemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;

import java.util.List;

public class SearchListAdapter extends ArrayAdapter<Movie> {
    private Context context;
    public SearchListAdapter( Context context, List<Movie> movies ) {
        super( context, R.layout.listitem_movie , movies );
        this.context = context;
    }
    
    @NonNull
    @Override
    public View getView( int pos, View convertView,  ViewGroup parent ) {
        
        View view = null;
        if ( convertView == null ){
            LayoutInflater layoutInflater = (LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            view = layoutInflater.inflate( R.layout.listitem_movie, null );
        }else {
            view = convertView;
        }
        
        Movie movie = getItem( pos );
        view.setTag( movie );
        
        TextView titre = view.findViewById( R.id.movie_title );
        TextView dateSortie = view.findViewById( R.id.movie_releaseDate );
        Button detailButton = view.findViewById( R.id.movie_detail );
        
        titre.setText( movie.title );
        dateSortie.setText( movie.releaseDate );
        
        return view;
    }
}
