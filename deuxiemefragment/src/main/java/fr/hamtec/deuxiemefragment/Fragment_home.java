package fr.hamtec.deuxiemefragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fragment_home extends Fragment {
    
    TextView txt;
    
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState ) {
        
        View view = inflater.inflate( R.layout.frag_home , null);
        txt = view.findViewById( R.id.frag_message );
        
        
        return view;
    }
}
