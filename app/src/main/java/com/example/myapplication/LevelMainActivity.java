package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LevelMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_1_main);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.level1_1_startbtn:
                Intent intent=new Intent(LevelMainActivity.this,LevelStartActivity.class);
                startActivity(intent);
        }
    }

}
