package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LevelFinishActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_1_finish); //xml , java 소스 연결

    }
    public void onClick(View v){

        switch (v.getId()){
            case R.id.level1_1_restart:
                Intent intent =new Intent(LevelFinishActivity.this,MainActivity.class);
                startActivity(intent);
        }
    }
}
