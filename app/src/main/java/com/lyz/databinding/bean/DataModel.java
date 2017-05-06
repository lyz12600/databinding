package com.lyz.databinding.bean;

/**
 * DataModel.java
 * Author: liyanzhen
 * Date: 17/4/22
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class DataModel {

  public static final int TYPE_ONE = 1;
  public static final int TYPE_TWO = 2;
  public static final int TYPE_THREE = 3;

  public int type;
  public int avatarColor;
  public String name;
  public String content;
  public int contentColor;

  public static int getTypeOne() {
    return TYPE_ONE;
  }

  public static int getTypeTwo() {
    return TYPE_TWO;
  }

  public static int getTypeThree() {
    return TYPE_THREE;
  }

  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

  public int getAvatarColor() {
    return avatarColor;
  }

  public void setAvatarColor(int avatarColor) {
    this.avatarColor = avatarColor;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getContentColor() {
    return contentColor;
  }

  public void setContentColor(int contentColor) {
    this.contentColor = contentColor;
  }
}
