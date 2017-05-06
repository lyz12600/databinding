package com.lyz.databinding.activity;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.lyz.databinding.R;
import com.lyz.databinding.databinding.ActivityMainBinding;

/**
 * MainActivity.java
 * Author: liyanzhen
 * Date: 17/4/10
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class MainActivity extends Activity {

  ActivityMainBinding binding = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    binding.setPresenter(new Presenter());
  }

  public class Presenter {

    public void onClickListener1() {
      startActivity(new Intent(MainActivity.this, DatabindingBaseActivity.class));
    }

    public void onClickListener2() {
      startActivity(new Intent(MainActivity.this, ListActivity.class));
    }

    public void onClickListener3() {
      startActivity(new Intent(MainActivity.this, TwoWayActivity.class));
    }

    public void onClickListener4() {
      startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
    }

    public void onClickListener5() {
      startActivity(new Intent(MainActivity.this, EditTextActivity.class));
    }

    public void onClickListener6() {
      startActivity(new Intent(MainActivity.this, RecActivity.class));
    }
  }
}
