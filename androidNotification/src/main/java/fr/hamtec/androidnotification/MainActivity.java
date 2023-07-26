package fr.hamtec.androidnotification;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends AppCompatActivity {
    private Button sendNotice;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        sendNotice = findViewById(R.id.send_notice);
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
            
            NotificationChannel channel= new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager =getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        sendNotice.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                Log.i( "MYLOG", "Merde" );
                String message="Hello hamid Programming Digest";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"My Notification");
                builder.setContentTitle("NotificationTitle");
                builder.setContentText(message);
                builder.setSmallIcon(R.drawable.icon_test);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat=NotificationManagerCompat.from(MainActivity.this);
                Log.i( "MYLOG", "Merde2" );
                managerCompat.notify(1, builder.build());
                Log.i( "MYLOG", "Merde3" );
            }
        });
    }
    
}