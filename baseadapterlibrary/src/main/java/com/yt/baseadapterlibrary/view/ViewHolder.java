package com.yt.baseadapterlibrary.view;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private View mContainer;

    private View mView;

    private SparseArray mArrays;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mContainer = itemView;
        mArrays = new SparseArray();
    }

    /**
     * 优化后的
     *
     * @param id
     * @return
     */

    public View getView(int id) {

        mView = (View) mArrays.get(id);

        if (null == mView) {
            mView = mContainer.findViewById(id);
            mArrays.put(id, mView);
        }

        return mView;
    }


    /**
     * 设置textView
     *
     * @param viewId
     * @param text
     */
    public ViewHolder setText(int viewId, String text) {

        View viewText = mContainer.findViewById(viewId);

        if (viewText instanceof TextView) {

            ((TextView) viewText).setText(text);
        }

        return this;
    }


    public ViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }


    public ViewHolder setImageRes(int viewId, int resId) {
        View view = getView(viewId);
        if (view instanceof ImageView) {
            ((ImageView) view).setImageResource(resId);
        }
        return this;
    }

    public ViewHolder setImageByUrl(Context context, int viewId, String imagePath, HolderImageLoader imageLoader) {

        if (imageLoader == null) {
            throw new NullPointerException("imageLoader is null!");
        }

        imageLoader.dispalyImage(context, (ImageView) getView(viewId), imagePath);
        return this;
    }


    public abstract class HolderImageLoader {
        public HolderImageLoader() {
        }

        public abstract void dispalyImage(Context context, ImageView imageview, String imagePath);

    }



}
