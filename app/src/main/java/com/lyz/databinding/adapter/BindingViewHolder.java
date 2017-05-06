package com.lyz.databinding.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * BindingViewHolder.java
 * Author: liyanzhen
 * Date: 17/4/10
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{

  private T mBinding;

  public BindingViewHolder(T binding) {
    super(binding.getRoot());
    mBinding = binding;
  }

  public T getBinding(){
    return mBinding;
  }
}
