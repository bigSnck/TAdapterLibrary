package com.yt.adapterlibrary;

import android.content.Context;
import android.widget.TextView;

import com.yt.baseadapterlibrary.TBaseAdapter;
import com.yt.baseadapterlibrary.base.adapter.MultiTypeSupport;
import com.yt.baseadapterlibrary.base.adapter.ViewHolder;

import java.util.List;

public class ContentMultAdaper extends TBaseAdapter<String> {

    public ContentMultAdaper(Context context, List<String> data) {
        super(context, data, new MultiTypeSupport() {
            @Override
            public int getLayout(Object item, int postion) {
                //设置不同类型的布局
                if(item.toString().contains("男男女女")){
                    return R.layout.adapter_content_item;
                }
                return R.layout.adapter_content1_item;
            }
        });
    }

    @Override
    public void convert(ViewHolder holder, String s) {

        holder.setText(R.id.item_tv_content, s);//直接可以设置文字内容
        TextView tv = (TextView) holder.getView(R.id.item_tv_content);//获取View

    }
}
