package com.lyz.databinding.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.lyz.databinding.R;
import com.lyz.databinding.bean.User;
import com.lyz.databinding.databinding.ActivityDatabindingbaseBinding;

public class DatabindingBaseActivity extends AppCompatActivity {

  User user = new User("lyz", "llh", "321");
  ActivityDatabindingbaseBinding binding = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_databindingbase);
    binding.setUser(user);
    binding.setPresenter(new Presenter());
//    binding.setVariable(BR.user, user);//与上一行效果一致
  }

  public class Presenter {

    //方法一：方法绑定
    public void onTextChanged(CharSequence s, int start, int before, int count) {
      user.setUsername(s.toString());
      binding.setUser(user);
    }

    //方法二：监听器绑定
    public void onClickListenerBinding(User user) {
      Toast.makeText(DatabindingBaseActivity.this, user.getUsername(), Toast.LENGTH_SHORT).show();
    }
  }
}
