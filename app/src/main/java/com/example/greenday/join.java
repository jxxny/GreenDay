package com.example.greenday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class join extends AppCompatActivity {
    ImageView back_arrow;
    Button nickname_check_button, id_check_button, join_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);

        back_arrow = (ImageView)findViewById(R.id.back_arrow);
        join_button = (Button)findViewById(R.id.join_button);
        id_check_button = (Button)findViewById(R.id.id_check_button);
        nickname_check_button = (Button)findViewById(R.id.nickname_check_button);

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
    }
}
