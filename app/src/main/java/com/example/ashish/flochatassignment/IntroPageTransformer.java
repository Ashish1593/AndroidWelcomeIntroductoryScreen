package com.example.ashish.flochatassignment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by ashish on 28/1/18.
 */


public class IntroPageTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {

        int pagePosition = (int) page.getTag();

        int pageWidth = page.getWidth();
        float pageWidthTimesPosition = pageWidth * position;
        float absPosition = Math.abs(position);

        if (position <= -1.0f || position >= 1.0f) {

        } else if (position == 0.0f) {
            if (pagePosition == 1) {
                ImageView circleImage = page.findViewById(R.id.circle_image);
                Glide.with(page.getContext())
                        .asGif()
                        .load(R.raw.notes)
                        .into(circleImage);
            }

        } else {
            if (pagePosition == 0) {
                ImageView image1 = page.findViewById(R.id.image1);
                image1.setTranslationX(-pageWidthTimesPosition / 7f);
                image1.setAlpha(1.0f - absPosition);

                ImageView image2 = page.findViewById(R.id.image2);
                image2.setTranslationX(pageWidthTimesPosition / 6f);
                image2.setAlpha(1.0f - absPosition);

                ImageView image3 = page.findViewById(R.id.image3);
                image3.setTranslationX(-pageWidthTimesPosition / 2f);
                image3.setAlpha(1.0f - absPosition);

                ImageView image4 = page.findViewById(R.id.image4);
                image4.setTranslationX(pageWidthTimesPosition / 1f);
                image4.setAlpha(1.0f - absPosition);

                ImageView image5 = page.findViewById(R.id.image5);
                image5.setTranslationX(-pageWidthTimesPosition / 6f);
                image5.setAlpha(1.0f - absPosition);

                ImageView image6 = page.findViewById(R.id.image6);
                image6.setTranslationX(pageWidthTimesPosition / 6f);
                image6.setAlpha(1.0f - absPosition);

                ImageView image7 = page.findViewById(R.id.image7);
                image7.setTranslationX(-pageWidthTimesPosition / 4f);
                image7.setAlpha(1.0f - absPosition);

            }

            if (pagePosition == 1) {
                FrameLayout circleImage = page.findViewById(R.id.circle);
                circleImage.setRotation(-pageWidthTimesPosition / 7f);
            }
            if (pagePosition == 2) {
                ImageView circle1 = page.findViewById(R.id.circle4);
                circle1.setTranslationX(pageWidthTimesPosition / 4f);
                circle1.setAlpha(1.0f - absPosition);

                LinearLayout ll2 = page.findViewById(R.id.ll1);
                ll2.setTranslationX(pageWidthTimesPosition / 2f);
                ll2.setAlpha(1.0f - absPosition);

                ImageView circle2 = page.findViewById(R.id.circle2);
                circle2.setTranslationX(pageWidthTimesPosition / 1f);
                circle2.setAlpha(1.0f - absPosition);

                ImageView circle6 = page.findViewById(R.id.circle6);
                circle6.setTranslationX(pageWidthTimesPosition / 1.5f);
                circle6.setAlpha(1.0f - absPosition);
            }
        }
    }

}