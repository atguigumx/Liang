package com.maxin.liang.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxin.liang.R;

import butterknife.Bind;

public class MGZActivity extends BaseActivity {


    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.mgz_titile)
    LinearLayout mgzTitile;

    @Override
    public void initListener() {
        mgzTitile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(0,R.anim.close_up);
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_mgz;
    }

}
