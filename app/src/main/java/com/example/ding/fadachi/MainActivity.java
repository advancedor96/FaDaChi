package com.example.ding.fadachi;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer ring;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
    }

    public void play(View view) {
        if(ring != null){
            ring.release();
            ring = null;
        }
        ring= MediaPlayer.create(MainActivity.this,R.raw.bible);
        ring.start();
    }
    public void stop(View view) {
        if(ring != null){
            ring.release();
            ring = null;
        }
    }

    public void clickKao(View view) {
        ValueAnimator moveY = ObjectAnimator.ofFloat(textView, "translationY", 0, -700f);
        moveY.setDuration(1000);
        ObjectAnimator fontSizeBigger = ObjectAnimator.ofFloat(textView, "textSize", 10, 60);
        fontSizeBigger.setDuration(1000);
        ObjectAnimator opacity = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0.01f);
        opacity.setDuration(1500);


        AnimatorSet fadachi = new AnimatorSet();
        fadachi.play(moveY).with(fontSizeBigger).with(opacity);
        fadachi.start();

    }
}
