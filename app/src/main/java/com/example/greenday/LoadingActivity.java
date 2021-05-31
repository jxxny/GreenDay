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

            new Thread(new Runnable() {
                @Override
                public void run() {
                    final int[] per = {0};
                    mImageDrawable.setLevel(mImageDrawable.getLevel() + 2500);
                    while(per[0] != 100){
                        try{
                            Thread.sleep(600);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        final int percent = (int) Math.floor(Math.random() * 7);

                        textView.post(new Runnable() {
                            @Override
                            public void run() {
                                per[0] += percent;
                                if(per[0] > 100)
                                    per[0] = 100;
                                mImageDrawable.setLevel(mImageDrawable.getLevel() + 75 * percent);
                                textView.setText(per[0] + "%");

                            }
                        });
                    }
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }).start();
    }


}
