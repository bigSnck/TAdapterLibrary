package com.yt.adapterlibrary;

import android.content.Context;

import com.yt.baseadapterlibrary.TBaseAdapter;
import com.yt.baseadapterlibrary.base.adapter.ViewHolder;

import java.util.List;

public class ContentAdaper extends TBaseAdapter<String> {

    public ContentAdaper(Context context, List<String> data) {
        super(context, data, R.layout.adapter_content_item);
    }

    @Override
    public void convert(ViewHolder holder, String s) {

        holder.setText(R.id.item_tv_content,s);

    }
}
