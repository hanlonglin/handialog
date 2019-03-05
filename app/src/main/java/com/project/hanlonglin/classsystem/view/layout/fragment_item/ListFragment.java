package com.project.hanlonglin.classsystem.view.layout.fragment_item;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.project.hanlonglin.classsystem.R;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_news_list, null, false);
        initView(v);
        return v;
    }

    private void initView(View v) {
        ListView listView = (ListView) v.findViewById(R.id.listView);
        String array[] = {
                "今日说法",
                "早间新闻",
                "晚间新闻",
                "中午新闻",
                "新闻早知道",
                "光明日报",
                "朝闻天下",
                "新闻联播"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, array);
        listView.setAdapter(adapter);
    }
}
