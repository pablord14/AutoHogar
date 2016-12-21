package com.autohogar.autohogar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ConnectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(2000);  //Delay of 2 seconds
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(ConnectionActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        welcomeThread.start();

        //cuando se conecte al servidor termina el ConnectionActivity
        //findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }
}
