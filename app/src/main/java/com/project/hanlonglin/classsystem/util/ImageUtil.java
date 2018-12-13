package com.project.hanlonglin.classsystem.util;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by hanlonglin on 2018/12/10.
 */

public class ImageUtil {
    public static void showImageByUrl(Context context, ImageView imageView, String url)
    {
        Picasso.with(context).load(url).into(imageView);
    }
}
