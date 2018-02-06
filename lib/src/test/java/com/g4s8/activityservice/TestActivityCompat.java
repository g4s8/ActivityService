package com.g4s8.activityservice;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * AppCompatActivity for test.
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestActivityCompat extends AppCompatActivity {
    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(
            new ActivityService.Wrap(base, this)
        );
    }
}
