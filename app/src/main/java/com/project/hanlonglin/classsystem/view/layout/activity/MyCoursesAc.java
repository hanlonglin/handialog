package com.project.hanlonglin.classsystem.view.layout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.app.AppApplication;
import com.project.hanlonglin.classsystem.database.dao.CourseDao;
import com.project.hanlonglin.classsystem.database.dao.CourseManagerDao;
import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.database.model.CourseManager;
import com.project.hanlonglin.classsystem.util.adapter.TAdapter;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class MyCoursesAc extends AppCompatActivity {
    GridView gridView_course;
    CourseManagerDao courseManagerDao = null;
    CourseDao courseDao = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycourse);
        courseManagerDao = new CourseManagerDao(this);
        courseDao = new CourseDao(this);
        initView();
    }

    private void initView() {
        gridView_course = (GridView) findViewById(R.id.gridView_course);

        List<Integer> cidList = courseManagerDao.getCidsBySid(AppApplication.currentStu.getSid());
        String cids_str="";
        if (cidList.size() > 0) {
            cids_str+="(";
            for (int i = 0; i < cidList.size(); i++) {
                cids_str+=cidList.get(i) + ",";
            }
            cids_str=cids_str.substring(0,cids_str.length()-1);
            cids_str+=")";
        }
        Log.e("TAG","cids:"+cids_str);
        List<Course> courseList = courseDao.select("where cid in " + cids_str);
        Log.e("TAG", "courseList size():" + courseList.size());
        TAdapter<Course> course_adapter = new TAdapter<Course>(courseList, R.layout.item_course) {
            @Override
            public void bindView(ViewHolder holder, Course obj) {
                holder.setText(R.id.txt_course, obj.getCname());
            }
        };
        gridView_course.setAdapter(course_adapter);
    }
}
