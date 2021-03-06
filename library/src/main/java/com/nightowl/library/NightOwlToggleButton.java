package com.nightowl.library;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;


public class NightOwlToggleButton extends RelativeLayout {

    public NightOwlToggleButton(Context context) {
        super(context);
    }

    //Context
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;

    //Views
    protected ImageView switchIV;
    protected CardView switchRL;

    //Listener
    protected OnSwitchListener onSwitchListener;
    private boolean inAnimation=false;

    public NightOwlToggleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    boolean isNight=false;

    public void init(final Context context){
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);

        View rootView = mLayoutInflater.inflate(R.layout.night_mode_button_layout, this, true);
        switchRL = rootView.findViewById(R.id.switchRL);
        switchIV = rootView.findViewById(R.id.switchIV);


        switchRL.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNight && !inAnimation){
                    isNight=false;
                    inAnimation=true;
                    ObjectAnimator
                            .ofFloat(switchIV, "rotation", 0,360)
                            .setDuration(400)
                            .start();
                    ObjectAnimator
                            .ofFloat(switchIV, "translationX", switchRL.getWidth()/2, 0)
                            .setDuration(400)
                            .start();
                    android.os.Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switchIV.setImageDrawable(context.getDrawable(R.drawable.day_icon));
                        }
                    },350);
                    ValueAnimator valueAnimator = ValueAnimator.ofArgb(Color.parseColor("#353535"), Color.parseColor("#dadada"));
                    valueAnimator.setDuration(400);
                    valueAnimator.start();
                    valueAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {

                            inAnimation=false;
                            final Handler handler = new Handler(Looper.getMainLooper());
                            handler.postDelayed(() -> {
                                nightModeButtonClicked(isNight);
                            }, 30);

                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            switchRL.setCardBackgroundColor((int)animation.getAnimatedValue());
                        }
                    });

                }else {

                    if(!inAnimation) {
                        isNight = true;
                        ObjectAnimator
                                .ofFloat(switchIV, "rotation", 360, 0)
                                .setDuration(400)
                                .start();
                        ObjectAnimator
                                .ofFloat(switchIV, "translationX", 0, switchRL.getWidth() / 2)
                                .setDuration(400)
                                .start();
                        ValueAnimator valueAnimator = ValueAnimator.ofArgb(Color.parseColor("#dadada"), Color.parseColor("#353535"));
                        valueAnimator.setDuration(400);
                        valueAnimator.start();
                        valueAnimator.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {

                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {

                                inAnimation = false;
                                final Handler handler = new Handler(Looper.getMainLooper());
                                handler.postDelayed(() -> {
                                    nightModeButtonClicked(isNight);
                                }, 30);
                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            @Override
                            public void onAnimationUpdate(ValueAnimator animation) {
                                switchRL.setCardBackgroundColor((int) animation.getAnimatedValue());
                            }
                        });
                        switchIV.setImageDrawable(context.getDrawable(R.drawable.night_icon));
                    }
                }
            }
        });

    }

    public interface OnSwitchListener{
        public void onSwitchListener(boolean isNight);
    }

    public void setOnSwitchListener(OnSwitchListener onSwitchListener) {
        this.onSwitchListener = onSwitchListener;
    }

    private void nightModeButtonClicked(boolean isNight){
        if(onSwitchListener!=null){
            onSwitchListener.onSwitchListener(isNight);
        }
    }

    public void setToggle(Boolean bool) {
        final Handler mHandler = new Handler(Looper.getMainLooper());
        mHandler.postDelayed(() -> {
            if(!bool){
                isNight=false;
                inAnimation=true;
                ObjectAnimator
                        .ofFloat(switchIV, "rotation", 0,360)
                        .setDuration(400)
                        .start();
                ObjectAnimator
                        .ofFloat(switchIV, "translationX", switchRL.getWidth()/2, 0)
                        .setDuration(400)
                        .start();
                android.os.Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        switchIV.setImageDrawable(mContext.getDrawable(R.drawable.day_icon));
                    }
                },350);
                ValueAnimator valueAnimator = ValueAnimator.ofArgb(Color.parseColor("#353535"), Color.parseColor("#dadada"));
                valueAnimator.setDuration(400);
                valueAnimator.start();
                valueAnimator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        inAnimation=false;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        switchRL.setCardBackgroundColor((int)animation.getAnimatedValue());
                    }
                });

            }else {
                if(!inAnimation) {
                    isNight = true;
                    ObjectAnimator
                            .ofFloat(switchIV, "rotation", 360, 0)
                            .setDuration(400)
                            .start();
                    ObjectAnimator
                            .ofFloat(switchIV, "translationX", 0, switchRL.getWidth() / 2)
                            .setDuration(400)
                            .start();
                    ValueAnimator valueAnimator = ValueAnimator.ofArgb(Color.parseColor("#dadada"), Color.parseColor("#353535"));
                    valueAnimator.setDuration(400);
                    valueAnimator.start();
                    valueAnimator.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            inAnimation = false;
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            switchRL.setCardBackgroundColor((int) animation.getAnimatedValue());
                        }
                    });
                    switchIV.setImageDrawable(mContext.getDrawable(R.drawable.night_icon));
                }
            }
        }, 30);
    }
}
