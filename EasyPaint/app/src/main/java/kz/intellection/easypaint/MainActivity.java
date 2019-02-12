package kz.intellection.easypaint;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    PaintView paintView;
    Button sub,add,eraser,delete,share;
    TextView paintSizeView;
    int paintSize = 10;
    ImageView c1,c2,c3,c4,c5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        paintView = findViewById(R.id.paintView);

        paintSizeView = findViewById(R.id.size);
        sub = findViewById(R.id.minus);
        add = findViewById(R.id.plus);
        eraser = findViewById(R.id.eraser);
        delete = findViewById(R.id.delete);
        share = findViewById(R.id.share);

        c1 = findViewById(R.id.black);
        c2 = findViewById(R.id.red);
        c3 = findViewById(R.id.yellow);
        c4 = findViewById(R.id.green);
        c5 = findViewById(R.id.blue);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setColor(Color.BLACK);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setColor(Color.RED);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setColor(Color.YELLOW);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setColor(Color.GREEN);
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paintView.setColor(Color.BLUE);
            }
        });




        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        paintView.init(metrics);
    }

    public void onClickMinus(View view){
        paintSize-=4;
        if(paintSize <=1)  paintSize=1;
        paintSizeView.setText(paintSize+"");
        setPaintSize();
    }

    public void onClickPlus(View view){
        paintSize+=4;
        if(paintSize>=60) paintSize=60;
        paintSizeView.setText(paintSize+"");
        setPaintSize();
    }

    public void onClickDelete(View view){
        paintView.clear();
    }

    public void onClickEraser(View view){
        paintView.setColor(Color.WHITE);
    }

    public void setPaintSize(){
        paintView.setBrushSize(paintSize);
    }

}
