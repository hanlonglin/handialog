package com.project.hanlonglin.classsystem.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.database.model.CourseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class CourseManagerDao implements DaoInterface<CourseManager> {
    DBOpenHelper helper;
    SQLiteDatabase sqLiteDatabase;
    String TB_NAME = "course_manager";

    public CourseManagerDao(Context context){
        helper=new DBOpenHelper(context);
    }
    @Override
    public boolean add(CourseManager courseManager) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("insert into " + TB_NAME + "(cid,sid,date) values(?,?,?)",
                    new Object[]{
                            courseManager.getCid(),
                            courseManager.getSid(),
                            courseManager.getDate()
                    });
        } catch (Exception e) {
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;
    }

    @Override
    public boolean delete(String whereStr) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            int r = sqLiteDatabase.delete(TB_NAME, whereStr, null);
            Log.e("TAG", "删除结果：" + r);
        } catch (Exception e) {
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;

    }

    @Override
    public boolean update(CourseManager courseManager, String whereStr) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("update " + TB_NAME + " set cid=?,sid=?,date=? " + whereStr,
                    new Object[]{
                            courseManager.getCid(),
                            courseManager.getSid(),
                            courseManager.getDate()
                    });
        } catch (Exception e) {
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;
    }

    @Override
    public List<CourseManager> select(String whereStr) {
        List<CourseManager> list = new ArrayList<>();
        sqLiteDatabase = helper.getWritableDatabase();
        String query_sql = "select cid,sid,date from " + TB_NAME + " " + whereStr;
        Cursor cursor = sqLiteDatabase.rawQuery(query_sql, null);
        while (cursor.moveToNext()) {
            CourseManager courseManager = new CourseManager();
            courseManager.setCid(cursor.getInt(cursor.getColumnIndex("cid")));
            courseManager.setSid(cursor.getInt(cursor.getColumnIndex("sid")));
            courseManager.setDate(cursor.getString(cursor.getColumnIndex("date")));
            list.add(courseManager);
        }
        sqLiteDatabase.close();
        return list;
    }

    public List<Integer> getSidsByCid(int cid){
        List<Integer> list = new ArrayList<>();
        sqLiteDatabase = helper.getWritableDatabase();
        String query_sql = "select sid from " + TB_NAME + " where cid=?";
        Cursor cursor = sqLiteDatabase.rawQuery(query_sql,new String[]{cid+""});
        while (cursor.moveToNext()) {
            list.add(cursor.getInt(cursor.getColumnIndex("sid")));
        }
        sqLiteDatabase.close();
        return list;
    }
    public List<Integer> getCidsBySid(int sid){
        List<Integer> list = new ArrayList<>();
        sqLiteDatabase = helper.getWritableDatabase();
        String query_sql = "select cid from " + TB_NAME + " where sid=?";
        Cursor cursor = sqLiteDatabase.rawQuery(query_sql,new String[]{sid+""});
        while (cursor.moveToNext()) {
            list.add(cursor.getInt(cursor.getColumnIndex("cid")));
        }
        sqLiteDatabase.close();
        return list;
    }
}
