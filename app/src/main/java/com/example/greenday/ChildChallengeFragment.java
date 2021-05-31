package com.example.greenday;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChildChallengeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Item> list = new ArrayList<>();
    Challenge_Adapter challenge_adapter;
    Challenge_DB challenge_db;
    Dialog dia;
    public ChildChallengeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_child_challenge,container,false);

        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        dia = new Dialog(getContext());
        dia.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dia.setContentView(R.layout.challenge_popup);

        challenge_db = new Challenge_DB(getContext());
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

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        challenge_adapter = new Challenge_Adapter(list);
        recyclerView.setAdapter(challenge_adapter);

        challenge_adapter.setOnMyTouchListener(new Challenge_Adapter.OnMyTouchListener() {
            @Override
            public void onTouch(View v, int pos) {
                showDialog();
            }
        });

        recyclerView.addItemDecoration(new ChildChallengeFragment.MyItemDecoration(list));



        return view;
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
                dia.dismiss();
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
