package com.project.hanlonglin.classsystem.view.layout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.util.adapter.TaobaoAdapter;
import com.project.hanlonglin.classsystem.util.adapter.TaobaoTitleAdapter;
import com.project.hanlonglin.classsystem.util.item.TaobaoItem;
import com.project.hanlonglin.classsystem.veiw.diyview.TitleBarRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class TaobaoAc extends AppCompatActivity {
    TitleBarRelativeLayout titleLayout;
    RecyclerView recycleView, recycleView_titles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao);
        initView();
    }

    private void initView() {
        titleLayout = (TitleBarRelativeLayout) findViewById(R.id.titleLayout);
        recycleView = (RecyclerView) findViewById(R.id.recycleView);
        recycleView_titles = (RecyclerView) findViewById(R.id.recycleView_titles);

        titleLayout.setTitle("淘宝");

        List<TaobaoItem> list = new ArrayList<>();
        int imageIds[] = {
                R.drawable.advert,
                R.drawable.qq,
                R.drawable.success,
                R.drawable.fail
        };
        String titles[] = {
                "小米",
                "华为",
                "苹果",
                "魅族"
        };
        String descrips[] = {
                "asdasd",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "asdasdasdasdaskdjla ;klasjd oijalkjd lkajsl jkas ",
                "hahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaahahhahahahahhahahahhahahhahaaaaaaaaaaaaaaaaaaaaaaaa",
                "asdasdasasdaaaaaaaaaaaaaaaaaaaaaaaaadddddd123333333333333333333333333333333333",
                "asdasdasasdaaaaaaaaaaaaaaaaaaaaaaaaadddddd123333333333333333333333333333333333asdasdasasdaaaaaaaaaaaaaaaaaaaaaaaaadddddd123333333333333333333333333333333333"
        };
        for (int i = 0; i < 33; i++) {
            int imageId = imageIds[(int) (Math.random() * (imageIds.length - 1))];
            String title = titles[(int) (Math.random() * (titles.length - 1))];
            String descrip = descrips[(int) (Math.random() * (descrips.length - 1))];
            list.add(new TaobaoItem(imageId, descrip, title));
        }

        recycleView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        TaobaoAdapter adapter = new TaobaoAdapter(list);
        recycleView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recycleView_titles.setLayoutManager(linearLayoutManager);
        TaobaoTitleAdapter tadapter = new TaobaoTitleAdapter(list);
        recycleView_titles.setAdapter(tadapter);
    }
}
