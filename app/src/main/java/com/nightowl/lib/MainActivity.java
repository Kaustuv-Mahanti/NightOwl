package com.nightowl.lib;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.nightowl.library.NightOwlToggleButton;

public class MainActivity extends AppCompatActivity {

    NightOwlToggleButton nightModeButton;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.rootLayout);
        nightModeButton = findViewById(R.id.nightModeButton);

        final int colorFrom = getResources().getColor(R.color.white);
        final int colorTo = getResources().getColor(R.color.dark);



        nightModeButton.setOnSwitchListener(new NightOwlToggleButton.OnSwitchListener() {
            @Override
            public void onSwitchListener(boolean isNight) {
                if(isNight){
                    animateBackground(colorFrom,colorTo);
                    animateStatusActionBar(getResources().getColor(R.color.colorPrimary),colorTo);
                }else {
                    animateBackground(colorTo,colorFrom);
                    animateStatusActionBar(colorTo,getResources().getColor(R.color.colorPrimary));
                }
            }
        });

    }

    public void animateBackground(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                relativeLayout.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }

    public void animateStatusActionBar(int colorFrom,int colorTo){
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(250); // milliseconds
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                getWindow().setStatusBarColor((int) animator.getAnimatedValue());
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable((int) animator.getAnimatedValue()));
            }

        });
        colorAnimation.start();
    }
}
