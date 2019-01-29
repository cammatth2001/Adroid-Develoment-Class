package com.example.myinfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    ImageView pictView;
    Button pictButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pictButton=(Button) findViewById(R.id.Button);
        pictView = (ImageView) findViewById(R.id.ImageView);
        textView = (TextView) findViewById(R.id.TextView);
        pictButton.setOnClickListener(new buttonAction());
    }
    private class buttonAction implements Button.OnClickListener
        {
            public void onClick(View v)
            {
                pictView.setImageResource(R.drawable.flowers);
                String info = getString(R.string.myName);
                textView.setText(" Hello " + info);
                pictView.setVisibility(View.VISIBLE);
            }
    }




}
