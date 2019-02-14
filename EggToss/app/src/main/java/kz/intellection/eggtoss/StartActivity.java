package kz.intellection.eggtoss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class StartActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onClickStart(View view){
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);
    }
}
