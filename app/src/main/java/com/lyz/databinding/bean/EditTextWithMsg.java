package com.lyz.databinding.bean;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lyz.databinding.R;

/**
 * EditViewWithMsgHint.java
 * Author: liuzhige
 * Date: 2017/5/1
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式
 *
 * 与网络实验室
 * 版权： 本文件版权归属于长沙洋华机电设备有限公司
 */

public class EditTextWithMsg extends RelativeLayout {

  private EditText inputEditText;  //输入框
  private TextView bottomMsg;  //信息在输入框下面提示
  private TextView rightMsg;  //信息在输入框右边提示

  static final int NONE = -1;

  private String inputContent; //输入框内容
  private String msgContent;   //信息提示内容
  private boolean isShowMsg;   //是否显示信息
  private int msgTextColor;    //信息字体颜色
  private int inputGravity;

  public void setInputEditTextHeight(int inputEditTextHeight) {
    inputEditText.setHeight(inputEditTextHeight);
  }

  private int msgTextSize;     //信息字体大小
  private int inputContentTextSize;//输入框字体大小
  private int inputEditTextWidth;  //输入框宽度
  private int msgPosition = NONE;
  private int inputEditTextHeight; //输入框高度

  public boolean isShowMsg() {
    return isShowMsg;
  }

  public void setShowMsg(boolean showMsg) {
    isShowMsg = showMsg;
  }

  public void setMsgTextColor(int msgTextColor) {
    this.msgTextColor = msgTextColor;
    bottomMsg.setTextColor(msgTextColor);
    rightMsg.setTextColor(msgTextColor);
  }

  public void setMsgTextSize(int msgTextSize) {
    this.msgTextSize = msgTextSize;
    bottomMsg.setTextSize(msgTextSize);
    rightMsg.setTextSize(msgTextSize);
  }

  public void setInputContentTextSize(int inputContentTextSize) {
    this.inputContentTextSize = inputContentTextSize;
    inputEditText.setTextSize(inputContentTextSize);
  }

  public int getInputEditTextWidth() {
    return inputEditTextWidth;
  }

  public void setInputEditTextWidth(int inputEditTextWidth) {
    inputEditText.setWidth(inputEditTextWidth);
  }

  public String getInputContent() {
    inputContent = inputEditText.getText().toString();
    return inputContent;
  }

  public void setInputContent(String inputContent) {
    this.inputContent = inputContent;
    inputEditText.setText(inputContent);
  }

  public String getMsgContent() {
    return msgContent;
  }

  public void setMsgContent(String msgContent) {
    this.msgContent = msgContent;
    bottomMsg.setText(msgContent);
    rightMsg.setText(msgContent);
  }

  public EditTextWithMsg(Context context) {
    this(context, null);
  }

  public EditTextWithMsg(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public EditTextWithMsg(final Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    LayoutInflater.from(context).inflate(R.layout.edittext_with_msg, this);

    inputEditText = (EditText) findViewById(R.id.input_content);
    bottomMsg = (TextView) findViewById(R.id.msg_content_bottom);
    rightMsg = (TextView) findViewById(R.id.msg_content_right);

    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EditTextWithMsg);
    inputContent = a.getString(R.styleable.EditTextWithMsg_lzg_input_content);
    msgContent = a.getString(R.styleable.EditTextWithMsg_lzg_msg_content);
    isShowMsg = a.getBoolean(R.styleable.EditTextWithMsg_lzg_show_msg_content, false);
    msgTextColor = a.getColor(R.styleable.EditTextWithMsg_lzg_msg_text_color,
        getResources().getColor(R.color.colorPrimary));
    msgTextSize = a
        .getDimensionPixelSize(R.styleable.EditTextWithMsg_lzg_msg_text_size, 24);
    inputContentTextSize = a.getDimensionPixelSize(R.styleable.EditTextWithMsg_lzg_input_text_size,
        24);
    inputEditTextWidth = a
        .getDimensionPixelSize(R.styleable.EditTextWithMsg_lzg_input_content_width, 100);
    inputEditTextHeight = a
        .getDimensionPixelSize(R.styleable.EditTextWithMsg_lzg_input_content_height, 30);
    inputGravity = a.getInteger(R.styleable.EditTextWithMsg_lzg_input_content_gravity, 0);
    msgPosition = a.getInteger(R.styleable.EditTextWithMsg_lzg_msg_position, NONE);
    a.recycle();
    initConfig();
  }

  private void initConfig() {
    setInputEditTextHeight(inputEditTextHeight);
    setInputEditTextWidth(inputEditTextWidth);
    setMsgTextSize(msgTextSize);
    setInputEditTextGravity();
  }

  private void setInputEditTextGravity() {
    if (inputGravity == 0) {
      inputEditText.setGravity(Gravity.START);
    } else if (inputGravity == 1) {
      inputEditText.setGravity(Gravity.CENTER);
    } else {
      inputEditText.setGravity(Gravity.END);
    }
  }

  @Override
  protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
  }

  //隐藏信息提示
  private void hideMsgTextView() {
    bottomMsg.setVisibility(View.GONE);
    rightMsg.setVisibility(View.GONE);
  }

  /**
   * 显示信息
   *
   * @param msgContent 信息内容，默认红色
   */
  public void showMsg(String msgContent) {
    hideMsgTextView();
    if (isShowMsg) {
      if (msgPosition == 0) {
        bottomMsg.setVisibility(View.VISIBLE);
        bottomMsg.setTextColor(msgTextColor);
        setMsgContent(msgContent);
      } else {
        rightMsg.setVisibility(View.VISIBLE);
        rightMsg.setTextColor(msgTextColor);
        setMsgContent(msgContent);
      }
    }
  }

  /**
   * 显示信息
   *
   * @param msgContent 信息内容
   * @param msgTextColor 信息颜色
   */
  public void showMsg(String msgContent, int msgTextColor) {
    hideMsgTextView();
    if (isShowMsg) {
      if (msgPosition == 0) {
        bottomMsg.setVisibility(View.VISIBLE);
        bottomMsg.setTextColor(msgTextColor);
        setMsgContent(msgContent);
      } else {
        rightMsg.setVisibility(View.VISIBLE);
        rightMsg.setTextColor(msgTextColor);
        setMsgContent(msgContent);
      }
    }
  }

  //显示错误边框
  public void showErrorBg() {
    inputEditText.setBackgroundResource(R.drawable.bg_edittext_error);
  }

  //显示正常边框
  public void showNormalBg() {
    inputEditText.setBackgroundResource(R.drawable.bg_edittext);
  }

}
