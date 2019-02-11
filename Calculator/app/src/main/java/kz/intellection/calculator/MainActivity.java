package kz.intellection.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView editText,tvResult;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bPlus,bMinus,bMulti,bDiv,bEqual,bAC;
    String sign="";
    int num1,num2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        tvResult=findViewById(R.id.tvResult);
        b0=findViewById(R.id.b0);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);

        bPlus=findViewById(R.id.bPlus);
        bMinus=findViewById(R.id.bMinus);
        bMulti=findViewById(R.id.bMulti);
        bDiv=findViewById(R.id.bDiv);
        bEqual=findViewById(R.id.bEqual);
        bAC=findViewById(R.id.bAC);

        b0.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        bMulti.setOnClickListener(this);
        bMinus.setOnClickListener(this);
        bDiv.setOnClickListener(this);
        bPlus.setOnClickListener(this);
        bAC.setOnClickListener(this);
        bEqual.setOnClickListener(this);

    }

    public void onClick(View view){

        switch (view.getId()) {
            case R.id.b0:
                tvResult.append("0");
                break;
            case R.id.b1:
                tvResult.append("1");
                break;
            case R.id.b2:
                tvResult.append("2");
                break;
            case R.id.b3:
                tvResult.append("3");
                break;
            case R.id.b4:
                tvResult.append("4");
                break;
            case R.id.b5:
                tvResult.append("5");
                break;
            case R.id.b6:
                tvResult.append("6");
                break;
            case R.id.b7:
                tvResult.append("7");
                break;
            case R.id.b8:
                tvResult.append("8");
                break;
            case R.id.b9:
                tvResult.append("9");
                break;

            case R.id.bPlus:
                if (!tvResult.getText().toString().isEmpty()) {
                    sign = "+";
                    num1 = Integer.parseInt(tvResult.getText().toString());
                    tvResult.setText("");
                    editText.setText(num1 + sign+"");
                }
                break;

            case R.id.bMinus:
                if (!tvResult.getText().toString().isEmpty()) {
                    sign = "-";
                    num1 = Integer.parseInt(tvResult.getText().toString());
                    tvResult.setText("");
                    editText.setText(num1 + sign+"");
                }
                break;

            case R.id.bMulti:
                if (!tvResult.getText().toString().isEmpty()) {
                    sign = "*";
                    num1 = Integer.parseInt(tvResult.getText().toString());
                    tvResult.setText("");
                    editText.setText(num1 + sign+"");
                }
                break;

            case R.id.bDiv:
                if (!tvResult.getText().toString().isEmpty()) {
                    sign = "/";
                    num1 = Integer.parseInt(tvResult.getText().toString());
                    tvResult.setText("");
                    editText.setText(num1 + sign+"");
                }
                break;

            case R.id.bAC:
                tvResult.setText("");
                editText.setText("");
                break;

            case R.id.bEqual:
                num2 = Integer.parseInt(tvResult.getText().toString());
                if(sign.equals("+")){
                    int result = num1 + num2;
                    editText.setText(num1 + "" + sign + num2 + "");
                    tvResult.setText(result + "");
                }else if(sign.equals("-")){
                    int result = num1 - num2;
                    editText.setText(num1 + "" + sign + num2 + "");
                    tvResult.setText(result + "");
                }else if(sign.equals("/")){
                    int result = num1 / num2;
                    editText.setText(num1 + "" + sign + num2 + "");
                    tvResult.setText(result + "");
                }else if(sign.equals("*")){
                    int result = num1 * num2;
                    editText.setText(num1 + "" + sign + num2 + "");
                    tvResult.setText(result + "");
                }
        }

    }
}
