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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class join extends AppCompatActivity {
    ImageView back_arrow;
    Button nickname_check_button, id_check_button, join_button;
    EditText insert_pwd, insert_repwd, insert_id;
    ImageView setImage;
    Pattern pattern1, pattern2;
    Matcher matcher1, matcher2;
    public static String symbol1 = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&]).{8,15}.$";
    public static String symbol2 = "^[a-zA-Z0-9]{6,15}$";
    String result;

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
        insert_id = (EditText)findViewById(R.id.insert_id);

        setImage = (ImageView)findViewById(R.id.setImage);

        pattern1 = Pattern.compile(symbol1);
        pattern2 = Pattern.compile(symbol2);


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

        id_check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = insert_id.getText().toString();
                matcher2 = pattern2.matcher(result);
                if(matcher2.find()){
                    if(result.equals("abcdef")){
                        Toast.makeText(getApplicationContext(),"중복된 아이디입니다.",Toast.LENGTH_SHORT).show();
                        result = null;
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"가능한 아이디입니다.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"아이디는 6글자 이상\n15글자 이하로 해주세요.",Toast.LENGTH_SHORT).show();
                    result = null;
                }
            }
        });

        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(insert_id.getText().toString().equals(result)){
                    if(result.equals("abcdef")){
                        Toast.makeText(getApplicationContext(),"중복된 아이디입니다.",Toast.LENGTH_SHORT).show();
                        result = null;
                    }
                    else{
                        if(insert_pwd.getText().toString().equals(insert_repwd.getText().toString())){
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(),"비밀번호가 일치하지 않습니다.",Toast.LENGTH_SHORT).show();
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"중복확인을 눌러주세요.",Toast.LENGTH_SHORT).show();
                    result = null;
                }
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

                matcher1 = pattern1.matcher(pwd);
                if(matcher1.find() && pwd.equals(repwd)){
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

                matcher1 = pattern1.matcher(pwd);

                if(matcher1.find() && pwd.equals(repwd)){
                    setImage.setImageBitmap(bitmap1);
                }else if(repwd.equals("")){
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

    }
}