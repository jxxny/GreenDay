package com.example.greenday;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class join extends AppCompatActivity {
    ImageView back_arrow;
    Button nickname_check_button, id_check_button, join_button;
    EditText insert_pwd, insert_repwd;
    ImageView setImage;
    Pattern pattern;
    Matcher matcher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);

        back_arrow = (ImageView)findViewById(R.id.back_arrow);
        join_button = (Button)findViewById(R.id.join_button);
        id_check_button = (Button)findViewById(R.id.id_check_button);
        nickname_check_button = (Button)findViewById(R.id.nickname_check_button);
        insert_pwd = (EditText)findViewById(R.id.insert_pwd);
        insert_repwd = (EditText)findViewById(R.id.insert_repwd);
        setImage = (ImageView)findViewById(R.id.setImage);

        String symbol = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$";

        pattern = Pattern.compile(symbol);

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        insert_pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pwd = insert_pwd.getText().toString();
                String repwd = insert_repwd.getText().toString();
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.check);
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.close_icon);
                bitmap1 = Bitmap.createScaledBitmap(bitmap1, 50, 50, true);
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, 50, 50, true);

                matcher = pattern.matcher(pwd);
                if(matcher.find() && pwd.equals(repwd)){
                    setImage.setImageBitmap(bitmap1);
                } else if(repwd.equals("")){
                    setImage.setImageResource(R.drawable.setimage);
                }
                else{
                    setImage.setImageBitmap(bitmap2);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        insert_repwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pwd = insert_pwd.getText().toString();
                String repwd = insert_repwd.getText().toString();
                Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.check);
                Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.close_icon);
                bitmap1 = Bitmap.createScaledBitmap(bitmap1, 50, 50, true);
                bitmap2 = Bitmap.createScaledBitmap(bitmap2, 50, 50, true);

                matcher = pattern.matcher(pwd);

                if(matcher.find() && pwd.equals(repwd)){
                    setImage.setImageBitmap(bitmap1);
                }else if(repwd.equals("")){
                    setImage.setImageResource(R.drawable.setImage);
                }
                else{
                    setImage.setImageBitmap(bitmap2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }
}