package com.lyz.databinding.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.Toast;
import com.lyz.databinding.R;
import com.lyz.databinding.adapter.UserAdapter;
import com.lyz.databinding.adapter.UserAdapter.OnItemClickListener;
import com.lyz.databinding.bean.User;
import com.lyz.databinding.databinding.ActivityListBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * ListActivity.java
 * Author: liyanzhen
 * Date: 17/4/10
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class ListActivity extends AppCompatActivity implements OnKeyListener {

  private ActivityListBinding binding = null;
  private UserAdapter mUserAdapter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
    binding.setPresenter(new Presenter());
    /**
     *
     */
    binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    mUserAdapter = new UserAdapter(this);
    binding.recyclerview.setAdapter(mUserAdapter);

    mUserAdapter.setmListener(new OnItemClickListener() {
      @Override
      public void onUserClick(User user) {
        Toast.makeText(ListActivity.this, user.getUsername(), Toast.LENGTH_SHORT).show();
      }
    });

    List<User> lists = new ArrayList<>();
    lists.add(new User("lyz", "lyz", "on"));
    lists.add(new User("llh", "llh", "off"));
    lists.add(new User("zzj", "zzj", "on"));

    mUserAdapter.addAll(lists);
    binding.ll.setFocusable(true);
    binding.ll.setOnKeyListener(this);
  }

  @Override
  public boolean onKey(View v, int keyCode, KeyEvent event) {
    if (event.getAction() == KeyEvent.ACTION_UP) {
      return false;
    }
    Log.e("onKey", String.valueOf(pipei(keyCode)));
    if (pipei(keyCode) == 1) {
      Log.e("onKey1", String.valueOf(mUserAdapter.getItemCount()));
//      startActivity(new Intent(this, OnKeyActivity.class));
      return true;
    }
    if (pipei(keyCode) == 2) {
      Log.e("onKey2", String.valueOf(mUserAdapter.getItemId(1)));
//      startActivity(new Intent(this, OnKeyActivity.class));
      return true;
    }
    if (pipei(keyCode) == 3) {
      Log.e("onKey3", String.valueOf(mUserAdapter.getItemId(2)));
//      startActivity(new Intent(this, OnKeyActivity.class));
      return true;
    }
    return false;
  }

  public class Presenter {

    public void onAdd(View view) {
      mUserAdapter.add(new User("111", "111", "on"));
      mUserAdapter.add(new User("222", "222", "off"));
    }

    public void onRemove(View view) {
      mUserAdapter.remove();
    }
  }

  public int pipei(int keyCode) {
    switch (keyCode) {
      case 8://1
        return 1;
      case 9://2
        return 2;
      case 10://3
        return 3;
      case 11://4
        return 4;
      case 12://5
        return 5;
      case 13://6
        return 6;
      case 14://7
        return 7;
      case 15://8
        return 8;
      case 16://9
        return 9;
    }
    return -1;
  }
}
