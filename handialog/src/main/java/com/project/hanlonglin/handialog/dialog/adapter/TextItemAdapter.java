package com.project.hanlonglin.handialog.dialog.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/14.
 */

public class TextItemAdapter extends BaseAdapter {

    private Context context;
    private List<String> list;

    public TextItemAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView txt = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_text, null, false);
            txt = (TextView) view;
            view.setTag(txt);
        } else {
            txt = (TextView) view.getTag();
        }

        txt.setText(list.get(i));
        return view;
    }

    public void add(String txt){
        list.add(txt);
        notifyDataSetInvalidated();
    }

    public void remove(String txt){
        list.remove(txt);
        notifyDataSetChanged();
    }
}
