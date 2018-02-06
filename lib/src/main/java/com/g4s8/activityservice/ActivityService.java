package com.g4s8.activityservice;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.NonNull;

/**
 * Activity as a service.
 * <p>
 * Purposed to be used in view-based apps.
 * <br>
 * {@link ActivityService} will help to obtain current {@link Activity} instance
 * from {@link Context} via {@link ActivityService.From} without class casting.
 * <p>
 * How to use:
 * <ol>
 * <li>
 * Attach activity service in {@link Activity#attachBaseContext(Context)}:
 * <pre>
 * protected void attachBaseContext(final Context base) {
 *   super.attachBaseContext(
 *     new ActivityService.Wrap(base, this)
 *   );
 *  }
 *     </pre>
 * </li>
 * <li>
 * Retrieve {@link Activity} instance in any other place (with same base {@link Context}):
 * <pre>
 * final Activity activity = new ActivityService.From(context).activity();
 *     </pre>
 * </li>
 * </ol>
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @see ActivityServiceCompat
 * @since 0.1
 */
@SuppressWarnings("WeakerAccess")
public interface ActivityService {

    @NonNull
    Activity activity();

    final class Wrap extends ContextWrapper implements ActivityService {

        static final String NAME = "com.g4s8.activityservice.ActivityService#NAME";

        private final Activity activity;

        public Wrap(@NonNull final Context base, @NonNull final Activity activity) {
            super(base);
            this.activity = activity;
        }

        @Override
        public Object getSystemService(final String name) {
            if (ActivityService.Wrap.NAME.equals(name)) {
                return this;
            } else {
                return super.getSystemService(name);
            }
        }

        @NonNull
        @Override
        public Activity activity() {
            return this.activity;
        }
    }

    final class From implements ActivityService {

        private final Context ctx;

        public From(@NonNull final Context context) {
            this.ctx = context;
        }

        @SuppressLint("WrongConstant")
        @NonNull
        @Override
        public Activity activity() {
            return ActivityService.class.cast(
                this.ctx.getSystemService(ActivityService.Wrap.NAME)
            ).activity();
        }
    }
}
