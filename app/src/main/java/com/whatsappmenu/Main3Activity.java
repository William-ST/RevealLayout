package com.whatsappmenu;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;


import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import io.codetail.widget.RevealFrameLayout;


public class Main3Activity extends AppCompatActivity {

    private LinearLayout mainContent;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mainContent = (LinearLayout) findViewById(R.id.main_content);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_add);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cx = (mainContent.getLeft() + mainContent.getRight()) / 2;
                int cy = (mainContent.getTop() + mainContent.getBottom()) / 2;

                // get the final radius for the clipping circle
                int dx = Math.max(cx, mainContent.getWidth() - cx);
                int dy = Math.max(cy, mainContent.getHeight() - cy);
                float finalRadius = (float) Math.hypot(dx, dy);

                // Androids native animator
//                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(mainContent, cx, cy, 0, finalRadius);
                SupportAnimator animator = ViewAnimationUtils.createCircularReveal(mainContent, cx, cy, 0, mainContent.getHeight());
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.setDuration(1500);
                animator.addListener(new SupportAnimator.AnimatorListener() {
                    @Override
                    public void onAnimationStart() {
                        mainContent.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd() {
//                        startActivity(new Intent(Main3Activity.this, MainActivity.class));
                    }

                    @Override
                    public void onAnimationCancel() {

                    }

                    @Override
                    public void onAnimationRepeat() {

                    }
                });
                animator.start();
            }
        });

    }
}
