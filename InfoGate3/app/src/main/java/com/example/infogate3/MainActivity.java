package com.example.infogate3;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{

//   animation
    private static final int SPLASH_DURATION = 4000; // 4 seconds
    private TextView splashText;
//    end



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        animation
        splashText = findViewById(R.id.splashText);
        // Start the character-by-character animation
        animateText();
        // Delay for splash screen duration and navigate to the main activity
        splashText.postDelayed(() ->
        {
            // Add your code to navigate to the main activity
            startActivity(new Intent(MainActivity.this, Scan.class));
            finish();
        }, SPLASH_DURATION);
//        end


    }





//    animation
    private void animateText()
    {
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(splashText, "alpha", 0f, 1f);
        fadeIn.setDuration(1500);

        ObjectAnimator charByChar = ObjectAnimator.ofObject(
                splashText,
                "text",
                new CharacterEvaluator(),
                "INFO GATE");
        charByChar.setDuration(4000);

        fadeIn.start();
        charByChar.start();
    }
//     Custom TypeEvaluator to animate text character by character
    private static class CharacterEvaluator implements android.animation.TypeEvaluator<String>
{
        @Override
        public String evaluate(float fraction, String startValue, String endValue)
        {
            int length = Math.round(startValue.length() * fraction);
            return endValue.substring(0, length);
        }
    }
    //end

}

