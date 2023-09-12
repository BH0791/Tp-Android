package fr.hamtec.asynctaskdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText time;
    private TextView finalResult;
    private static String TAG = "HB";
    
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        time = findViewById(R.id.in_time);
        button = findViewById(R.id.btn_run);
        finalResult = findViewById(R.id.tv_result);
        button.setOnClickListener( v -> {
            AsyncTaskRunner runner = new AsyncTaskRunner();
            String sleepTime = time.getText().toString();
            String toto = "tête de con";
            runner.execute(sleepTime, toto);
            Log.i( TAG, "onCreate: " + sleepTime );
        } );
    }
    
    private class AsyncTaskRunner extends AsyncTask <String, String, String> {
        
        private String resp;
        ProgressDialog progressDialog;
        
        @Override
        protected String doInBackground(String... params) {
            Log.i( TAG, "doInBackground: " + params[0] + " => " + params[1] );
            publishProgress("Sleeping...", "COUCOU"); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0])*1000;
                
                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            return resp;
        }
        
        
        @Override
        protected void onPostExecute(String result) {
            // execution of result of Long time consuming operation
            progressDialog.dismiss();
            finalResult.setText(result);
        }
        
        
        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this,"ProgressDialog","Wait for "+time.getText().toString()+ " seconds");
        }
        
        
        @Override
        protected void onProgressUpdate(String... text) {
            finalResult.setText(text[0]);
            Log.i( TAG, "onProgressUpdate: " + text[0] + " => text[1] = " + text[1]);
        }
    }
}