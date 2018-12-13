package com.project.hanlonglin.handialog.util;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.project.hanlonglin.handialog.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hanlonglin on 2018/12/13.
 */

public class ImageLoader {
    //url
    public static void ShowImageByURl(Context context, String url, ImageView imageView)
    {
        Log.e("Picasso","url");
        Picasso.with(context).load(url).placeholder(R.drawable.handialog_defaultpic).into(imageView);
    }
    //id
    public static void ShowImageById(Context context,int id,ImageView imageView) {
        Log.e("Picasso", "id");
        Picasso.with(context).load(id).placeholder(R.drawable.handialog_defaultpic).into(imageView);
    }
}
