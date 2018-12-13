package com.project.hanlonglin.classsystem.util.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.hanlonglin.classsystem.R;

import java.util.List;

/**
 * 万能复用 ViewHolder
 */

/**
 * Created by hanlonglin on 2018/12/10.
 */

public abstract class TAdapter<T> extends BaseAdapter {
    List<T> list;
    int layoutRes;

    public TAdapter(List<T> list, int layoutRes) {
        this.list = list;
        this.layoutRes = layoutRes;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = bind(viewGroup.getContext(), view, layoutRes, i);
        bindView(holder, getItem(i));
        return holder.getItem();
    }

    private ViewHolder bind(Context context, View v, int layoutRes, int postion){
        ViewHolder holder = null;
        if (v == null) {
            holder = new ViewHolder(context, layoutRes);
        } else {
            holder = (ViewHolder) v.getTag();
        }
        holder.position = postion;
        return holder;
    }

    public abstract void bindView(ViewHolder holder, T obj);

    public class ViewHolder {
        private SparseArray<View> mViews;   //存储ListView 的 item中的View
        View item;
        int position;
        Context context;

        private ViewHolder(Context context, int layoutRes) {
            mViews = new SparseArray<>();
            this.context = context;
            View v = LayoutInflater.from(context).inflate(layoutRes, null, false);
            v.setTag(this);
            item = v;
        }

//        public static ViewHolder bind(Context context, View v, int layoutRes, int postion) {
//            ViewHolder holder = null;
//            if (v == null) {
//                holder = new ViewHolder(context, layoutRes);
//            } else {
//                holder = (ViewHolder) v.getTag();
//            }
//            holder.position = postion;
//            return holder;
//        }

        public View getItem() {
            return item;
        }

        public <T extends View> T getView(int id) {
            T t = (T) mViews.get(id);
            if (t == null) {
                t = (T) item.findViewById(id);
                mViews.put(id, t);
            }
            return t;
        }

        public ViewHolder setText(int id, String text) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView) view).setText(text);
            }
            return this;
        }

        public ViewHolder setImageView(int id, int src) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(src);
            }
            return this;
        }
    }
}
