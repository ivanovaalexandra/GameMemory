package com.example.secuenceofra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends AppCompatActivity {

    private Button btLevel1;
    private Button btLevel2;
    private Button btLevel3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btBack = (Button) findViewById(R.id.btBack);
        btLevel1 = (Button) findViewById(R.id.btLevel1);
        btLevel2 = (Button) findViewById(R.id.btLevel2);
        btLevel3 = (Button) findViewById(R.id.btLevel3);

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onCheckLevel(View view) {
        int timerNumber = 0;
        switch (view.getId()){
            case R.id.btLevel1: timerNumber = 12*1000; break;
            case R.id.btLevel2: timerNumber = 10*1000; break;
            case R.id.btLevel3: timerNumber = 8*1000; break;
        }
        Intent intent = new Intent(Activity2.this,Activity3.class);
        intent.putExtra("timerNumber",timerNumber);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Activity2.this, MainActivity.class);
        startActivity(intent);

    }

}
