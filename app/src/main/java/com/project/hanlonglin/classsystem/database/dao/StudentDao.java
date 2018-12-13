package com.project.hanlonglin.classsystem.database.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.database.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/11.
 */

public class StudentDao implements DaoInterface<Student> {
    DBOpenHelper helper;
    SQLiteDatabase sqLiteDatabase;
    String TB_NAME = "student";

    public StudentDao(Context context) {
        helper = new DBOpenHelper(context);
    }

    @Override
    public boolean add(Student stu) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("insert into " + TB_NAME + "(sname,grade,spasswd,age,sex) values(?,?,?,?,?)",
                    new Object[]{
                            stu.getSname(),
                            stu.getGrade(),
                            stu.getSpasswd(),
                            stu.getAge(),
                            stu.getSex()
                    });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("TAG", "DB出现错误" + e.getMessage());
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
    public boolean update(Student stu, String whereStr) {
        boolean b = true;
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            sqLiteDatabase.execSQL("update " + TB_NAME + " set sname=?,grade=?,spasswd=?,age=?,sex=? " + whereStr,
                    new Object[]{
                            stu.getSname(),
                            stu.getGrade(),
                            stu.getSpasswd(),
                            stu.getAge(),
                            stu.getSex()
                    });
        } catch (Exception e) {
            b = false;
        } finally {
            sqLiteDatabase.close();
        }
        return b;
    }

    @Override
    public List<Student> select(String whereStr) {
        List<Student> list = new ArrayList<>();
        sqLiteDatabase = helper.getWritableDatabase();
        try {
            String query_sql = "select sid,sname,grade,spasswd,age,sex from " + TB_NAME + " " + whereStr;
            Cursor cursor = sqLiteDatabase.rawQuery(query_sql, null);
            while (cursor.moveToNext()) {
                Student stu = new Student();
                stu.setSid(cursor.getInt(cursor.getColumnIndex("sid")));
                stu.setSname(cursor.getString(cursor.getColumnIndex("sname")));
                stu.setGrade(cursor.getInt(cursor.getColumnIndex("grade")));
                stu.setSpasswd(cursor.getString(cursor.getColumnIndex("spasswd")));
                stu.setAge(cursor.getInt(cursor.getColumnIndex("age")));
                stu.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                list.add(stu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqLiteDatabase.close();
        }
        return list;
    }
}
