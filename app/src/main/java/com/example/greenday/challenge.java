package com.example.greenday;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class challenge extends AppCompatActivity {
    RecyclerView recyclerView;
    Dialog dia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_activity);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        dia = new Dialog(challenge.this);
        dia.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dia.setContentView(R.layout.challenge_popup);


        final ArrayList<Item> list = new ArrayList<>();

        Challenge_DB challenge_db = new Challenge_DB(this);
        SQLiteDatabase db = challenge_db.getReadableDatabase();
        Cursor cursor = db.rawQuery("select cha_type, cha_name, cha_intro from challenge", null);

        while(cursor.moveToNext()){
            Item item = new Item();
            item.type = cursor.getString(0);
            item.name = cursor.getString(1);
            item.intro = cursor.getString(2);
            list.add(item);
        }
        db.close();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Challenge_Adapter challenge_adapter = new Challenge_Adapter(list);
        recyclerView.setAdapter(challenge_adapter);

        challenge_adapter.setOnMyTouchListener(new Challenge_Adapter.OnMyTouchListener() {
            @Override
            public void onTouch(View v, int pos) {
                showDialog();
            }
        });
        recyclerView.addItemDecoration(new MyItemDecoration(list));

    }

    public void showDialog(){
        dia.show();
        dia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button start_btn = (Button)dia.findViewById(R.id.start_button);
        Button giveup_btn = (Button)dia.findViewById(R.id.giveup_button);
        Button x = (Button) dia.findViewById(R.id.x);
        dia.setCancelable(false);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), challenge.class);
                startActivity(intent);
            }
        });
        giveup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.dismiss();
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dia.dismiss();
            }
        });
    }

    class MyItemDecoration extends RecyclerView.ItemDecoration{
        public MyItemDecoration(ArrayList<Item> list) {
        }

        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);
        }

        @Override
        public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);

            int position = parent.getChildAdapterPosition(view);
            outRect.set(30, 15, 30, 15);
        }
    }
}