package com.g4s8.activityservice;

import android.app.Activity;
import android.content.Context;

/**
 * Activity for test.
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TestActivity extends Activity {
    @Override
    protected void attachBaseContext(final Context base) {
        super.attachBaseContext(
            new ActivityService.Wrap(base, this)
        );
    }
}
