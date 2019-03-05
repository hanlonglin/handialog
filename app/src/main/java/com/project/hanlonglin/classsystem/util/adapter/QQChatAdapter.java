package com.project.hanlonglin.classsystem.util.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.util.item.MessageItem;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class QQChatAdapter extends RecyclerView.Adapter {
    List<MessageItem> list;

    public QQChatAdapter(List<MessageItem> list) {
        this.list = list;
        Log.e("TAG", "QQChatAdapter: list size:"+list.size());
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_qq_chat, parent, false);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MessageItem messageItem = list.get(position);
        if (messageItem.getType() == MessageItem.TYPE_REC) {
            ((MyViewHolder) holder).linearLayout_rec.setVisibility(View.VISIBLE);
            ((MyViewHolder) holder).linearLayout_send.setVisibility(View.GONE);
            ((MyViewHolder) holder).txt_rec_msg.setText(messageItem.getContent());
        }else{
            ((MyViewHolder) holder).linearLayout_rec.setVisibility(View.GONE);
            ((MyViewHolder) holder).linearLayout_send.setVisibility(View.VISIBLE);
            ((MyViewHolder) holder).txt_send_msg.setText(messageItem.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout_send, linearLayout_rec;
        TextView txt_rec_msg, txt_send_msg;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout_rec = (LinearLayout) itemView.findViewById(R.id.layout_rec);
            linearLayout_send = (LinearLayout) itemView.findViewById(R.id.layout_send);
            txt_rec_msg = (TextView) itemView.findViewById(R.id.txt_rec_msg);
            txt_send_msg = (TextView) itemView.findViewById(R.id.txt_send_msg);
        }
    }

    public void add(MessageItem messageItem){
        this.list.add(messageItem);
        notifyItemInserted(this.list.size()-1);
    }
}
