package com.lyz.databinding.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.DataModel;

/**
 * TypeTwoViewHolder.java
 * Author: liyanzhen
 * Date: 17/4/22
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */
public class TypeTwoViewHolder extends TypeAbstractViewHolder {

  public ImageView avatar;
  public TextView name;
  public TextView content;

  public TypeTwoViewHolder(View itemView) {
    super(itemView);

    avatar = (ImageView) itemView.findViewById(R.id.avatar);
    name = (TextView) itemView.findViewById(R.id.name);
    content = (TextView) itemView.findViewById(R.id.content);
  }

  @Override public void bindHolder(DataModel dataModel) {
    avatar.setBackgroundResource(dataModel.avatarColor);
    name.setText(dataModel.name);
    content.setText(dataModel.content);
  }
}