package kz.intellection.eggtoss;

import android.content.Intent;
import android.graphics.Point;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView basket,egg,lbe,cbe,rbe;
    Button left,center,right;
    int life =4;
    LinearLayout basketLayout,eggLayout;
    RelativeLayout rl;
    float leftPos,centerPos,rightPos,spawnPos;
    int eggPos,score = 0, basketPos = 1;
    CountDownTimer timer;
    TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        basket = findViewById(R.id.basketImg);
        left = findViewById(R.id.leftB);
        center = findViewById(R.id.centerB);
        right = findViewById(R.id.rightB);

        lbe = findViewById(R.id.lBrokenEgg);
        cbe = findViewById(R.id.cBrokenEgg);
        rbe = findViewById(R.id.rBrokenEgg);

        rl = findViewById(R.id.parent);

        basketLayout = findViewById(R.id.basketLayout);
        eggLayout = findViewById(R.id.eggsLp);
        scoreText = findViewById(R.id.scoreText);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        final float screenW = size.x;
        int konst = 0;


        leftPos = (screenW/6) - konst;
        centerPos = (screenW/6)*3 - konst;
        rightPos = (screenW/6)*5 - konst;

        lbe.setVisibility(View.INVISIBLE);
        cbe.setVisibility(View.INVISIBLE);
        rbe.setVisibility(View.INVISIBLE);


        createEgg();

    }

    public  void onClickLeft(View view){
        basket.setX(leftPos-basket.getWidth()/4);
        basketPos = 0;
    }
    public  void onClickCenter(View view){
        basket.setX(centerPos-basket.getWidth()/2);
        basketPos = 1;

    }
    public  void onClickRight(View view){
        basket.setX(rightPos-(basket.getWidth()/4)*3);
        basketPos = 2;
    }



    public void createEgg(){
        rl.removeView(egg);
        Random random = new Random();
        eggPos = random.nextInt(3);

        switch (eggPos){
            case 0:
                spawnPos= leftPos;
                break;
            case 1:
                spawnPos= centerPos;
                break;
            case 2:
                spawnPos= rightPos;
                break;
            default:
                break;
        }

        egg = new ImageView(this);
        egg.setImageResource(R.drawable.egg);
        rl.addView(egg);
        egg.setX(spawnPos);
        egg.setY(-50);
        toss();

    }
    public  void toss(){
        timer = new CountDownTimer(4500,1) {
            @Override
            public void onTick(long millisUntilFinished) {
                egg.setY(egg.getY()+15);
                if((egg.getY()>=basketLayout.getY()+110)&&(egg.getY()<=basketLayout.getY()+150)&&(basketPos==eggPos)) {

                    score += 1;
                    scoreText.setText(score + "");
                    timer.cancel();

                    createEgg();
                }else if(egg.getY() >= basketLayout.getY() + 350){
                    life -= 1;
                    timer.cancel();

                    setLifeImage();

                    System.out.print("setLifeImage");

                    switch (eggPos){
                        case 0:
                            lbe.setVisibility(View.VISIBLE);
                            break;
                        case 1:
                            cbe.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            rbe.setVisibility(View.VISIBLE);
                            break;
                        default:
                            break;
                    }
                    if(life<0){
                        Intent intent = new Intent(getBaseContext(),FinishScreen.class);
                        intent.putExtra("score",score+"");
                        startActivity(intent);
                    }
                    else createEgg();
                }

            }

            @Override
            public void onFinish() {
                rl.removeView(egg);
                createEgg();

            }
        }.start();
    }
    public void setLifeImage(){
        eggLayout.removeAllViews();
        for(int i = 4; i<=0; i--){
            if(life-i < 0){
                createLifeImage(R.drawable.brokenegg);
            }
            else{
                createLifeImage(R.drawable.defaultegg);
            }
        }
    }

    private void createLifeImage(int drawable) {
        ImageView eggLife = new ImageView(this);
        eggLife.setImageResource(drawable);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(2,2,2,2);
        eggLife.setLayoutParams(lp);
        eggLayout.addView(eggLife);

    }
}
