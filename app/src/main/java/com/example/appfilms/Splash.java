package com.example.appfilms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread chrono = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(4000);
                }catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }finally
                {
                    Intent intent =new Intent(Splash.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        chrono.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    
}
