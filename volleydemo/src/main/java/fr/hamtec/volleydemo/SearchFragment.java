package fr.hamtec.volleydemo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RequestQueue requestQueue;
    private ListView searchList;
    
    class SearchListAdapter extends ArrayAdapter < Movie > {
        private Context context;
        
        public SearchListAdapter( Context context, List < Movie > movies ) {
            super( context, R.layout.listitem_movie, movies );
            this.context = context;
        }
        
        @NonNull
        @Override
        public View getView( int pos, View convertView, ViewGroup parent ) {
            
            View view = null;
            if ( convertView == null ) {
                LayoutInflater layoutInflater = ( LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                view = layoutInflater.inflate( R.layout.listitem_movie, null );
            } else {
                view = convertView;
            }
            
            Movie movie = getItem( pos );
            view.setTag( movie );
            
            TextView titre = view.findViewById( R.id.movie_title );
            TextView dateSortie = view.findViewById( R.id.movie_releaseDate );
            Button detailButton = view.findViewById( R.id.movie_detail );
            
            Button closeButton = view.findViewById( R.id.movie_closeDetail );
            RelativeLayout detailLayout = view.findViewById( R.id.movie_detailLayout );
            NetworkImageView detailposter = view.findViewById( R.id.movie_poster );
            TextView detailplot = view.findViewById( R.id.movie_plot );
            
            titre.setText( movie.title );
            dateSortie.setText( movie.releaseDate );
            
            detailButton.setOnClickListener( v -> {
                detailLayout.setVisibility( View.VISIBLE );
                detailButton.setVisibility( View.GONE );
                //Log.i( "JSON", "detailButton : " + movie.moviId + " : " + movie.title );
                String api_key = "62d96ef75676fba47c537de195f1b3c6";
                String url = String.format( "http://api.themoviedb.org/3/movie/%s?api_key=%s&language=fr-FR", movie.movieId, api_key );
                JsonObjectRequest jsonObjectRequest;
                jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        response -> {
                            Log.i( "JSON", "jsonObjectRequest : " + response.optString( "title" ) );
                        },
                        error -> {
                        
                        } );
                RequestQueue requestQueue = Volley.newRequestQueue( getActivity( ) );
                requestQueue.add( jsonObjectRequest );
                //new SearchFragment().getRequestQueue().add(jsonObjectRequest);
                // A Suivre...
            } );
            
            
            closeButton.setOnClickListener( v -> {
                detailLayout.setVisibility( View.GONE );
                detailButton.setVisibility( View.VISIBLE );
            } );
            
            
            return view;
        }
        //**
    }
    
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        super.onCreateView( inflater, container, savedInstanceState );
        
        View view = inflater.inflate( R.layout.fragment_search, null );
        searchList = view.findViewById( R.id.search_List );
        searchText = view.findViewById( R.id.search_queryText );
        searchButton = view.findViewById( R.id.search_queryLaunch );
        searchButton.setOnClickListener( v -> launchSearch( ) );
        
        return view;
    }
    
    private void launchSearch( ) {
        try {
            String api_key = "62d96ef75676fba47c537de195f1b3c6";
            String title = URLEncoder.encode( searchText.getText( ).toString( ), "UTF-8" );
            String url = String.format( "https://api.themoviedb.org/3/search/movie?api_key=%s&query=%s&language=fr-FR", api_key, title );
            
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    jsonRequestListener,
                    errorListener
            );
            getRequestQueue( ).add( request );
        } catch ( UnsupportedEncodingException ex ) {
            ex.printStackTrace( );
        }
    }
    
    RequestQueue getRequestQueue( ) {
        if ( requestQueue == null )
            requestQueue = Volley.newRequestQueue( getActivity( ) );
        return requestQueue;
    }
    
    private Response.Listener < JSONObject > jsonRequestListener = response -> {
        try {
            ArrayList < Movie > listOfMovies = new ArrayList <>( );
            JSONArray jsonArray = response.getJSONArray( "results" );
            
            for ( int i = 0; i < jsonArray.length( ); i++ ) {
                JSONObject jsonObject = jsonArray.getJSONObject( i );
                Movie movie = new Movie( );
                movie.title = jsonObject.getString( "title" );
                movie.releaseDate = jsonObject.getString( "release_date" );
                movie.movieId = jsonObject.getString( "id" );
                movie.overview = jsonObject.getString( "overview" );
                listOfMovies.add( movie );
            }
            
            SearchListAdapter1 searchListAdapter = new SearchListAdapter1( getActivity( ), listOfMovies );
            searchList.setAdapter( searchListAdapter );
            
            Log.i( "JSON", "==>  " + listOfMovies.size( ) );
            
        } catch ( JSONException ex ) {
            Log.e( "JSON", ex.getLocalizedMessage( ) );
        }
    };
    private Response.ErrorListener errorListener = error -> {
    
    };
    
    public class SearchListAdapter1 extends ArrayAdapter < Movie > {
        private Context context;
        
        public SearchListAdapter1( Context context, List < Movie > movies ) {
            super( context, R.layout.listitem_movie, movies );
            this.context = context;
        }
        
        @NonNull
        @Override
        public View getView( int pos, View convertView, ViewGroup parent ) {
            
            View view = null;
            if ( convertView == null ) {
                LayoutInflater layoutInflater = ( LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
                view = layoutInflater.inflate( R.layout.listitem_movie, null );
            } else {
                view = convertView;
            }
            
            Movie movie = getItem( pos );
            view.setTag( movie );
            
            TextView titre = view.findViewById( R.id.movie_title );
            TextView dateSortie = view.findViewById( R.id.movie_releaseDate );
            Button detailButton = view.findViewById( R.id.movie_detail );
            
            Button closeButton = view.findViewById( R.id.movie_closeDetail );
            RelativeLayout detailLayout = view.findViewById( R.id.movie_detailLayout );
            NetworkImageView detailposter = view.findViewById( R.id.movie_poster );
            TextView detailplot = view.findViewById( R.id.movie_plot );
            
            titre.setText( movie.title );
            dateSortie.setText( movie.releaseDate );


            detailButton.setOnClickListener( v -> {
                detailLayout.setVisibility( View.VISIBLE );
                detailButton.setVisibility( View.GONE );
                String api_key = "62d96ef75676fba47c537de195f1b3c6";
                String url = String.format( "https://api.themoviedb.org/3/movie/%s?api_key=%s&language=fr-FR", movie.movieId, api_key );

                JsonObjectRequest jsonObjectRequest;
                jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        response -> {
                    try {

                        String posterPath = response.getString( "poster_path" );
                        String plot = response.getString( "overview" );
                        //detailPlot.setText( plot );
                        Log.e( "JSON", response.getString( "title" ) );

                        String url1 = "https://image.tmdb.org/t/p/w500/" + posterPath;
                        //detailPoster.setImageUrl( url, getImageLoader( ) );

                    } catch ( JSONException e ) {
                        Log.e( "JSON", e.getLocalizedMessage( ) );
                    }
                },
                        error -> Log.e( "JSON", error.getLocalizedMessage( ) )
                );

                getRequestQueue( ).add( jsonObjectRequest );

            } );
            
            closeButton.setOnClickListener( v -> {
                detailLayout.setVisibility( View.GONE );
                detailButton.setVisibility( View.VISIBLE );
            } );
            
            
            return view;
        }
        
        
    }
}
