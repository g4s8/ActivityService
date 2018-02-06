package com.g4s8.activityservice;

import android.app.Activity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Test case for {@link ActivityService}.
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class ActivityServiceTest {
    @Test
    public void retrieveSameActivityInstanceTest() throws Exception {
        final TestActivity activity = Robolectric.setupActivity(TestActivity.class);
        MatcherAssert.assertThat(
            new ActivityService.From(activity).activity(),
            Matchers.<Activity>sameInstance(activity)
        );
    }
}
