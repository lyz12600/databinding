package com.lyz.databinding.activity;

import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.Observable.OnPropertyChangedCallback;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.Student;
import com.lyz.databinding.databinding.ActivityTwoWayBinding;

/**
 * TwoWayActivity.java
 * Author: liyanzhen
 * Date: 17/4/13
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class TwoWayActivity extends AppCompatActivity {
  public ActivityTwoWayBinding binding ;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_two_way);

    final Student student = new Student(23141);
    binding.setStudent(student);
    student.addOnPropertyChangedCallback(new OnPropertyChangedCallback() {
      @Override
      public void onPropertyChanged(Observable observable, int i) {
        Toast.makeText(TwoWayActivity.this, ((Student)observable).getName(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}
