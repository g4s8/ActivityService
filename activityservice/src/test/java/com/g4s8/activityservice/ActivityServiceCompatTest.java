package com.g4s8.activityservice;

import android.support.v7.app.AppCompatActivity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Test case for {@link ActivityServiceCompat}.
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public final class ActivityServiceCompatTest {
    /**
     * @todo #1:30min android.content.res.Resources$NotFoundException. AppCompatActivity can't be
     *  started properly by robolectric. Looks like it needs custom `AndroidManifest.xml` file
     *  with appcompat theme provided for activity.
     */
    @Test
    @Ignore
    public void retrieveSameActivityInstanceTest() throws Exception {
        final TestActivityCompat activity = Robolectric.setupActivity(TestActivityCompat.class);
        MatcherAssert.assertThat(
            new ActivityServiceCompat(
                new ActivityService.From(activity)
            ).activity(),
            Matchers.<AppCompatActivity>sameInstance(activity)
        );
    }
}
