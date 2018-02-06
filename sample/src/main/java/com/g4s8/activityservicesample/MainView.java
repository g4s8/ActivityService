package com.g4s8.activityservicesample;

import android.content.Context;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import com.g4s8.activityservice.ActivityService;

/**
 * @author Kirill (g4s8.public@gmail.com)
 * @version $Id$
 */
public final class MainView extends FrameLayout {

    private final Button btn;
    private final ActivityService activityService;

    public MainView(@NonNull final Context context) {
        super(context);
        this.activityService = new ActivityService.From(getContext());
        final View self = View.inflate(getContext(), R.layout.v_home, this);
        btn = self.findViewById(R.id.btn);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                final Point size = new Point();
                activityService.activity()
                    .getWindowManager()
                    .getDefaultDisplay()
                    .getSize(size);
                btn.setText(size.toString());
            }
        });
    }
}
