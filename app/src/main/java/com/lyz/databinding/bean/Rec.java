package com.lyz.databinding.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Rec.java
 * Author: liyanzhen
 * Date: 17/5/6
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class Rec implements Parcelable {

  private Integer seq;
  private String content;
  private Boolean isShowImage;
  private Boolean isShowFocus;

  public Integer getSeq() {
    return seq;
  }

  public Rec setSeq(Integer seq) {
    this.seq = seq;
    return this;
  }

  public String getContent() {
    return content;
  }

  public Rec setContent(String content) {
    this.content = content;
    return this;
  }

  public Boolean getShowImage() {
    return isShowImage;
  }

  public Rec setShowImage(Boolean showImage) {
    isShowImage = showImage;
    return this;
  }

  public Boolean getShowFocus() {
    return isShowFocus;
  }

  public Rec setShowFocus(Boolean showFocus) {
    isShowFocus = showFocus;
    return this;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeValue(this.seq);
    dest.writeString(this.content);
    dest.writeValue(this.isShowImage);
    dest.writeValue(this.isShowFocus);
  }

  public Rec() {
  }

  protected Rec(Parcel in) {
    this.seq = (Integer) in.readValue(Integer.class.getClassLoader());
    this.content = in.readString();
    this.isShowImage = (Boolean) in.readValue(Boolean.class.getClassLoader());
    this.isShowFocus = (Boolean) in.readValue(Boolean.class.getClassLoader());
  }

  public static final Creator<Rec> CREATOR = new Creator<Rec>() {
    @Override
    public Rec createFromParcel(Parcel source) {
      return new Rec(source);
    }

    @Override
    public Rec[] newArray(int size) {
      return new Rec[size];
    }
  };
}
