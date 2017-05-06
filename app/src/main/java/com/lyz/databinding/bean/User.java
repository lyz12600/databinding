package com.lyz.databinding.bean;

/**
 * User.java
 * Author: liyanzhen
 * Date: 17/4/10
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class User {

  private String username;
  private String password;
  public String isOn;

  public User(String username, String password,String isOn) {
    this.username = username;
    this.password = password;
    this.isOn = isOn;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getIsOn() {
    return isOn;
  }

  public void setIsOn(String isOn) {
    this.isOn = isOn;
  }
}
