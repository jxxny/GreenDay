package com.example.greenday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Challenge_DB extends SQLiteOpenHelper {
    public static final int DATAVBASE_VERSION = 1;

    public Challenge_DB(@Nullable Context context) {
        super(context, "challenge_db", null, DATAVBASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String challengeSQL = "create table challenge ( "+
                "id integer primary key autoincrement,"+
                "cha_type text NOT NULL,"+
                "cha_name text NOT NULL,"+
                "cha_intro text NOT NULL)";

        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('용기', '#용기내#용기내챌린지', '용기를 깨끗하게 소독하고 집에서 가까운 곳을 방문하여 음식 포장해보기!')";
        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('대중교통', '대중교통 이용하기', '이산화탄소를 조금이나마 줄일 수 있도록 대중교통 이용하기!')";
        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('텀블러', '텀블러 사용하기', '환경을 위해 텀블러를 사용하여 500원 할인 받기!')";
        db.execSQL(challengeSQL);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion == DATAVBASE_VERSION){
            db.execSQL("drop table challenge");
            onCreate(db);
        }
    }
}
