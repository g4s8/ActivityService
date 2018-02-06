package com.g4s8.activityservicesample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.g4s8.activityservice.ActivityService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));
    }

    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(
            new ActivityService.Wrap(base, this)
        );
    }
}
