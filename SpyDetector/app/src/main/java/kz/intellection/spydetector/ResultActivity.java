package kz.intellection.spydetector;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ResultActivity extends AppCompatActivity {

    TextView scoreText,players;
    int f,s,t = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        scoreText = findViewById(R.id.score);
        players = findViewById(R.id.players);

        String lastPlayers = "";
        lastPlayers = readFromFile(this);
        System.out.print(lastPlayers);

        scoreText.setText(""+MainActivity.score);

        players.setText(lastPlayers);
        writeToFile(NameActivity.playerName+" - "+MainActivity.score+"\n",getApplicationContext());

    }

    public void onClickRestart(View view){
        Intent intent;
        intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
        MainActivity.score = 0;
    }

    public static void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter os = new OutputStreamWriter(context.openFileOutput("myfile.txt", Context.MODE_PRIVATE));
            os.write(data);
            os.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("myfile.txt");

            if ( inputStream != null ) {
                InputStreamReader in = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(in);

                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return ret;
    }


}
