package kz.intellection.switchcolor;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RelativeLayout relativeLayout;
    Button button1, button2, button3;
    boolean click=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.relativeLayout);
        button1 = findViewById(R.id.bronze);
        button2 = findViewById(R.id.silver);
        button3 = findViewById(R.id.gold);
        click = false;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bronze = Color.argb(255,204, 165, 46);
                button1.setBackgroundColor(bronze);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int green = Color.argb(255, 64, 204, 45);
                int blue = Color.argb(255, 45, 145, 204);
                button2.setBackgroundColor(blue);
                relativeLayout.setBackgroundColor(green);
            }
        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int blue = Color.argb(255, 45, 145, 204);
                int red = Color.argb(255, 255, 68, 58);

                if(click){
                    button3.setBackgroundColor(red);
                    relativeLayout.setBackgroundColor(blue);

                }
                else{
                    button3.setBackgroundColor(blue);
                    relativeLayout.setBackgroundColor(red);

                }
                click = !click;
            }
        });
    }
}
