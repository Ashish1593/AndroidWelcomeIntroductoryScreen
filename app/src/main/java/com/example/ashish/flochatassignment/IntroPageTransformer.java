package com.example.ashish.flochatassignment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ashish on 28/1/18.
 */


public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        // Get the page index from the tag. This makes
        // it possible to know which page index you're
        // currently transforming - and that can be used
        // to make some important performance improvements.
        int pagePosition = (int) page.getTag();

        // Here you can do all kinds of stuff, like get the
        // width of the page and perform calculations based
        // on how far the user has swiped the page.
        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        // Now it's time for the effects
        if (position <= -1.0f || position >= 1.0f) {

            // The page is not visible. This is a good place to stop
            // any potential work / animations you may have running.

        } else if (position == 0.0f) {
            if(pagePosition == 1) {
               ImageView circleImage = page.findViewById(R.id.circle_image);
                Glide.with(page.getContext())
                        .asGif()
                        .load(R.raw.notes)
                        .into(circleImage);
            }
            // The page is selected. This is a good time to reset Views
            // after animations as you can't always count on the IntroPageTransformer
            // callbacks to match up perfectly.

        } else {

            // The page is currently being scrolled / swiped. This is
            // a good place to show animations that react to the user's
            // swiping as it provides a good user experience.

            // Let's start by animating the title.
            // We want it to fade as it scrolls out

            if(pagePosition == 1){

                FrameLayout circleImage = page.findViewById(R.id.circle);
//                RotateAnimation rotate = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotate.setDuration(5000);
//                rotate.setInterpolator(new LinearInterpolator());
//
//                circleImage.startAnimation(rotate);
                circleImage.setRotation(-pageWidthTimesPosition / 2f);
     }
            if(pagePosition ==2) {
                ImageView title = page.findViewById(R.id.circle1);
                title.setTranslationX(-pageWidthTimesPosition / 2f);
                title.setAlpha(1.0f - absPosition);

                // Now the description. We also want this one to
                // fade, but the animation should also slowly move
                // down and out of the screen
                ImageView description = page.findViewById(R.id.circle2);
                description.setTranslationX(-pageWidthTimesPosition / 2f);
                description.setAlpha(1.0f - absPosition);

                // Now, we want the image to move to the right,
                // i.e. in the opposite direction of the rest of the
                // content while fading out
                View computer = page.findViewById(R.id.circle3);

                // We're attempting to create an effect for a View
                // specific to one of the pages in our ViewPager.
                // In other words, we need to check that we're on
                // the correct page and that the View in question
                // isn't null.
//                if (pagePosition == 0 && computer != null) {
//                    computer.setAlpha(1.0f - absPosition);
//                    computer.setTranslationX(-pageWidthTimesPosition * 1.5f);
//                }
            }

            // Finally, it can be useful to know the direction
            // of the user's swipe - if we're entering or exiting.
            // This is quite simple:
            if (position < 0) {
                // Create your out animation here
            } else {
                // Create your in animation here
            }
        }
    }

}