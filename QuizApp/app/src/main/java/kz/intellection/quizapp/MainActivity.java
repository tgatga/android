package kz.intellection.quizapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView image1,image2,image3,image4;
    TextView questionNumber,question;
    Button next;
    int currentQ = 0;

    String questions[] = {"Популярный мессенджер", "Можно написать в direct","Найти мероприятия" };
    int pictures[][] = {R.drawable.facebook,R.drawable.telegram,R.drawable.instagram,R.drawable.whatsapp};
    int answers[] = {R.drawable.facebook,R.drawable.instagram,R.drawable.facebook};

    ArrayList<ImageView> images;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1 = findViewById(R.id.img1);
        image2 = findViewById(R.id.img2);
        image3 = findViewById(R.id.img3);
        image4 = findViewById(R.id.img4);

        questionNumber = findViewById(R.id.qNum);
        question = findViewById(R.id.question);

        next = findViewById(R.id.nextBtn);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(image1);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(image2);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(image3);
            }
        });
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(image4);
            }
        });

        images = new ArrayList<>();
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupNextQ();
            }
        });
        next.setEnabled(false);
        setupNextQ();

    }
    public void checkAnswer(ImageView answer){

    }

    public void  setupNextQ(){
        setImageClickable();
        next.setEnabled(true);
        question.setText(questions[currentQ]);
        questionNumber.setText("Вопрос "+currentQ+1);

        for(int i = 0; i<pictures.length;i++){
            Drawable a = getDrawable(pictures[currentQ][i]);
            images.get(i).setImageDrawable(a);
            images.

        }
    }

    public void setImageClickable(boolean flag){

    }
}
