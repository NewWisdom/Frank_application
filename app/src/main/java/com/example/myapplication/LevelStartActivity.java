package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class LevelStartActivity extends AppCompatActivity {

    ProgressBar mProgressBar,mProgressBar_1,mProgressBar_2,mProgressBar_3,mProgressBar_4,mProgressBar_5,mProgressBar_6;
    CountDownTimer mCountDownTimer,mCountDownTimer_txt;
    ViewFlipper v_flipper;
    TextView txt,timer_txt;

    //변경해주어야하는 변수들 배열에 넣음
    int images[]={R.drawable.level1_1_1,R.drawable.level1_1_2,R.drawable.level1_1_3,
            R.drawable.level1_1_4,R.drawable.level1_1_5,R.drawable.level1_1_6};
    int times[]={20000,20000,20000,10000,10000,30000};
    String strings[]={"플랭크","무릎플랭크","팔을 편 무릎 플랭크","무릎 꿇은 측면 플랭크 왼쪽","무릎 꿇은 측면 플랭크 오른쪽","코브라 스트레칭"};
    ArrayList<ProgressBar> progresses=new ArrayList<ProgressBar>();


    float i=0;
    float count=20000;
    long counttxt=20000;

    int countindex=0;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_1_start);

        v_flipper=findViewById(R.id.level1_1_img);
        //이미지 개수만큼 뷰플리퍼실행
        txt=(TextView)findViewById(R.id.level1_1_1_txt);
        timer_txt=(TextView)findViewById(R.id.timertxt);

        for(int image:images){
            flipperImage(image);
        }


        //프로그레스바 관련
        mProgressBar=(ProgressBar)findViewById(R.id.level1_1_1_progress);
        mProgressBar_1=(ProgressBar)findViewById(R.id.level1_1_1_progress_1);
        mProgressBar_2=(ProgressBar)findViewById(R.id.level1_1_1_progress_2);
        mProgressBar_3=(ProgressBar)findViewById(R.id.level1_1_1_progress_3);
        mProgressBar_4=(ProgressBar)findViewById(R.id.level1_1_1_progress_4);
        mProgressBar_5=(ProgressBar)findViewById(R.id.level1_1_1_progress_5);
        mProgressBar_6=(ProgressBar)findViewById(R.id.level1_1_1_progress_6);
        progresses.add(mProgressBar_1);
        progresses.add(mProgressBar_2);
        progresses.add(mProgressBar_3);
        progresses.add(mProgressBar_4);
        progresses.add(mProgressBar_5);
        progresses.add(mProgressBar_6);


        mProgressBar.setProgress((int)i);
        mProgressBar_1.setProgress((int)i);
        
        mCountDownTimer=new CountDownTimer((int)count,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.v("Log_tag", "Tick of Progress"+ i+ millisUntilFinished);
                i=i+((100/count)*1000);
                mProgressBar.setProgress((int)i);
                progresses.get(countindex).setProgress((int)i);
                txt.setText(strings[countindex]);
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                //Do what you want
                i=i+((100/count)*1000);
                mProgressBar.setProgress((int)i);
                mProgressBar_1.setProgress((int)i);
                i=0;
                countindex++;
                if(countindex==6){
                    Intent intent = new Intent (LevelStartActivity.this, LevelFinishActivity.class);
                    startActivity(intent); //다음화면으로 넘어감
                }else{
                    mCountDownTimer.start();
                }

            }
            public void updateCountDownText(){
                int minutes=(int)(count/1000)/60;
                int seconds=(int)(count/1000)%60;
                String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                timer_txt.setText(timeLeftFormatted);
            }

        };
        mCountDownTimer.start();

        mCountDownTimer_txt=new CountDownTimer(counttxt,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                counttxt=millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {

                if(countindex==6){

                }else{
                    mCountDownTimer_txt.start();
                }

            }
            public void updateCountDownText(){
                int minutes=(int)(counttxt/1000)/60;
                int seconds=(int)(counttxt/1000)%60;
                String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
                timer_txt.setText(timeLeftFormatted);
            }

        };
        mCountDownTimer_txt.start();


    }
    public void flipperImage(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);      // 이미지 추가
        v_flipper.setFlipInterval((int)count);
        v_flipper.startFlipping();



    }




}

