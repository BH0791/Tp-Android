package fr.hamtec.premierfragement;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Il est également important de préciser qu'un fragment doit toujours avoir un constructeur vide implémenté par défaut.
 */
public class MainFragement extends Fragment {
    public MainFragement( ) {
    }
    
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        return inflater.inflate( R.layout.fragment_main, container, false );
    }
}