package com.project.hanlonglin.handialog.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.project.hanlonglin.handialog.R;
import com.project.hanlonglin.handialog.dialog.listener.ListItemListener;

/**
 * Created by hanlonglin on 2018/12/14.
 */

public class ListDialog extends BaseDialog {
    ListView listview;
    ImageView image_close;
    TextView txt_title;

    String title;
    int title_bg_color;
    ListAdapter adapter=null;
    ListItemListener listener=null;


    public ListDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_list);
        initView();
    }

    private void initView() {
        txt_title = (TextView) findViewById(R.id.txt_title);
        image_close = (ImageView) findViewById(R.id.image_close);
        listview = (ListView) findViewById(R.id.listView);

        image_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(listener!=null)
                    listener.itemClick(adapterView, view, i,l);
                dismiss();
            }
        });
    }

    @Override
    public void show() {
        super.show();

        txt_title.setText(title);
        txt_title.setBackgroundColor(title_bg_color);
        listview.setAdapter(adapter);
    }

    public ListDialog title(String title){
        this.title=title;
        return this;
    }
    public ListDialog titleBgColor(int title_color){
        this.title_bg_color=title_color;
        return this;
    }

    public ListDialog setAdapter(ListAdapter adapter) {
        this.adapter = adapter;
        return this;
    }
    public ListDialog setListItemListener(ListItemListener listener) {
        this.listener = listener;
        return this;
    }
}
