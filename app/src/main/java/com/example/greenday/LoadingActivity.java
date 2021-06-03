package com.example.greenday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.nio.Buffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoadingActivity extends AppCompatActivity {
    private ClipDrawable mImageDrawable;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ImageView img = (ImageView)findViewById(R.id.imageView1);
        mImageDrawable = (ClipDrawable) img.getDrawable();
        textView = (TextView)findViewById(R.id.textView);
            // 스레드 실행
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final int[] per = {0}; // 변수 선언
                    mImageDrawable.setLevel(mImageDrawable.getLevel() + 2500); // 사진이 2500만큼 올라와 있음
                    while(per[0] != 100){
                        try{
                            Thread.sleep(600); // 0.6초
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        final int percent = (int) Math.floor(Math.random() * 7); // 1~7 랜덤

                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                per[0] += percent; // 랜덤 숫자를 더함
                                if(per[0] > 100) // 100이 넘으면
                                    per[0] = 100; // 100으로 수정
                                mImageDrawable.setLevel(mImageDrawable.getLevel() + 75 * percent); // 완전하게 채울려면 10000이기에 75 * 랜덤 숫자를 주므로써 7500만 채우면 됨
                                textView.setText(per[0] + "%"); // 나무가 차는 모습을 텍스트로 확인
                            }
                        });
                    }
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent); // 100퍼가 되면 로그인 화면으로 이동
                }
            }).start();
    }
}
