package kz.intellection.spydetector;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    TextView timeText,nameText,colorText,resultView;
    LinearLayout hand;
    Button yesBtn, noBtn;
    public static int score = 0;

    CountDownTimer timer;


    int[] colors = {Color.RED,Color.BLACK,Color.BLUE,Color.GREEN,Color.YELLOW,Color.GRAY};
    String[] colorNames = {"RED","BLACK","BLUE","GREEN","YELLOW","GRAY"};

    int leftColorIndex,rightColorIndex,leftTextIndex,rightTextIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.timeText);
        resultView = findViewById(R.id.result);
        nameText = findViewById(R.id.colorName);
        colorText = findViewById(R.id.colorColor);
        hand = findViewById(R.id.hand);

        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);

        updateView();

        timer = new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timeText.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timeText.setText("done!");

                Intent intent;
                intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        }.start();

    }

    public void yesBtnClicked(View view){
        if(leftColorIndex == rightTextIndex){
            correct();
            score+=1;
        }
        else incorrect();
    }

    public void noBtnClicked(View view){
        if(leftColorIndex != rightTextIndex){
            correct();
            score+=1;
        }
        else incorrect();
    }

    private void correct() {

        resultView.setBackgroundResource(R.drawable.good);
        updateView();
    }

    private void incorrect() {

        resultView.setBackgroundResource(R.drawable.bad);
        updateView();
    }

    public void updateView(){

        Random random = new Random();

        leftColorIndex = random.nextInt(colorNames.length);
        String leftTextColor = colorNames[leftColorIndex];
        nameText.setText(leftTextColor);

        leftTextIndex= random.nextInt(colors.length);
        int leftColor = colors[leftTextIndex];
        nameText.setTextColor(leftColor);

        rightColorIndex = random.nextInt(colorNames.length);
        String rightTextColor = colorNames[rightColorIndex];
        colorText.setText(rightTextColor);

        rightTextIndex= random.nextInt(colors.length);
        int rightColor = colors[rightTextIndex];
        colorText.setTextColor(rightColor);

    }



}
