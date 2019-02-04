package kz.intellection.taro;

import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String prof[] = {"Doctor","Engineer","Programmer","Police officer","Lawyer","Designer"};

    Button button, buttonSP;
    TextView textView;
    Random random;
    ImageView imageView;
    boolean isClicked = true;
    public CountDownTimer timer;
    int images[] = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.randB);
        buttonSP = findViewById(R.id.start);
        textView = findViewById(R.id.text);
        imageView = findViewById(R.id.profImg);

        random = new Random();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    taro();
            }
        });


        buttonSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isClicked){
                    buttonSP.setText("Stop");
                    until();
                }
                else{
                    buttonSP.setText("Start");
                    timer.cancel();
                }
                isClicked = !isClicked;
            }
        });


    }
    public void taro(){
        int num = random.nextInt(20);
        button.setEnabled(false);
        timer = new CountDownTimer((num*100+1),30) {
            @Override
            public void onTick(long millisUntilFinished) {

                int profNum = random.nextInt(prof.length);
                textView.setText(prof[profNum]);
                imageView.setImageResource(images[profNum]);

            }

            @Override
            public void onFinish() {
                button.setEnabled(true);

            }

        }.start();

    }
    public void until(){
        int num = random.nextInt(20);

        timer = new CountDownTimer((num*10000+1),30) {
            @Override
            public void onTick(long millisUntilFinished) {

                int profNum = random.nextInt(prof.length);
                textView.setText(prof[profNum]);
                imageView.setImageResource(images[profNum]);

            }

            @Override
            public void onFinish() {


            }

        }.start();

    }






}
