package com.project.hanlonglin.classsystem.view.layout.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.database.dao.CourseDao;
import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.util.adapter.TAdapter;
import com.project.hanlonglin.classsystem.util.item.GradeItem;
import com.project.hanlonglin.classsystem.view.layout.activity.CourseDetailAc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class ChooseFragment extends BaseFragment {
    GridView gridView_course;
    ListView listView_grade;

    List<Course> courseList;
    CourseDao courseDao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_choose, null, false);
        courseDao=new CourseDao(getActivity());
        courseList = new ArrayList<>();
        initView(v);
        return v;
    }


    private void initView(View v) {
        gridView_course = (GridView) v.findViewById(R.id.gridView_course);
        listView_grade = (ListView) v.findViewById(R.id.listView_grade);

        List<String> gradeList = new ArrayList<>();
        gradeList.add("一年级");
        gradeList.add("二年级");
        gradeList.add("三年级");
        gradeList.add("四年级");
        gradeList.add("五年级");
        gradeList.add("六年级");
        final TAdapter<String> grade_adapter = new TAdapter<String>(gradeList, R.layout.item_grade) {
            @Override
            public void bindView(ViewHolder holder, String obj) {
                holder.setText(R.id.txt_grade, obj);
            }
        };
        listView_grade.setAdapter(grade_adapter);

        listView_grade.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("TAG", "你点击了" + (String) adapterView.getAdapter().getItem(i));
                Log.e("TAG", "onclickItem listView size:" + listView_grade.getChildCount());
                showCourseByGrade(i+1);
                view.setSelected(true);
            }
        });
        //显示一年级
        showCourseByGrade(1);
        //listView_grade.getChildAt(0).setSelected(true);

        gridView_course.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Course course=(Course)adapterView.getAdapter().getItem(i);
                Intent intent=new Intent(getActivity(), CourseDetailAc.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("course",course);
                intent.putExtras(bundle);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
            }
        });
    }

    private void showCourseByGrade(int i) {
        courseList = courseDao.select("where grade="+i);
        Log.e("TAG","courseList size():"+courseList.size());
        TAdapter<Course> course_adapter = new TAdapter<Course>(courseList, R.layout.item_course) {
            @Override
            public void bindView(ViewHolder holder, Course obj) {
                holder.setText(R.id.txt_course, obj.getCname());
            }
        };
        gridView_course.setAdapter(course_adapter);
    }
}
