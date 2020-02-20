package com.example.secuenceofra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class Activity4 extends AppCompatActivity {

    private String imageType;
    private LinearLayout layout;
    private int timerNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        Intent intent = getIntent();

        timerNumber = intent.getIntExtra("timerNumber",0);

        TextView tvQuestion = (TextView) findViewById(R.id.tvQuestion);
        layout = (LinearLayout) findViewById(R.id.layout);

        int randomQuestion = new Random().nextInt(5)+1;
        switch (randomQuestion){
            case 1: tvQuestion.setText("Which  figure stood first in a row?");
                    imageType = intent.getStringExtra("iv1");
                    break;
            case 2: tvQuestion.setText("Which  figure stood second in a row?");
                    imageType = intent.getStringExtra("iv2");
                    break;
            case 3: tvQuestion.setText("Which  figure stood third in a row?");
                    imageType = intent.getStringExtra("iv3");
                    break;
            case 4: tvQuestion.setText("Which  figure stood fourth in a row?");
                    imageType = intent.getStringExtra("iv4");
                    break;
            case 5: tvQuestion.setText("Which  figure stood fifth in a row?");
                    imageType = intent.getStringExtra("iv5");
                    break;
        }

    }

    public void onClickImageButton(View view) {
        LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        if (view.getTag().equals(imageType)){
            View pop = inflater.inflate(R.layout.pop_true,null);
            PopupWindow popupWindow = new PopupWindow(pop, RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT,false);

            Button btContinue = (Button) pop.findViewById(R.id.btContinue);
            btContinue.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity4.this,Activity2.class);
                    startActivity(intent);
                }
            });
            popupWindow.showAtLocation(layout,Gravity.CENTER,0,0);
        }
        else{
            View pop = inflater.inflate(R.layout.pop_false,null);
            PopupWindow popupWindow = new PopupWindow(pop,LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT,false);

            Button btRetry = (Button) pop.findViewById(R.id.btRetry);
            btRetry.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Activity4.this,Activity3.class);
                    intent.putExtra("timerNumber",timerNumber);
                    startActivity(intent);
                }
            });
            popupWindow.showAtLocation(layout, Gravity.CENTER,0,0);

        }
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Activity4.this, Activity3.class);
        intent.putExtra("timerNumber", timerNumber);
        startActivity(intent);


    }
}
