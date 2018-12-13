package com.project.hanlonglin.classsystem.database.dao;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME="classsystem.db";
    private static final int VERSION=1;

    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_course="create table course(" +
                "cid integer primary key autoincrement," +
                "cname varchar(20) not null," +
                "caccount varchar(25) unique not null,"+
                "grade integer not null," +
                "maxnum integer not null," +
                "num integer not null," +
                "descrip varchar(50))";
        String sql_student="create table student(" +
                "sid integer primary key autoincrement," +
                "sname varchar(20) unique not null," +
                "grade integer not null," +
                "spasswd varchar(20) not null," +
                "age integer not null," +
                "sex varchar(5) check(sex ='男' or sex='女') default '男')";
        String sql_teacher="create table teacher(" +
                "tid integer primary key autoincrement," +
                "tname varchar(20) not null," +
                "tpasswd varchar(20) not null," +
                "age integer not null," +
                "sex varchar(5) check(sex ='男' or sex='女'))";
        String sql_coursemanager="create table course_manager(" +
                "cid integer not null," +
                "sid integer not null," +
                "date varchar(30) not null," +
                "primary key(cid,sid)," +
                "foreign key(cid) references course(cid)," +
                "foreign key(sid) references student(sid))";
        sqLiteDatabase.execSQL(sql_course);
        sqLiteDatabase.execSQL(sql_student);
        sqLiteDatabase.execSQL(sql_teacher);
        sqLiteDatabase.execSQL(sql_coursemanager);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
