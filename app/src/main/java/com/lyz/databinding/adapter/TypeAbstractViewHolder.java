package com.lyz.databinding.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.lyz.databinding.bean.DataModel;

/**
 * TypeAbstractViewHolder.java
 * Author: liyanzhen
 * Date: 17/4/22
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public abstract class TypeAbstractViewHolder extends RecyclerView.ViewHolder {
  public TypeAbstractViewHolder(View view) {
    super(view);
  }

  public abstract void bindHolder(DataModel data);
}
