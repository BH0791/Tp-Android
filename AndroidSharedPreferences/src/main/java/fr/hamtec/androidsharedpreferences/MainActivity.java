package fr.hamtec.androidsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarSound ;
    private SeekBar seekBarBrightness;
    
    private RadioGroup radioGroupDiffLevel;
    private RadioButton radioButtonEasy;
    private RadioButton radioButtonMedium;
    private RadioButton radioButtonHard;
    
    private Button buttonSave;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        seekBarBrightness= findViewById(R.id.seekBar_brightness);
        seekBarSound= findViewById(R.id.seekBar_sound);
        
        seekBarBrightness.setMax(100);
        seekBarSound.setMax(100);
        
        radioGroupDiffLevel= findViewById(R.id.radioGroup_diffLevel);
        radioButtonEasy=findViewById(R.id.radioButton_easy);
        
        radioButtonMedium = findViewById(R.id.radioButton_medium);
        radioButtonHard=findViewById(R.id.radioButton_hard);
        
        buttonSave = findViewById(R.id.button_save);
        
        buttonSave.setOnClickListener( view -> {
            
            //MainActivity.this.doSave(view);
            doSave( view );
        } );
        
        loadGameSetting();
        
    }
    
    private void loadGameSetting(){
        SharedPreferences sharedPreferences= this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        
        if(sharedPreferences != null){
            
            int brightness = sharedPreferences.getInt("brightness", 90);
            int sound = sharedPreferences.getInt("sound",95);
            int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", R.id.radioButton_medium);
            
            seekBarSound.setProgress(sound);
            seekBarBrightness.setProgress(brightness);
            radioGroupDiffLevel.check(checkedRadioButtonId);
            
        }else {
            this.radioGroupDiffLevel.check(R.id.radioButton_medium);
            Toast.makeText(this,"Utiliser les paramètres de jeu par défaut",Toast.LENGTH_LONG).show();
        }
    
    
    }
    
    //Appelé lorsque l'utilisateur clique sur le bouton Enregistrer.
    public void doSave(View view)  {
        
        
        SharedPreferences sharedPreferences = getSharedPreferences( "gameSetting", Context.MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();
        
        editor.putInt("brightness", seekBarBrightness.getProgress());
        editor.putInt( "sound", seekBarBrightness.getProgress() );
        
        // ID du bouton
        int checkedRadioButtonId = radioGroupDiffLevel.getCheckedRadioButtonId();
        editor.putInt( "checkedRadioButtonId", checkedRadioButtonId );
        
        //Sauvegarder
        editor.apply();
        
        Toast.makeText( this, "Game Setting saved", Toast.LENGTH_LONG ).show( );
        
    }
    
    
}