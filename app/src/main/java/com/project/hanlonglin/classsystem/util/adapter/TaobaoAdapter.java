package com.project.hanlonglin.classsystem.util.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.hanlonglin.classsystem.R;
import com.project.hanlonglin.classsystem.util.item.TaobaoItem;

import java.util.List;

/**
 * Created by hanlonglin on 2018/12/17.
 */

public class TaobaoAdapter extends RecyclerView.Adapter {

    List<TaobaoItem> list;

    public TaobaoAdapter(List<TaobaoItem> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_taobao,parent,false);
        final MyViewHolder holder=new MyViewHolder(v);
        holder.txt_descrip_taobao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=holder.getAdapterPosition();
                Log.e("TAG", "点击"+list.get(position).getTitle());
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TaobaoItem taobaoItem=list.get(position);
        ((MyViewHolder)holder).image_taobao.setImageResource(taobaoItem.getImageId());
        ((MyViewHolder)holder).txt_title_taobao.setText(taobaoItem.getTitle());
        ((MyViewHolder)holder).txt_descrip_taobao.setText(taobaoItem.getDescrip());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image_taobao;
        TextView txt_title_taobao,txt_descrip_taobao;
        public MyViewHolder(View itemView) {
            super(itemView);
            txt_title_taobao=(TextView)itemView.findViewById(R.id.txt_title_taobao);
            txt_descrip_taobao=(TextView)itemView.findViewById(R.id.txt_descrip_taobao);
            image_taobao=(ImageView)itemView.findViewById(R.id.image_taobao);
        }
    }
}
