package fr.hamtec.asynctaskdemo;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText time;
    private TextView finalResult;
    private static String TAG = "HB";
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        time = findViewById( R.id.in_time );
        button = findViewById( R.id.btn_run );
        finalResult = findViewById( R.id.tv_result );
        button.setOnClickListener( v -> {
            AsyncTaskRunner runner = new AsyncTaskRunner( );
            String sleepTime = time.getText( ).toString( );
            runner.execute( sleepTime );
            Log.i( TAG, "onCreate: " + sleepTime );
        } );
    }
    
    //--------------------------------------------------------------------------------------------------
    private class AsyncTaskRunner extends AsyncTask < String, String, String > {
        
        private String resp;
        ProgressDialog progressDialog;
        ProgressDialog progressBar;
        
        @Override
        protected String doInBackground( String... params ) {
            publishProgress( "Sleeping..." ); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt( params[ 0 ] ) * 1000;
                
                Thread.sleep( time );
                resp = "Slept for " + params[ 0 ] + " seconds";
            } catch ( InterruptedException e ) {
                e.printStackTrace( );
                resp = e.getMessage( );
            } catch ( Exception e ) {
                e.printStackTrace( );
                resp = e.getMessage( );
            }
            return resp;
        }
        
        
        @Override
        protected void onPostExecute( String result ) {
            // execution of result of Long time consuming operation
            // for exemple-1
            //progressDialog.dismiss( );
            progressBar.dismiss();
            finalResult.setText( result );
        }
        
        
        @Override
        protected void onPreExecute( ) {
            // for exemple-1
            //progressDialog = ProgressDialog.show( MainActivity.this, "ProgressDialog", "Wait for " + time.getText( ).toString( ) + " seconds" );
            Log.i( TAG, "onPreExecute: " + Integer.parseInt( time.getText().toString() ) );
            progressBar = new ProgressDialog(MainActivity.this);
            progressBar.setCancelable(true);
            progressBar.setTitle( "ProgressDialog" );
            progressBar.setMessage("Wait for " + time.getText( ).toString( ) + " seconds");
            progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            //progressBar.setIndeterminate( true );
    
            Drawable drawable = getResources().getDrawable( R.drawable.custom_progressbar );
            
            progressBar.setProgressDrawable( drawable );
            //progressBar.setProgress(1);
            //progressBar.setMax(Integer.parseInt( time.getText().toString() ));
            progressBar.show();
        }
        
        
        @Override
        protected void onProgressUpdate( String... text ) {
            finalResult.setText( text[ 0 ] );
            
        }
    }
}