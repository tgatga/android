package kz.intellection.spydetector;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NameActivity extends AppCompatActivity {

    EditText name;
    Button start;
    public static String playerName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        name = findViewById(R.id.name);
        start = findViewById(R.id.start);
    }

    public void onClickStart(View view){
        playerName = name.getText().toString();

        Intent intent;
        intent = new Intent(NameActivity.this, MainActivity.class);
        startActivity(intent);
    }


}
