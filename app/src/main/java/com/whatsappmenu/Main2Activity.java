package com.whatsappmenu;

import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;


import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;


public class Main2Activity extends AppCompatActivity {

    private String TAG = Main2Activity.class.getSimpleName();
    private View myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myView = findViewById(R.id.awesome_card);

        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "setOnClickListener");
                // get the center for the clipping circle
                Log.e(TAG, "left: "+myView.getLeft());
                Log.e(TAG, "getRight: "+myView.getRight());
                Log.e(TAG, "getTop: "+myView.getTop());
                Log.e(TAG, "getBottom: "+myView.getBottom());
                int cx = (myView.getLeft() + myView.getRight()) / 2;
                int cy = (myView.getTop() + myView.getBottom()) / 2;

                // get the final radius for the clipping circle
                int dx = Math.max(cx, myView.getWidth() - cx);
                int dy = Math.max(cy, myView.getHeight() - cy);
                float finalRadius = (float) Math.hypot(dx, dy);

                // Androids native animator
                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1500);
                animator.start();
            }
        });

    }
}
