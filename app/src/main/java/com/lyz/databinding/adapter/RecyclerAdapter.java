package com.lyz.databinding.adapter;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.DataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerAdapter.java
 * Author: liyanzhen
 * Date: 17/4/22
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  private LayoutInflater inflater;
  private List<DataModel> list = new ArrayList<>();
  private int height;

  public RecyclerAdapter(Context context) {
    inflater = LayoutInflater.from(context);
    height = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight();
  }

  public void addList(List<DataModel> lists) {
    list.addAll(lists);
  }

  @Override public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    switch (viewType) {
      case DataModel.TYPE_ONE:
        return new TypeOneViewHolder(inflater.inflate(R.layout.item_one, parent, false));
      case DataModel.TYPE_TWO:
        return new TypeOneViewHolder(inflater.inflate(R.layout.item_two, parent, false));
      case DataModel.TYPE_THREE:
        return new TypeOneViewHolder(inflater.inflate(R.layout.item_three, parent, false));
    }
    return null;
  }

  @Override public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    if (position == 0) {
      StaggeredGridLayoutManager.LayoutParams layoutParams =
          (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
      layoutParams.height = height;
      //layoutParams.setFullSpan(true);
    }
    ((TypeAbstractViewHolder) holder).bindHolder(list.get(position));
    //switch (viewType) {
    //  case DataModel.TYPE_ONE:
    //    return new TypeOneViewHolder(inflater.inflate(R.layout.item_one, parent, false));
    //  case DataModel.TYPE_TWO:
    //    return new TypeOneViewHolder(inflater.inflate(R.layout.item_two, parent, false));
    //  case DataModel.TYPE_THREE:
    //    return new TypeOneViewHolder(inflater.inflate(R.layout.item_three, parent, false));
    //}
  }

  @Override public int getItemViewType(int position) {
    return list.get(position).getType();
  }

  @Override public int getItemCount() {
    return list.size();
  }
}
