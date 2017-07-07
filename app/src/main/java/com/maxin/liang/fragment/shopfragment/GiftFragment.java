package com.maxin.liang.fragment.shopfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.maxin.liang.R;
import com.maxin.liang.activity.GoodsListActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.maxin.liang.fragment.shopfragment.TypeFragment.POSITION;

/**
 * Created by shkstart on 2017/7/6.
 */

public class GiftFragment extends Fragment {
    public static final String GIFTURL = "gift_url";
    @Bind(R.id.present_7_iv)
    ImageView present7Iv;
    @Bind(R.id.present_1_iv)
    ImageView present1Iv;
    @Bind(R.id.present_2_iv)
    ImageView present2Iv;
    @Bind(R.id.present_3_iv)
    ImageView present3Iv;
    @Bind(R.id.present_4_iv)
    ImageView present4Iv;
    @Bind(R.id.present_5_iv)
    ImageView present5Iv;
    @Bind(R.id.present_6_iv)
    ImageView present6Iv;
    @Bind(R.id.set_gift_remind)
    ImageView setGiftRemind;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.gift_fragment, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.present_7_iv, R.id.present_1_iv, R.id.present_2_iv, R.id.present_3_iv, R.id.present_4_iv, R.id.present_5_iv, R.id.present_6_iv, R.id.set_gift_remind})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.present_7_iv:
                String murl="http://mobile.iliangcang.com/goods/goodsList?app_key=Android&count=10&list_id=7&page=1&sig=73760B2740FA36D5A273523FBC9295FE%7C285269230036268&v=1.0";
                Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                intent.putExtra(POSITION,murl);
                startActivity(intent);
                break;
            case R.id.present_1_iv:
                break;
            case R.id.present_2_iv:
                break;
            case R.id.present_3_iv:
                break;
            case R.id.present_4_iv:
                break;
            case R.id.present_5_iv:
                break;
            case R.id.present_6_iv:
                break;
            case R.id.set_gift_remind:
                break;
        }
    }
}
