package com.example.infogate3;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



//    //animation 2
//    private static final int SPLASH_DURATION = 5000; // 2 seconds
//    private TextView splashText;
//    private String fullText = "INFO GATE";
//    private int currentTextLength = 0;
//
//    private Handler handler = new Handler();
//    //end 2



//   animation
    private static final int SPLASH_DURATION = 4000; // 4 seconds
    private TextView splashText;
//    end



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
////        animation 2
//        splashText = findViewById(R.id.splashText);
//
//        // Start the character-by-character animation and fade-in
//        animateTextAndFade();
//
//        // Delay for splash screen duration and navigate to the main activity
//        splashText.postDelayed(() -> {
//            // Add your code to navigate to the main activity
//            startActivity(new Intent(MainActivity.this, UserLogin.class));
//            finish();
//        }, SPLASH_DURATION);
////        end 2
        




//        animation
        splashText = findViewById(R.id.splashText);
        // Start the character-by-character animation
        animateText();
        // Delay for splash screen duration and navigate to the main activity
        splashText.postDelayed(() -> {
            // Add your code to navigate to the main activity
            startActivity(new Intent(MainActivity.this, UserLogin.class));
            finish();
        }, SPLASH_DURATION);
//        end



//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(MainActivity.this, UserLogin.class));
//                finish();
//            }
//        },4100);
    }





////animation 2
//private void animateTextAndFade() {
//    // Fade-in animation
//    handler.postDelayed(() -> fadeTextIn(1500), 500);
//
//    // Character-by-character animation
//    handler.postDelayed(this::animateText, 2000);
//}
//
//    private void fadeTextIn(long duration) {
//        ValueAnimator fadeIn = ValueAnimator.ofFloat(0f, 1f);
//        fadeIn.setDuration(duration);
//
//        fadeIn.addUpdateListener(animation -> {
//            float alpha = (float) animation.getAnimatedValue();
//            splashText.setAlpha(alpha);
//        });
//
//        fadeIn.start();
//    }
//
//    private void animateText() {
//        ValueAnimator charByChar = ValueAnimator.ofInt(0, fullText.length());
//        charByChar.setDuration(2000);
//
//        charByChar.addUpdateListener(animation -> {
//            int value = (int) animation.getAnimatedValue();
//            splashText.setText(fullText.substring(0, value));
//        });
//
//        charByChar.start();
//    }
////end 2





//    animation
    private void animateText() {
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
    private static class CharacterEvaluator implements android.animation.TypeEvaluator<String> {
        @Override
        public String evaluate(float fraction, String startValue, String endValue) {
            int length = Math.round(startValue.length() * fraction);
            return endValue.substring(0, length);
        }
    }
    //end

}

