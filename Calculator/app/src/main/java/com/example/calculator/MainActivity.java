package com.example.calculator;

import android.media.VolumeShaper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import static android.view.View.OnClickListener;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private double NumberBf;
    private String operation;
    private EditText Scr;
    private ButtonClickListener bttnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Scr = (EditText) findViewById(R.id.tvResult);
        Scr.setEnabled(false);
        bttnClick = new ButtonClickListener();

        int ViewList[] = {R.id.subtract, R.id.nine, R.id.eight, R.id.seven, R.id.TipCalc,
                R.id.clear, R.id.six, R.id.five, R.id.four, R.id.three, R.id.two, R.id.one,
                R.id.one, R.id.subtract,R.id.equals, R.id.add, R.id.multiply, R.id.divid};

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
                    NumberBf = 0;
                    operation = "";
                    break;
                case R.id.decimal:
                    Scr.setText(".");
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
                case R.id.equals:
                    mathResult();
                    break;
                case R.id.TipCalc:
                    Intent intent = new Intent(MainActivity.this, TipCalc.class);
                    startActivity(intent);
                    break;
                case R.id.one:
                case R.id.two:
                case R.id.three:
                case R.id.four:
                case R.id.five:
                case R.id.six:
                case R.id.seven:
                case R.id.eight:
                case R.id.nine:
                case R.id.zero:
                    String number ;
                    number = ((Button)v).getText().toString();
                    InputNumber(number);
                    break;



            }//switch
        }//onclick
        public void MathFunction(String str)
        {
            NumberBf = Float.parseFloat(Scr.getText().toString());
            operation= str;
            Scr.setText("0");
        }
        public void mathResult()
        {
            float NumAf = Float.parseFloat(Scr.getText().toString());
            double result = 0;
            if (operation.equals("+"))
            {
                result = NumberBf + NumAf;
            }
            else if(operation.equals("-"))
            {
                result = NumberBf - NumAf;
            }
            else if(operation.equals("*"))
            {
                result = NumberBf * NumAf;
            }
            else if(operation.equals("/"))
            {
                result = NumberBf / NumAf;
            }
            Scr.setText(String.valueOf(result));
        }
        public void InputNumber(String str)
        {
            String valueEntered = Scr.getText().toString();
            if(valueEntered.equals("0"))
                valueEntered = "";


                valueEntered += str;
            Scr.setText(valueEntered);
        }
    }//button click class

}








