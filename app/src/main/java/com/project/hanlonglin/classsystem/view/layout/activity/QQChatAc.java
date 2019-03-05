package com.project.hanlonglin.classsystem.view.layout.activity;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.util.adapter.QQChatAdapter;
import com.project.hanlonglin.classsystem.util.item.MessageItem;
import com.project.hanlonglin.classsystem.veiw.diyview.TitleBarRelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class QQChatAc extends AppCompatActivity implements View.OnClickListener{
    RecyclerView recycleView;
    TitleBarRelativeLayout titleLayout;
    Button btn_rec,btn_send;
    EditText ed_content;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qq_chat);
        initView();
    }

    private void initView() {
        titleLayout=(TitleBarRelativeLayout)findViewById(R.id.titleLayout);
        recycleView=(RecyclerView)findViewById(R.id.recycle_chat);
        btn_rec=(Button)findViewById(R.id.btn_rec);
        btn_send=(Button)findViewById(R.id.btn_send);
        ed_content=(EditText)findViewById(R.id.ed_content);

        btn_rec.setOnClickListener(this);
        btn_send.setOnClickListener(this);

        titleLayout.setTitle("正在和小明对话");


        List<MessageItem> list=new ArrayList<>();
        list.add(new MessageItem(MessageItem.TYPE_REC,"你好我是小明"));
        list.add(new MessageItem(MessageItem.TYPE_SEND,"你好我是小红"));
        QQChatAdapter qAdapter=new QQChatAdapter(list);
        LinearLayoutManager linearManager=new LinearLayoutManager(this);
        //linearManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycleView.setLayoutManager(linearManager);
        recycleView.setAdapter(qAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_send:
                sendMsg();
                break;
            case R.id.btn_rec:
                recMsg();
                break;
        }
    }

    private void recMsg() {
        String content=ed_content.getText().toString();
        if(content.isEmpty()) return;
        MessageItem me=new MessageItem(MessageItem.TYPE_REC,content);
        ((QQChatAdapter)recycleView.getAdapter()).add(me);
        recycleView.scrollToPosition(recycleView.getAdapter().getItemCount()-1);
        ed_content.setText("");
    }

    private void sendMsg() {
        String content=ed_content.getText().toString();
        if(content.isEmpty()) return;
        MessageItem me=new MessageItem(MessageItem.TYPE_SEND,content);
        ((QQChatAdapter)recycleView.getAdapter()).add(me);
        recycleView.scrollToPosition(recycleView.getAdapter().getItemCount()-1);
        ed_content.setText("");
    }
}
