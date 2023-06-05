package fr.hamtec.progressbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private Button buttonStart1;
    private Button buttonStart2;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    
    private TextView textViewInfo1;
    private TextView textViewInfo2;
    
    private Handler handler = new Handler();
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        
        this.progressBar1 = this.findViewById(R.id.progressBar1);
        this.progressBar2 = this.findViewById(R.id.progressBar2);
        this.progressBar2.setIndeterminate(false);
        
        this.textViewInfo1 = this.findViewById(R.id.textView_info1);
        this.textViewInfo2 = this.findViewById(R.id.textView_info2);
        
        
        this.buttonStart1 = this.findViewById(R.id.button_start1);
        this.buttonStart2 = this.findViewById(R.id.button_start2);
        
        this.buttonStart1.setOnClickListener( v -> doStartProgressBar1() );
        this.buttonStart2.setOnClickListener( v -> doStartProgressBar2() );
        
    }
    
//    private void doStartProgressBar1()  {
//        final int MAX = 110;
//        this.progressBar1.setMax(MAX);
//
//        Thread thread = new Thread(new Runnable()  {
//
//            @Override
//            public void run() {
//                handler.post(new Runnable() {
//                    public void run() {
//                        buttonStart1.setEnabled(false);
//                    }
//                });
//                for( int i =0; i < MAX; i++) {
//                    final int progress = i + 1;
//                    // Do something (Download, Upload, Update database,..)
//                    SystemClock.sleep(20); // Sleep 20 milliseconds.
//
//                    // Update interface.
//                    handler.post(new Runnable() {
//                        public void run() {
//                            progressBar1.setProgress(progress);
//                            int percent = (progress * 100) / MAX;
//
//                            textViewInfo1.setText("Percent: " + percent + " %");
//                            if(progress == MAX)  {
//                                textViewInfo1.setText("Completed!");
//                                buttonStart1.setEnabled(true);
//                            }
//                        }
//                    });
//                }
//            }
//        });
//        thread.start();
//    }
    
    private void doStartProgressBar1()  {
        final int MAX = 110;
        this.progressBar1.setMax(MAX);
        
        Thread thread = new Thread( ( ) -> {
            handler.post( ( ) -> buttonStart1.setEnabled(false) );
            for( int i =0; i < MAX; i++) {
                final int progress = i + 1;
                // Do something (Download, Upload, Update database,..)
                SystemClock.sleep(20); // Sleep 20 milliseconds.
                
                // Update interface.
                handler.post( ( ) -> {
                    progressBar1.setProgress(progress);
                    int percent = (progress * 100) / MAX;
                    
                    textViewInfo1.setText("Percent: " + percent + " %");
                    if(progress == MAX)  {
                        textViewInfo1.setText("Completed!");
                        buttonStart1.setEnabled(true);
                    }
                } );
            }
        } );
        thread.start();
    }
    
//    private void doStartProgressBar2()  {
//        this.progressBar2.setIndeterminate(true);
//
//        Thread thread = new Thread(new Runnable()  {
//
//            @Override
//            public void run() {
//                // Update interface
//                handler.post(new Runnable() {
//                    public void run() {
//                        textViewInfo2.setText("Working...");
//                        buttonStart2.setEnabled(false);
//                    }
//                });
//                // Do something ... (Update database,..)
//                SystemClock.sleep(5000); // Sleep 5 seconds.
//
//                progressBar2.setIndeterminate(false);
//                progressBar2.setMax(1);
//                progressBar2.setProgress(1);
//
//                // Update interface
//                handler.post(new Runnable() {
//                    public void run() {
//                        textViewInfo2.setText("Completed!");
//                        buttonStart2.setEnabled(true);
//                    }
//                });
//            }
//        });
//        thread.start();
//    }
private void doStartProgressBar2()  {
    this.progressBar2.setIndeterminate(true);
    
    Thread thread = new Thread( ( ) -> {
        
        // Update interface
        handler.post( ( ) -> {
            textViewInfo2.setText("Working...");
            buttonStart2.setEnabled(false);
        } );
        
        
        // Do something ... (Update database,..)
        SystemClock.sleep(5000); // Sleep 5 seconds.
        
        progressBar2.setIndeterminate(false);
        progressBar2.setMax(1);
        progressBar2.setProgress(1);
        
        // Update interface
        handler.post( ( ) -> {
            textViewInfo2.setText("Completed!");
            buttonStart2.setEnabled(true);
        } );
    } );
    thread.start();
}
}