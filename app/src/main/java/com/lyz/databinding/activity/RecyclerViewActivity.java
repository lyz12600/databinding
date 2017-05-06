package com.lyz.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.lyz.databinding.R;
import com.lyz.databinding.adapter.RecyclerAdapter;
import com.lyz.databinding.bean.DataModel;
import com.lyz.databinding.databinding.ActivityRecyclerViewBinding;
import com.lyz.databinding.viewModel.RecyclerViewVM;
import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerViewActivity.java
 * Author: liyanzhen
 * Date: 17/4/22
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class RecyclerViewActivity extends AppCompatActivity {
  private ActivityRecyclerViewBinding binding;
  private RecyclerViewVM viewModel;
  private RecyclerAdapter adapter;

  int[] color = {
      android.R.color.holo_red_light, android.R.color.holo_blue_light,
      android.R.color.holo_orange_light
  };

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_view);
    //viewModel = new RecyclerViewVM();
    //binding.setViewModel(viewModel);

    //final GridLayoutManager s = new GridLayoutManager(this, 4, GridLayoutManager.HORIZONTAL, false);
    //s.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
    //  @Override public int getSpanSize(int position) {
    //    int type = binding.recyclerview.getAdapter().getItemViewType(position);
    //    //若是TYPE_THREE，占用两列，否则占用一列
    //    if (type == DataModel.TYPE_THREE) {
    //      return s.getSpanCount();
    //    } else {
    //      return 1;
    //    }
    //  }
    //});
    //binding.recyclerview.setLayoutManager(s);

    StaggeredGridLayoutManager s =
        new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
    binding.recyclerview.setLayoutManager(s);

    adapter = new RecyclerAdapter(this);
    binding.recyclerview.setAdapter(adapter);

    initData();
  }

  private void initData() {
    List<DataModel> list = new ArrayList<>();
    int type = 0;
    for (int i = 0; i < 20; i++) {
      if (i == 0) {
        type = 3;
      } else if (i < 10 && i > 0) {
        type = 2;
      } else {
        type = 1;
      }
      DataModel data = new DataModel();
      data.avatarColor = color[type - 1];
      data.type = type;
      data.name = "name" + i;
      data.contentColor = color[type - 1];
      data.content = "content" + i;
      list.add(data);
    }

    adapter.addList(list);
    adapter.notifyDataSetChanged();
  }
}
