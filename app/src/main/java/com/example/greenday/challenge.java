package com.example.greenday;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.graphics.Color.TRANSPARENT;

public class challenge extends AppCompatActivity {
    RecyclerView recyclerView;
    View dialogView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.challenge_activity);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        final ArrayList<Item> list = new ArrayList<>();

        Challenge_DB challenge_db = new Challenge_DB(this);
        final SQLiteDatabase db = challenge_db.getReadableDatabase();
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
                dialogView = (View) v.inflate(getApplicationContext(),R.layout.challenge_popup, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(challenge.this);
                dlg.setView(dialogView);
                Button startup_btn = dialogView.findViewById(R.id.start_button);
                Button giveup_btn = dialogView.findViewById(R.id.giveup_button);
                ImageView x = dialogView.findViewById(R.id.x);

                startup_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), challenge.this.getClass());
                        startActivity(intent);
                    }
                });

                giveup_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), challenge.this.getClass());
                        startActivity(intent);
                    }
                });

                x.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), challenge.this.getClass());
                        startActivity(intent);
                    }
                });
                dlg.show();
            }
        });
        recyclerView.addItemDecoration(new MyItemDecoration(list));

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