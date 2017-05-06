package com.lyz.databinding.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * UserAdapter.java
 * Author: liyanzhen
 * Date: 17/4/10
 *
 * 编码格式： utf-8
 * 开发单位： 中南大学软件学院嵌入式与网络实验室
 * 版权：本文件版权归属于中南大学软件学院嵌入式与网络实验室和长沙洋华机电设备有限公司
 */

public class UserAdapter extends RecyclerView.Adapter<BindingViewHolder> {

  private static final int ITEM_VIEW_ON = 1;
  private static final int ITEM_VIEW_OFF = 2;

  private final LayoutInflater mLayoutInflater;
  private OnItemClickListener mListener;
  private List<User> mLists;

  public UserAdapter(Context context) {
    super();
    mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mLists = new ArrayList<>();
  }

  public interface OnItemClickListener {

    void onUserClick(User user);
  }

  @Override
  public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    ViewDataBinding binding = null;
    if (viewType == ITEM_VIEW_ON) {
      binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_user_on, parent, false);
    } else {
      binding = DataBindingUtil.inflate(mLayoutInflater, R.layout.item_user_off, parent, false);
    }
    return new BindingViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(final BindingViewHolder holder, final int position) {
    final User user = mLists.get(position);
    holder.getBinding().setVariable(com.lyz.databinding.BR.item, user);
    holder.getBinding().executePendingBindings();//及时刷新

//    holder.itemView.setOnClickListener(new OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        if (mListener != null) {
//          mListener.onUserClick(user);
//        }
//      }
//    });

    holder.itemView.setOnKeyListener(new OnKeyListener() {
      @Override
      public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == 8) {
          Toast.makeText(v.getContext(), position, Toast.LENGTH_SHORT).show();
          return true;
        }
        return false;
      }
    });
  }

  @Override
  public int getItemCount() {
    return mLists.size();
  }

  @Override
  public int getItemViewType(int position) {
    User user = mLists.get(position);
    if (user.getIsOn() == "on") {
      return ITEM_VIEW_ON;
    } else {
      return ITEM_VIEW_OFF;
    }
  }

  public void setmListener(OnItemClickListener mListener) {
    this.mListener = mListener;
  }

  public void addAll(List<User> users) {
    mLists.addAll(users);
  }

  Random random = new Random(System.currentTimeMillis());

  public void add(User user) {
    int position = random.nextInt(mLists.size() + 1);
    mLists.add(position, user);
    notifyItemInserted(mLists.size());
  }

  public void remove() {
    if (mLists.size() == 0) {
      return;
    }
    int position = random.nextInt(mLists.size());
    mLists.remove(position);
    notifyItemRemoved(position);
  }
}
