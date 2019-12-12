package com.yt.baseadapterlibrary.view;

public interface MultiTypeSupport<T> {
    // 根据当前位置或者条目数据返回布局
    public int getLayout(T item, int postion);
}
