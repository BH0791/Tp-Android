package fr.hamtec.asynctaskdemo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private ProgressBar progressBar;
    private TextView textViewInfo;
    private Button buttonStart;
    private Button buttonCancel;
    
    private MyAsyncTask myWorkTask;
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        this.progressBar = findViewById( R.id.progressBar );
        this.textViewInfo = findViewById( R.id.textView_info );
        this.buttonStart = findViewById( R.id.button_start );
        this.buttonCancel = findViewById( R.id.button_cancel );
        
        this.buttonStart.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                startWork( );
            }
        } );
        this.buttonCancel.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick( View v ) {
                requestCancel( );
            }
        } );
    }
    private void startWork()  {
        this.myWorkTask = new MyAsyncTask(this.progressBar,
                this.textViewInfo, this.buttonStart, this.buttonCancel);
        
        ParamInfo param = new ParamInfo("Param 1", "Param 2");
        
        this.myWorkTask.execute(param);
    }
    
    private void requestCancel()  {
        if(this.myWorkTask != null)  {
            this.myWorkTask.cancel(true);
        }
    }
}