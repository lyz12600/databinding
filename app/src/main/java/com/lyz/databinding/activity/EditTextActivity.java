package com.lyz.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.lyz.databinding.R;
import com.lyz.databinding.databinding.ActivityEdittextBinding;

/**
 * EditTextActivity.java
 * Author: liyanzhen
 * Date: 17/5/2
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class EditTextActivity extends AppCompatActivity {

  ActivityEdittextBinding binding;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_edittext);
    binding.setViewModel(this);

    binding.temp1.setInputContent("aaa");
    binding.temp2.setInputContent("bbb");
    binding.btn.setText("submit");
    binding.btn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        binding.temp1.setShowMsg(true);
        binding.temp1.setMsgContent("ni cuo le");
        binding.temp1.showErrorBg();
      }
    });
  }
}
