package com.project.hanlonglin.classsystem.view.layout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.app.AppApplication;
import com.project.hanlonglin.classsystem.database.dao.CourseDao;
import com.project.hanlonglin.classsystem.database.dao.CourseManagerDao;
import com.project.hanlonglin.classsystem.database.dao.StudentDao;
import com.project.hanlonglin.classsystem.database.model.Course;
import com.project.hanlonglin.classsystem.database.model.CourseManager;
import com.project.hanlonglin.classsystem.database.model.Student;
import com.project.hanlonglin.classsystem.database.model.Teacher;
import com.project.hanlonglin.classsystem.veiw.diyview.HorizontalClassView;
import com.project.hanlonglin.classsystem.view.layout.dialog.AlertDialog;
import com.project.hanlonglin.classsystem.view.layout.dialog.StuListDialog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/12.
 */

public class CourseDetailAc extends AppCompatActivity implements View.OnClickListener {
    Button btn_join;
    TextView txt_cname, txt_grade, txt_maxNum, txt_num, txt_teacher, txt_descrip;
    ImageView image_back, image_stulist;

    CourseManagerDao courseManagerDao = null;
    CourseDao courseDao = null;
    StudentDao stuDao;
    Course course = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        initView();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        course = (Course) bundle.getSerializable("course");
        showCourseInfo();

        courseManagerDao = new CourseManagerDao(this);
        courseDao = new CourseDao(this);
        stuDao=new StudentDao(this);

    }


    private void initView() {
        txt_cname = (TextView) findViewById(R.id.txt_cnamevalue);
        txt_grade = (TextView) findViewById(R.id.txt_gradevalue);
        txt_maxNum = (TextView) findViewById(R.id.txt_maxvalue);
        txt_num = (TextView) findViewById(R.id.txt_numvalue);
        txt_teacher = (TextView) findViewById(R.id.txt_teachervalue);
        txt_descrip = (TextView) findViewById(R.id.txt_descripvalue);
        btn_join = (Button) findViewById(R.id.btn_join);
        image_back = (ImageView) findViewById(R.id.image_back);
        image_stulist = (ImageView) findViewById(R.id.image_stulist);

        btn_join.setOnClickListener(this);
        image_back.setOnClickListener(this);
        image_stulist.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_back:
                finish();
                overridePendingTransition(0, R.anim.top_to_bottom);
                break;
            case R.id.btn_join:
                joinClass();
                break;
            case R.id.image_stulist:
                showStuList();
                break;
        }
    }

    private void showStuList() {
        List<Student> stuList=null;
        if (course != null) {
            List<Integer> sids = courseManagerDao.getSidsByCid(course.getCid());
            String sids_str = "";
            if (sids.size() > 0) {
                sids_str += "(";
                for (int i = 0; i < sids.size(); i++) {
                    sids_str += sids.get(i)+",";
                }
                sids_str=sids_str.substring(0,sids_str.length()-1);
                sids_str+=")";
            }
            if(sids_str!=""){
                stuList=stuDao.select("where sid in "+sids_str);
            }
        }

//        stuList=new ArrayList<>();
//        stuList.add(new Student(10,"王琳","男","123",2));
//        stuList.add(new Student(10,"张三","男","123",2));
//        stuList.add(new Student(10,"泡脚","男","123",2));
//        stuList.add(new Student(10,"王五","男","123",2));
//        stuList.add(new Student(10,"刘瑞","男","123",2));
//        stuList.add(new Student(10,"杜兰特","男","123",2));
//        stuList.add(new Student(10,"库里","男","123",2));
//        stuList.add(new Student(10,"詹姆斯","男","123",2));
        new StuListDialog(this)
                .setStudents(stuList)
                .show();
    }

    private void showCourseInfo() {

        Log.e("TAG", "course 接收到：" + course.toString());
        if (course != null) {
            txt_cname.setText(course.getCname());
            txt_grade.setText(course.getGrade() + "");
            txt_maxNum.setText(course.getMaxNum() + "");
            txt_num.setText(course.getNum() + "");
            txt_descrip.setText(course.getDescrip());
        }
    }

    private void joinClass() {

        Toast.makeText(this, "参加成功", Toast.LENGTH_SHORT).show();
        if (course == null)
            return;
        if (course.getGrade() != AppApplication.currentStu.getGrade()) {
            new AlertDialog(this)
                    .title("参加失败")
                    .messsage("你的所属年级不能选该课程！")
                    .icon(R.drawable.fail)
                    .animtype(AlertDialog.TYPE_FAIL)
                    .show();
            return;
        }
        if (course.getNum() < course.getMaxNum()) {
            CourseManager courseManager = new CourseManager(AppApplication.currentStu.getSid(), course.getCid(), new Date().toString());
            boolean b = courseManagerDao.add(courseManager);
            if (b) {
                course.setNum(course.getNum() + 1);
                courseDao.update(course, "where cid=" + course.getCid());
                new AlertDialog(this)
                        .title("参加成功")
                        .messsage("请记得准时上课")
                        .show();
                btn_join.setText("已参加");
                btn_join.setEnabled(false);
            } else {
                new AlertDialog(this)
                        .title("参加失败")
                        .messsage("不能重复参加")
                        .icon(R.drawable.fail)
                        .animtype(AlertDialog.TYPE_FAIL)
                        .show();
            }
        } else {
            new AlertDialog(this)
                    .title("课程人数已满")
                    .messsage("请等待下次开课")
                    .icon(R.drawable.fail)
                    .animtype(AlertDialog.TYPE_FAIL)
                    .show();
        }
    }
}
