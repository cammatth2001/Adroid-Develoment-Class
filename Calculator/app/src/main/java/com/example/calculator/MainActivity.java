package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private EditText Scr;
    private ButtonClickListener bttnClick;
    private double NumberBF;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        Scr = (EditText) findViewById(R.id.tvResult);
        Scr.setEnabled(false);
        int ViewList[] = {R.id.subtract, R.id.nine, R.id.eight, R.id.seven, R.id.clear, R.id.six, R.id.five, R.id.four, R.id.three, R.id.two, R.id.one, R.id.one, R.id.subtract, R.id.posneg
                R.id.equals, R.id.add, R.id.multiply, R.id.divid};

        for (int bttn : ViewList)
        {
            View v = (View) findViewById(bttn);
            v.setOnClickListener(bttnClick);
        }
    }
    private class ButtonClickListener implements OnClickListener
    {
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.clear:
                    Scr.setText("0");
                    NumberBF = 0;
                    operation = "";
                    break;
                case R.id.add:
                    MathFunction("+");
                    break;
                case R.id.subtract:
                    MathFunction("-");
                    break;
                case R.id.divid:
                    MathFunction("/");
                    break;
                case R.id.multiply:
                    MathFunction("*");
                    break;
                case R.id.one:
                    String num1;
                    num1 = ((Button)v).getText().toString();
                    InputNumber(num1);
                    break;
                case R.id.two:
                    String num2;
                    num2 = ((Button)v).getText().toString();
                    InputNumber(num2);
                    break;
                case R.id.three:
                    String num3;
                    num3 = ((Button)v).getText().toString();
                    InputNumber(num3);
                    break;
                case R.id.four:
                    String num4;
                    num4 = ((Button)v).getText().toString();
                    InputNumber(num4);
                    break;
                case R.id.five:
                    String num5;
                    num5 = ((Button)v).getText().toString();
                    InputNumber(num5);
                    break;
                case R.id.six:
                    String num6;
                    num6 = ((Button)v).getText().toString();
                    InputNumber(num6);
                    break;
                case R.id.seven:
                    String num7;
                    num7 = ((Button)v).getText().toString();
                    InputNumber(num7);
                    break;
                case R.id.eight:
                    String num8;
                    num8 = ((Button)v).getText().toString();
                    InputNumber(num8);
                    break;
                case R.id.nine:
                    String num9;
                    num9 = ((Button)v).getText().toString();
                    InputNumber(num9);
                    break;
                case R.id.zero:
                    String num0;
                    num0 = ((Button)v).getText().toString();
                    InputNumber(num0);
                    break;
                case R.id.equals:
                    mathResult();
                    break;
                case R.id.decimal:
                    Scr.setText(".");
                    break;

            }//switch
        }//onclick
        public void MathFunction(String str)
        {

        }
        public void mathResult()
        {

        }
        public void InputNumber(String str)
        {
            String valueEntered = Scr.getText().toString();
            if(valueEntered.equals("0"))
            {
                valueEntered = "0";
            }else
            {
                valueEntered += str;
            }
            Scr.setText(valueEntered);
        }
    }//button click class

}








