package com.project.hanlonglin.classsystem.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.hanlonglin.classsystem.database.model.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class CourseDao implements DaoInterface<Course> {
    DBOpenHelper helper;
    SQLiteDatabase sqLiteDatabase;
    String TB_NAME = "course";

    public CourseDao(Context context) {
        helper = new DBOpenHelper(context);
    }

    public boolean add(Course course) {
        Boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("insert into " + TB_NAME + "(cname,grade,caccount,maxnum,num,descrip) values(?,?,?,?,?,?)",
                    new Object[]{
                            course.getCname(),
                            course.getGrade(),
                            course.getCaccount(),
                            course.getMaxNum(),
                            course.getNum(),
                            course.getDescrip()
                    });
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;
    }


    public boolean delete(String whereStr) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            int r = sqLiteDatabase.delete(TB_NAME, whereStr, null);
            sqLiteDatabase.close();
            Log.e("TAG", "删除结果：" + r);
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;
    }

    public boolean update(Course course, String whereStr) {
        boolean b=true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("update " + TB_NAME + " set cname=?,grade=?,caccount=?,maxnum=?,num=?,descrip=? " + whereStr,
                    new Object[]{
                            course.getCname(),
                            course.getGrade(),
                            course.getCaccount(),
                            course.getMaxNum(),
                            course.getNum(),
                            course.getDescrip()
                    });
        }catch (Exception e){
            e.printStackTrace();
            b=false;
        }finally {
            sqLiteDatabase.close();
        }
        return b;
    }

    public List<Course> select(String whereStr) {
        List<Course> list = new ArrayList<>();
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            String query_sql = "select cid,cname,caccount,grade,maxnum,num,descrip from " + TB_NAME + " " + whereStr;
            Cursor cursor = sqLiteDatabase.rawQuery(query_sql, null);
            while (cursor.moveToNext()) {
                Course course = new Course();
                course.setCid(cursor.getInt(cursor.getColumnIndex("cid")));
                course.setCname(cursor.getString(cursor.getColumnIndex("cname")));
                course.setCaccount(cursor.getString(cursor.getColumnIndex("caccount")));
                course.setGrade(cursor.getInt(cursor.getColumnIndex("grade")));
                course.setMaxNum(cursor.getInt(cursor.getColumnIndex("maxnum")));
                course.setNum(cursor.getInt(cursor.getColumnIndex("num")));
                course.setDescrip(cursor.getString(cursor.getColumnIndex("descrip")));
                list.add(course);
            }
        }catch (Exception e){

        }finally {
            sqLiteDatabase.close();
        }
        return list;
    }

}
