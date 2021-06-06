package com.example.greenday;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChildChallengeFragment extends Fragment {
    public static final String TAG = "TAG_CHILD";
    RecyclerView recyclerView;
    ArrayList<Item> list;
    Challenge_Adapter challenge_adapter;
    Challenge_DB challenge_db;
    Dialog dia;
    ImageView back;
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

        list = new ArrayList<>();
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

/*        challenge_adapter.setOnMyTouchListener(new Challenge_Adapter.OnMyTouchListener() {
            @Override
            public void onTouch(View v, int pos) {
                showDialog();
            }
        }); // 리사이클러뷰 아이템을 클릭하므로써 다이얼로그 보여주기*/

        recyclerView.addItemDecoration(new ChildChallengeFragment.MyItemDecoration(list)); // 리사이클러뷰 아이템 위치 수정

        back = (ImageView)view.findViewById(R.id.back_img3);
        return view;
    }

/*    public void showDialog(){
        dia.show(); // 다이얼로그 보여주기
        dia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // 다이얼로그 사각형을 둥글게 하는 법
        Button start_btn = (Button)dia.findViewById(R.id.start_button); // 시작 버튼
        Button giveup_btn = (Button)dia.findViewById(R.id.giveup_button); // 포기 버튼
        ImageView x = (ImageView) dia.findViewById(R.id.x); //  x 버튼
        dia.setCancelable(false); // 바깥쪽으로 눌러도 나갈 수 없음

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
    }*/

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
