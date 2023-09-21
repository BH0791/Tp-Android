package fr.hamtec.volleydemo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RequestQueue requestQueue;
    private ListView searchList;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {
        super.onCreateView( inflater, container, savedInstanceState );
        
        View view = inflater.inflate( R.layout.fragment_search, null );
        searchList = view.findViewById( R.id.search_List );
        searchText = view.findViewById( R.id.search_queryText );
        searchButton = view.findViewById( R.id.search_queryLaunch );
        searchButton.setOnClickListener( v -> launchSearch() );
        
        return view;
    }
    private void launchSearch( ) {
        try {
            String api_key = "62d96ef75676fba47c537de195f1b3c6";
            String title = URLEncoder.encode( searchText.getText().toString(), "UTF_8" );
            String url = String.format( "https://api.themoviedb.org/3/search/movie?api_key=%s&query=%s&language=fr-FR", api_key, title );
            
            JsonObjectRequest request = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    jsonRequestListener,
                    errorListener
            );
            getRequestQueue().add( request );
        }catch ( UnsupportedEncodingException ex ){
            ex.printStackTrace();
        }
    }
    RequestQueue getRequestQueue(){
        if ( requestQueue == null )
            requestQueue = Volley.newRequestQueue( getActivity() );
        return requestQueue;
    }
    private Response.Listener< JSONObject > jsonRequestListener = response -> {
        try {
            ArrayList<Movie> listOfMovies = new ArrayList <>();
            JSONArray jsonArray = response.getJSONArray( "results" );
            
            for ( int i = 0; i < jsonArray.length( ); i++ ) {
                JSONObject jsonObject = jsonArray.getJSONObject( i );
                Movie movie = new Movie();
                movie.title = jsonObject.getString( "title" );
                movie.releaseDate = jsonObject.getString( "release_date" );
                movie.moviId = jsonObject.getString( "id" );
                movie.overview = jsonObject.getString( "overview" );
                listOfMovies.add( movie );
            }
            
            SearchListAdapter searchListAdapter = new SearchListAdapter( getActivity(), listOfMovies );
            searchList.setAdapter( searchListAdapter );
            
            Log.i( "JSON", "==>  " + listOfMovies.size() );
            
        }catch ( JSONException ex ){
            Log.e( "JSON", ex.getLocalizedMessage( ) );
        }
    };
    private Response.ErrorListener errorListener =  error -> {
    
    };
}
