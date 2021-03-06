package com.lyz.databinding.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.databinding.repacked.org.antlr.v4.runtime.atn.LookaheadEventInfo;
import android.support.v7.view.menu.MenuView.ItemView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lyz.databinding.BR;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.Rec;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * RecAdapter.java
 * Author: liyanzhen
 * Date: 17/5/6
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class RecAdapter extends RecyclerView.Adapter<BindingViewHolder> {

  public List<Rec> mlists = new ArrayList<>();

  public RecAdapter(List<Rec> lists) {
    this.mlists = lists;
  }

  @Override
  public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding binding;
    binding = DataBindingUtil
        .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_rec, parent, false);
    return new BindingViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(BindingViewHolder holder, int position) {
    Rec rec = mlists.get(position);
    Log.e("fei-lyz", String.valueOf(rec.getShowFocus()) + "***" + position);
    if (rec.getShowFocus()) {
      Log.e("fei-lyz", "focus" + "**" + rec.getShowFocus());
      holder.itemView.setBackgroundResource(R.drawable.recyclerview_focous_bg);
    } else {
      Log.e("fei-lyz", "normal" + "**" + rec.getShowFocus());
      holder.itemView.setBackgroundResource(R.drawable.normal);
    }

    holder.getBinding().setVariable(BR.bean, rec);
    holder.getBinding().executePendingBindings();
  }

  @Override
  public void onBindViewHolder(BindingViewHolder holder, int position, List<Object> payloads) {
    super.onBindViewHolder(holder, position, payloads);
    if (payloads.isEmpty()) {
      onBindViewHolder(holder, position);
    } else {
      int i = (int) payloads.get(0);
      switch (i) {
        case 0:
          Log.e("lyz", String.valueOf(i));
          break;
        case 2:
          Log.e("lyz", String.valueOf(i) + "$$$$" + position);
//          Rec rec = mlists.get(position);
//          Log.e("lyz", String.valueOf(rec.getShowFocus()));
//          if (rec.getShowFocus()) {
//            Log.e("payload", "normal");
//            holder.itemView.setBackgroundResource(R.drawable.normal);
//          } else {
//            Log.e("payload", "focus");
//            holder.itemView.setBackgroundResource(R.drawable.recyclerview_focous_bg);
//          }
          break;
      }
    }
  }

  @Override
  public int getItemCount() {
    return mlists.size();
  }
}
