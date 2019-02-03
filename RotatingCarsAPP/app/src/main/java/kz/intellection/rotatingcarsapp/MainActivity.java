package kz.intellection.rotatingcarsapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView image1, image2, image3, image4, image5;
    Button button;
    boolean isClicked = true;
    Timer timer = new Timer();
    TimerTask timerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.c1);
        image2 = findViewById(R.id.c2);
        image3 = findViewById(R.id.c3);
        image4 = findViewById(R.id.c4);


        Drawable temp1 = image1.getDrawable();
        Drawable temp2 = image2.getDrawable();
        Drawable temp3 = image3.getDrawable();
        Drawable temp4 = image4.getDrawable();

        final Drawable temps[] = {temp1,temp2,temp3,temp4};
        final ImageView images[] = {image1,image2,image3,image4};

        button = findViewById(R.id.next);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (isClicked) {
                        button.setText("stop");
                        timerTask = new TimerTask() {
                            @Override
                            public void run() {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {

                                        images[0].setImageDrawable(temps[temps.length - 1]);

                                        for (int i = images.length - 1; i > 0; i--) {
                                            images[i].setImageDrawable(temps[i - 1]);
                                        }

                                        image5 = images[0];

                                        for (int i = 0; i < images.length - 1; i++) {
                                            images[i] = images[i + 1];
                                        }
                                        images[images.length - 1] = image5;
                                    }
                                });
                            }
                        };
                        timer.schedule(timerTask, 0, 2000);
                    }

                    else{
                        timer.cancel();
                        button.setText("timer");
                    }
                    isClicked=!isClicked;
                }
            });


        images[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < images.length - 1; i++) {
                    images[i].setImageDrawable(temps[i + 1]);
                }
                images[images.length - 1].setImageDrawable(temps[0]);

                image5=images[images.length-1];

                for (int i = images.length - 1; i >0; i--) {
                    images[i]=images[i-1];
                }

                images[0]=image5;
            }
        });

        images[images.length-1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                images[0].setImageDrawable(temps[temps.length-1]);

                for(int i = images.length-1; i>0;i--){
                    images[i].setImageDrawable(temps[i-1]);
                }

                image5=images[0];

                for (int i = 0; i < images.length-1 ; i++) {
                    images[i]=images[i+1];
                }

                images[images.length - 1]=image5;
            }
        });
    }
}
