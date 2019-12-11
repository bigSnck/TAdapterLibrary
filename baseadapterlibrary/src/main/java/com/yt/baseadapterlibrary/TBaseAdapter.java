package com.yt.baseadapterlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yt.baseadapterlibrary.base.adapter.MultiTypeSupport;
import com.yt.baseadapterlibrary.base.adapter.OnItemClickCallback;
import com.yt.baseadapterlibrary.base.adapter.OnItemLongClickCallback;
import com.yt.baseadapterlibrary.base.adapter.ViewHolder;

import java.util.List;

public abstract class TBaseAdapter<T> extends RecyclerView.Adapter<ViewHolder> {

    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    private int mLayoutId;
    protected List<T> mData;

    // 多布局支持
    private MultiTypeSupport mMultiTypeSupport;

    private OnItemClickCallback onItemClickCallback;
    private OnItemLongClickCallback onItemLongClickCallback;

    public TBaseAdapter(Context context, List<T> data, int layoutId) {
        this.mContext = context;
        this.mLayoutId = layoutId;
        this.mData = data;

        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public TBaseAdapter(Context context, List<T> data, MultiTypeSupport typeSupport) {
        this(context, data, -1);
        this.mMultiTypeSupport = typeSupport;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //多布局支持
        if (mMultiTypeSupport != null) {
            mLayoutId = viewType;
        }

        View itemView = mLayoutInflater.inflate(mLayoutId, parent, false);
        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }


    @Override
    public int getItemViewType(int position) {
        if (mMultiTypeSupport != null) {
            return mMultiTypeSupport.getLayout(mData.get(position), position);
        }

        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != onItemClickCallback) {
                    onItemClickCallback.onClick(mData.get(position));
                }
            }
        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (null != onItemLongClickCallback) {
                    onItemLongClickCallback.onLongClick(mData.get(position));
                }
                return false;
            }
        });

        convert(holder, mData.get(position));
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }


    public abstract void convert(ViewHolder holder, T t);


    public void setOnItemClickCallback(OnItemClickCallback listener) {
        onItemClickCallback = listener;
    }

    public void setOnItemLongClickCallback(OnItemLongClickCallback listener) {
        onItemLongClickCallback = listener;
    }

}
