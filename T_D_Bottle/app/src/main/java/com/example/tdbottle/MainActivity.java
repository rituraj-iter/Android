package com.example.tdbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    ImageView imageView;
    int last_position;
    boolean spin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.bottle);
    }
    public void Bottle(View view) {
        if (!spin) {
            int new_position = 10000+(random.nextInt(10000));
            float fix_loc_X = (float)imageView.getWidth()/2;
            float fix_loc_Y = (float)imageView.getHeight()/2;
            Animation rotate = new RotateAnimation(last_position, new_position, fix_loc_X, fix_loc_Y);
            rotate.setDuration(5000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }
                @Override
                public void onAnimationEnd(Animation animation) {
                    spin = false;
                }
                @Override
                public void onAnimationRepeat(Animation animation) {
                }
            });
            last_position = new_position;
            imageView.startAnimation(rotate);
        }
    }
}