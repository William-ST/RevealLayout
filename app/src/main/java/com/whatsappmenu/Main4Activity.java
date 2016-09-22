package com.whatsappmenu;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;

import io.codetail.widget.RevealFrameLayout;

public class Main4Activity extends AppCompatActivity {

    private final String TAG = Main4Activity.class.getSimpleName();
    RevealLayout mRevealLayout;
//    View mRevealView;
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        mRevealLayout = (RevealLayout) findViewById(R.id.reveal_layout);
//        mRevealView = findViewById(R.id.reveal_view);
        mFab = (FloatingActionButton) findViewById(R.id.fab_add);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "onClick");
                Log.e(TAG, "mFab.getX(): "+mFab.getX()+ " --- "+mFab.getTranslationX());
                Log.e(TAG, "mFab.getY(): "+mFab.getY()+ " --- "+mFab.getTranslationY());
                mRevealLayout.show((int) mFab.getX() + mFab.getWidth()/2, (int) mFab.getY() + (int)(mFab.getHeight()*1.5), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        mRevealLayout.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        mRevealLayout.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
//                mRevealLayout.show();
                /*
                mRevealLayout.next((int) mRevealLayout.getX(), (int) mRevealLayout.getY(), new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e(TAG, "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.e(TAG, "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e(TAG, "onAnimationRepeat");
                    }
                });
                */
            }
        });

        /*
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRevealLayout.hide();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRevealLayout.show();
                    }
                }, 2000);
            }
        }, 2000);
        */
    }
}
