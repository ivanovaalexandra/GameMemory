package com.example.secuenceofra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;

public class Activity3 extends AppCompatActivity {

    private TextView tvTimer;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv3;
    private ImageView iv4;
    private ImageView iv5;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Intent intent = getIntent();
        final int sec = intent.getIntExtra("timerNumber",0);

        Button btBack = (Button) findViewById(R.id.btBack);
        tvTimer = (TextView) findViewById(R.id.tvTimer);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        iv5 = (ImageView) findViewById(R.id.iv5);

        setImage(iv1);
        setImage(iv2);
        setImage(iv3);
        setImage(iv4);
        setImage(iv5);



        countDownTimer = new CountDownTimer(sec,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + (millisUntilFinished/1000+1));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(Activity3.this,Activity4.class);
                intent.putExtra("iv1",iv1.getTag().toString());
                intent.putExtra("iv2",iv2.getTag().toString());
                intent.putExtra("iv3",iv3.getTag().toString());
                intent.putExtra("iv4",iv4.getTag().toString());
                intent.putExtra("iv5",iv5.getTag().toString());
                intent.putExtra("timerNumber",sec);

                startActivity(intent);
            }
        };
        countDownTimer.start();

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countDownTimer != null)
                    countDownTimer.cancel();
                Intent intent = new Intent(Activity3.this,Activity2.class);
                startActivity(intent);
            }
        });
    }

    private void setImage(ImageView iv) {
        int randomImage = new Random().nextInt(4)+1;
        switch (randomImage){
            case 1: iv.setImageResource(R.drawable.coin); iv.setTag("coin"); break;
            case 2: iv.setImageResource(R.drawable.scarab); iv.setTag("scarab"); break;
            case 3: iv.setImageResource(R.drawable.statue); iv.setTag("statue"); break;
            case 4: iv.setImageResource(R.drawable.brilliant); iv.setTag("brilliant"); break;
        }

    }

    @Override
    public void onBackPressed() {

        if (countDownTimer != null)
            countDownTimer.cancel();
        Intent intent = new Intent(Activity3.this, Activity2.class);
        startActivity(intent);


    }
}
