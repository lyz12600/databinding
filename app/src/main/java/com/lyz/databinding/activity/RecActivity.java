package com.lyz.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.lyz.databinding.R;
import com.lyz.databinding.adapter.RecAdapter;
import com.lyz.databinding.bean.Rec;
import com.lyz.databinding.databinding.ActivityRecBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * RecActivity.java
 * Author: liyanzhen
 * Date: 17/5/6
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class RecActivity extends AppCompatActivity {

  public ActivityRecBinding binding;
  public LinearLayoutManager layoutManager;
  public RecAdapter adapter;
  public List<Rec> mlists = new ArrayList<>();
  public int currentIndex = 0;
  public Rec rec;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mlists = initData();
    binding = DataBindingUtil.setContentView(this, R.layout.activity_rec);

    layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
        false);
    adapter = new RecAdapter(mlists);
    binding.rc.setLayoutManager(layoutManager);
    binding.rc.setAdapter(adapter);
  }

  public List<Rec> initData() {
    for (int i = 0; i < 20; i++) {
      mlists.add(
          new Rec().setSeq(i).setContent("String" + i).setShowFocus(false).setShowImage(false));
    }
    mlists.get(0).setShowFocus(true);
    return mlists;
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    rec = adapter.mlists.get(currentIndex);
    switch (keyCode) {
      case 7://0
        if (currentIndex == 0) {
          return true;
        }
        scrollItem();
        if (rec.getShowImage()) {
          changeItem(0);
        } else {
          turnOver(0);
        }
        return true;
      case 8://1
        if (currentIndex == mlists.size() - 1) {
          return true;
        }
        scrollItem();
        if (rec.getShowImage()) {
          changeItem(1);
        } else {
          turnOver(1);
        }
        return true;
      case 66://enter
        rec = mlists.get(currentIndex);
        rec.setShowImage(!rec.getShowImage());
        adapter.notifyItemChanged(currentIndex);
        return true;
    }
    return false;
  }

  //未点重
  public void turnOver(int type) {
    rec.setShowFocus(false);
    adapter.notifyItemChanged(currentIndex);
    if (type == 0) {
      currentIndex--;
    } else {
      currentIndex++;
    }
    rec = adapter.mlists.get(currentIndex);
    rec.setShowFocus(true);
    adapter.notifyItemChanged(currentIndex);
  }

  //onkey 保证每个item在前台可见
  public void scrollItem() {
    int start = layoutManager.findFirstVisibleItemPosition();
    int end = layoutManager.findLastVisibleItemPosition();
    if (currentIndex == start + 1) {//上滑
      binding.rc.scrollBy(0, -1 * 400);
    }
    if (currentIndex == end - 1) {//下滑
      binding.rc.scrollBy(0, 400);
    }
  }

  public void changeItem(int type) {
    rec.setShowFocus(false);
    rec.setShowImage(false);
    adapter.notifyItemChanged(currentIndex);
    if (type == 0) {
      Collections.swap(mlists, currentIndex--, currentIndex);
    } else {
      Collections.swap(mlists, currentIndex++, currentIndex);
    }
    rec = mlists.get(currentIndex);
    rec.setShowFocus(true);
    rec.setShowImage(true);
    adapter.notifyItemChanged(currentIndex);
  }
}
