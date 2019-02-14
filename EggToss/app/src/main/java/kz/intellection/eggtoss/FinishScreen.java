package kz.intellection.eggtoss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinishScreen extends AppCompatActivity {
    TextView scoreText;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_screen);

        scoreText = findViewById(R.id.scoreTextView);
        restart = findViewById(R.id.restartBtn);

        String result = getIntent().getStringExtra("score");
        scoreText.setText(result);
    }

    public void onclickRestart(View view){
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);

    }
}
