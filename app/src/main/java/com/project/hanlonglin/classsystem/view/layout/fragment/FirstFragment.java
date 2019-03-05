package com.project.hanlonglin.classsystem.view.layout.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.util.ImageUtil;
import com.project.hanlonglin.classsystem.util.adapter.TAdapter;
import com.project.hanlonglin.classsystem.util.item.ActionItem;
import com.project.hanlonglin.classsystem.view.layout.activity.MyCoursesAc;
import com.project.hanlonglin.classsystem.view.layout.activity.NewsAc;
import com.project.hanlonglin.classsystem.view.layout.activity.PublishCourseAc;
import com.project.hanlonglin.classsystem.view.layout.activity.QQChatAc;
import com.project.hanlonglin.classsystem.view.layout.activity.TaobaoAc;
import com.stx.xhb.xbanner.XBanner;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class FirstFragment extends BaseFragment {
    XBanner myBanner;
    GridView gridView_actions;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_first, null, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        myBanner=(XBanner)v.findViewById(R.id.myBanner);
        final List<String> urlList = new ArrayList<>();
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533182476859&di=90f496330a58174e4edd4dcf37af7481&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201410%2F23%2F20141023212703_j855e.thumb.700_0.png");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533182476859&di=de88100254d3ee87f92b74d4fce16d0f&imgtype=0&src=http%3A%2F%2Fzp1.douguo.net%2Fupload%2Fdish%2F9%2Fa%2F2%2F600_9aa2241c91c63caa6ee7cff5f32d2652.jpg");
        urlList.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1533182476859&di=080f0dfcad95363e79937eb7016a536e&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Dfb7727cdbc4543a9e116f28c776fefee%2Fb999a9014c086e0655fbc67209087bf40ad1cbbc.jpg");
        myBanner.setData(urlList, null);
        myBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                ImageUtil.showImageByUrl(getActivity(),(ImageView) view,urlList.get(position));
            }
        });

        gridView_actions=(GridView)v.findViewById(R.id.gridView_actions);
        List<ActionItem> list=new ArrayList<>();
        list.add(new ActionItem("发布课程",R.drawable.qq));
        list.add(new ActionItem("课程列表",R.drawable.qq));
        list.add(new ActionItem("成绩查询",R.drawable.qq));
        list.add(new ActionItem("考试安排",R.drawable.qq));
        list.add(new ActionItem("学生管理",R.drawable.qq));
        list.add(new ActionItem("近期活动",R.drawable.qq));
        list.add(new ActionItem("新闻板块",R.drawable.qq));
        list.add(new ActionItem("qq对话",R.drawable.qq));
        list.add(new ActionItem("淘宝链接",R.drawable.qq));
        TAdapter<ActionItem> adapter=new TAdapter<ActionItem>(list,R.layout.item_action) {
            @Override
            public void bindView(ViewHolder holder, ActionItem obj) {
                holder.setText(R.id.txt_action,obj.getTitle());
                holder.setImageView(R.id.image_action,obj.getRes());
            }
        };
        gridView_actions.setAdapter(adapter);

        gridView_actions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActionItem item=(ActionItem)adapterView.getAdapter().getItem(i);
                if(TextUtils.equals(item.getTitle(),"发布课程")){
                    startActivity(new Intent(getActivity(), PublishCourseAc.class));
                    getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
                }
                if(TextUtils.equals(item.getTitle(),"课程列表")){
                    startActivity(new Intent(getActivity(), MyCoursesAc.class));
                    getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
                }
                if(TextUtils.equals(item.getTitle(),"淘宝链接")){
                    startActivity(new Intent(getActivity(), TaobaoAc.class));
                    getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
                }
                if(TextUtils.equals(item.getTitle(),"qq对话")){
                    startActivity(new Intent(getActivity(), QQChatAc.class));
                    getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
                }
                if(TextUtils.equals(item.getTitle(),"新闻板块")){
                    startActivity(new Intent(getActivity(), NewsAc.class));
                    getActivity().overridePendingTransition(R.anim.bottom_to_top,0);
                }
            }
        });
    }


}
