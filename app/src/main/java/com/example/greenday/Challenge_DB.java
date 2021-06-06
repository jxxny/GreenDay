package com.example.greenday;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Challenge_DB extends SQLiteOpenHelper {
    public static final int DATAVBASE_VERSION = 12;

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

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('해시태그 챌린지', '해시태그 챌린지', '활발하게 이루어지고 있는 환경과\n관련된 챌린지를 소개합니다!')";
        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('다같이 챌린지', '다같이 챌린지', '환경 관련 챌린지 중 활동량이 적어\n아쉬운 챌린지를 소개합니다!')";
        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('탄소발자국 줄이기 챌린지', '탄소발자국 줄이기 챌린지', '일상생활에서 가볍게 해낼 수 있는\n환경 관련 챌린지를 소개합니다!')";
        db.execSQL(challengeSQL);

        challengeSQL = "INSERT INTO challenge(cha_type, cha_name, cha_intro) VALUES('단체와 함께해요', '단체와 함께해요', '공공기관과 특별시, 자치 단체가\n시행하는 챌린지를 소개합니다!')";
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