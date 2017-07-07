package com.maxin.liang.fragment.shopfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.maxin.liang.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shkstart on 2017/7/6.
 */

public class SpecialFragment extends Fragment {


    @Bind(R.id.iv_specialfragment)
    ImageView ivSpecialfragment;
    @Bind(R.id.relative)
    RelativeLayout relative;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.special_fragment, null);
        ButterKnife.bind(this, view);
        String url = "http://imgs-qn.iliangcang.com/ware/appimg/topic/cover/1926_.jpg?_t=1495105089";
        Glide.with(getActivity()).load(url).into(ivSpecialfragment);
        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
