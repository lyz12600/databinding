package com.lyz.databinding.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.TextView;
import com.lyz.databinding.BR;

/**
 * Student.java
 * Author: liyanzhen
 * Date: 17/4/13
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class Student extends BaseObservable {
  @Bindable
  public String name;
  @Bindable
  public Integer age;

  public Student(String name) {
    this.name = name;
  }

  public Student(Integer age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    notifyPropertyChanged(BR.name);
  }


  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
    notifyPropertyChanged(BR.age);
  }

  @BindingAdapter("android:text")
  public static void setText(TextView view, int value) {
    view.setText(Integer.toString(value));
  }

  @BindingAdapter("android:text")
  public static void getText(TextView view, int value) {
    if (view.getText() != null
        && ( !view.getText().toString().isEmpty() )
        && Integer.parseInt(view.getText().toString()) != value) {
      view.setText(Integer.toString(value));
    }
  }
}
