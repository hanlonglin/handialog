package com.project.hanlonglin.classsystem.view.layout.fragment_item;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.veiw.diyview.TitleBarRelativeLayout;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class ContentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news_content,null,false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        EditText ed_content=(EditText)v.findViewById(R.id.ed_content);
        TitleBarRelativeLayout titleLayout=(TitleBarRelativeLayout)v.findViewById(R.id.titleLayout);
        titleLayout.setTitle("新闻板块");
    }
}
