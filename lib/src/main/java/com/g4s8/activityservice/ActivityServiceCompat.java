package com.g4s8.activityservice;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

/**
 * App-compat activity service.
 * <p>
 * For use with {@link AppCompatActivity}.
 * <p>
 * Wrap base {@link ActivityService} with {@link ActivityServiceCompat}
 * to retrieve {@link AppCompatActivity} instance:
 * <pre>
 * final AppCompatActivity activity = new ActivityServiceCompat(
 *   new ActivityService.From(context)
 * ).activity();
 * </pre>
 *
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 * @see ActivityService
 * @since 0.1
 */
public class ActivityServiceCompat implements ActivityService {
    /**
     * Origin service.
     */
    private final ActivityService origin;

    /**
     * Ctor.
     *
     * @param origin Origin service
     */
    public ActivityServiceCompat(final ActivityService origin) {
        this.origin = origin;
    }

    @NonNull
    @Override
    public AppCompatActivity activity() {
        return AppCompatActivity.class.cast(origin.activity());
    }
}
