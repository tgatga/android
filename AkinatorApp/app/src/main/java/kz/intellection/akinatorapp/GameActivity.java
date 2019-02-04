package kz.intellection.akinatorapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    TextView textView, yourNum;
    Button moreBtn, lessBtn, equalBtn,update;
    ImageView imageView;
    int left=0,right=100,middle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        textView = findViewById(R.id.text);
        yourNum = findViewById(R.id.number);
        moreBtn = findViewById(R.id.more);
        lessBtn = findViewById(R.id.less);
        equalBtn = findViewById(R.id.equal);
        imageView = findViewById(R.id.akinator);
        update = findViewById(R.id.update);
        makeGuess();

    }
    public void onClickBig(View view){
        binarySearch(true);
        imageView.setImageResource(R.drawable.think);
    }

    public void onClickSmall(View view){
        binarySearch(false);
        imageView.setImageResource(R.drawable.think);
    }

    public void onClickYes(View view){
        equalBtn.setVisibility(View.INVISIBLE);
        lessBtn.setVisibility(View.INVISIBLE);
        moreBtn.setVisibility(View.INVISIBLE);
        imageView.setImageResource(R.drawable.happy);
    }

    public void onClickUp(View view){
        equalBtn.setVisibility(View.VISIBLE);
        lessBtn.setVisibility(View.VISIBLE);
        moreBtn.setVisibility(View.VISIBLE);

        imageView.setImageResource(R.drawable.akinator);
        left = 0;
        right = 100;
    }

    public void makeGuess(){
        middle=(right+left)/2;
        yourNum.setText(middle+"");
    }
    public void binarySearch(Boolean isRight){
        if(isRight){
            left = middle+1;
        }
        else{
            right=middle-1;
        }
        makeGuess();
    }

}
