package com.raywenderlich.rocketlaunch.animationactivities;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;

import com.raywenderlich.rocketlaunch.R;

public class LaunchRocketValueAnimatorAnimationActivity extends BaseAnimationActivity {
  @Override
  protected void onStartAnimation() {

      slv.setScaleX(2.0f);
      slv.setScaleY(2.0f);

      ValueAnimator animator = ValueAnimator.ofFloat(0, 360);


      animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
          @Override
          public void onAnimationUpdate(ValueAnimator animation) {
              float value = (float) animation.getAnimatedValue();
              // 2
              slv.setRotation(value);
          }
      });

      animator.setInterpolator(new LinearInterpolator());
      animator.setDuration(700);
      animator.setRepeatCount(ValueAnimator.INFINITE);
      animator.start();

//
//      ObjectAnimator anim = ObjectAnimator.ofFloat(mRocket,"scaleX", 0.5f,2.0f);
//      anim.setRepeatCount(ValueAnimator.INFINITE);
//      ObjectAnimator anim1 = ObjectAnimator.ofFloat(mRocket,"scaleY", 0.5f,2.0f);
//      anim1.setRepeatCount(ValueAnimator.INFINITE);
//      AnimatorSet rocketAnimatorSet = new AnimatorSet();
//      rocketAnimatorSet.playTogether(anim, anim1);
//      rocketAnimatorSet.setDuration(1000);
//      //rocketAnimatorSet.start();
//
//
//      ObjectAnimator anim2 = ObjectAnimator.ofFloat(mRocket1,"scaleX",0.0f, 2.0f);
//      anim2.setRepeatCount(ValueAnimator.INFINITE);
//      ObjectAnimator anim3 = ObjectAnimator.ofFloat(mRocket1,"scaleY",0.0f, 2.0f);
//      anim3.setRepeatCount(ValueAnimator.INFINITE);
//      AnimatorSet rocketAnimatorSet1 = new AnimatorSet();
//      ////rocketAnimatorSet1.setStartDelay(300);
//      rocketAnimatorSet1.playTogether(anim2, anim3);
//      rocketAnimatorSet1.setDuration(700);
//      //rocketAnimatorSet1.start();
//
//      AnimatorSet bothAnimatorSet = new AnimatorSet();
//      bothAnimatorSet.playTogether(rocketAnimatorSet, rocketAnimatorSet1);
//      bothAnimatorSet.setDuration(1000);
//
//      bothAnimatorSet.start();





      // cann also try https://github.com/skyfishjy/android-ripple-background
      AnimatorSet set1a =
              (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.scale);
      set1a.setTarget(mRocket);




      AnimatorSet set1b =
              (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fade);
      set1b.setTarget(mRocket);

      AnimatorSet set1c = new AnimatorSet();

      set1c.playTogether(set1a, set1b);

      mRocket.setVisibility(View.GONE);


      AnimatorSet set2a =
              (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.scale1);
      set2a.setTarget(mRocket1);



      AnimatorSet set2b =
              (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.fade);

      set2b.setTarget(mRocket1);

      AnimatorSet set2c = new AnimatorSet();
      set2c.setStartDelay(200);

      //set2c.play(set2a). set2b);




      // Initialize a new ObjectAnimator
      final ObjectAnimator scaleXAnimation = ObjectAnimator.ofFloat(
              mRocket1, // Target object
              "scaleX", // Property
              2.0f // ending value
      );

      // Initialize another new ObjectAnimator
      final ObjectAnimator scaleYAnimation = ObjectAnimator.ofFloat(
              mRocket1, // Target object
              "scaleY", // Property
              2.0f // ending value
      );




      scaleYAnimation.addListener(new Animator.AnimatorListener() {
          @Override
          public void onAnimationStart(Animator animation) {
              mRocket1.setAlpha(1.0f);
          }

          @Override
          public void onAnimationEnd(Animator animation) {

              // Initialize another new ObjectAnimator
              final ObjectAnimator fadeAnimation = ObjectAnimator.ofFloat(
                      mRocket1, // Target object
                      "alpha", // Property
                      1.0f, 0.0f // ending value
              );
              fadeAnimation.setDuration(800);

              fadeAnimation.addListener(new Animator.AnimatorListener() {
                  @Override
                  public void onAnimationStart(Animator animation) {

                  }

                  @Override
                  public void onAnimationEnd(Animator animation) {





                      scaleXAnimation.setStartDelay(1200);
                      scaleYAnimation.setStartDelay(1200);
                      scaleYAnimation.start();
                      scaleXAnimation.start();

                  }

                  @Override
                  public void onAnimationCancel(Animator animation) {

                  }

                  @Override
                  public void onAnimationRepeat(Animator animation) {

                  }
              });
              fadeAnimation.start();


          }

          @Override
          public void onAnimationCancel(Animator animation) {

          }

          @Override
          public void onAnimationRepeat(Animator animation) {

          }
      });
      //scaleXAnimation.setRepeatCount(ObjectAnimator.INFINITE);
      //scaleYAnimation.setRepeatCount(ObjectAnimator.INFINITE);
      //fadeAnimation.setRepeatCount(ObjectAnimator.INFINITE);

      AnimatorSet set3 = new AnimatorSet();
      set3.play(scaleXAnimation).with(scaleYAnimation);

      //set3.play(scaleYAnimation).before(fadeAnimation);

      //set3.setDuration(1300);
      set3.start();



  }
}
