package com.maxin.liang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.adapter.MasterFragmentAdapter;
import com.maxin.liang.bean.master.MasterBean;
import com.maxin.liang.utils.VirtualkeyboardHeight;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

import static com.maxin.liang.R.id.iv_title_search;


/**
 * Created by shkstart on 2017/7/6.
 */

public class MasterFragment extends Fragment {
    public static final int REQUEST_CODE = 33;
    @Bind(iv_title_search)
    ImageView ivTitleSearch;
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_title_shopcart)
    ImageView ivTitleShopcart;
    @Bind(R.id.recyclerview_masterfragment)
    RecyclerView recyclerviewMasterfragment;

    private MasterFragmentAdapter adapter;
    String url = "http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&page=1&sig=BF287AF953103F390674E73DDA18CFD8|639843030233268&v=1.0";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_master, null);
        ButterKnife.bind(this, view);
        tvTitle.setText("达人");
        getDataFromNet(url);
        initListener();
        return view;
    }

    private void initListener() {
        ivTitleShopcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopWindow();

            }
        });
        ivTitleSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }

    private void showPopWindow() {
        View view = View.inflate(getActivity(), R.layout.popupwindow_masterfragment, null);
        ImageView chahao = (ImageView) view.findViewById(R.id.iv_title_chahao);
        TextView morentuijian= (TextView) view.findViewById(R.id.tv_morentuijian);
        TextView zuiduotuijian= (TextView) view.findViewById(R.id.tv_zuiduotuijian);
        TextView zuishouhuanying= (TextView) view.findViewById(R.id.tv_zuishouhuanying);
        TextView zuixinjiaru= (TextView) view.findViewById(R.id.tv_zuixinjiaru);
        TextView zuixintuijian= (TextView) view.findViewById(R.id.tv_zuixintuijian);
        LinearLayout linearLayout= (LinearLayout) view.findViewById(R.id.linealayout_pop);
        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        window.setFocusable(true);
        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true

        window.showAtLocation(getActivity().findViewById(R.id.tiltle1),
                Gravity.BOTTOM, 0, VirtualkeyboardHeight.getBottomStatusHeight(getActivity()));
        chahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window.dismiss();
            }
        });
        //默认推荐点击
        final String morenUrl="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&orderby=goods_sum&page=1&sig=05D2057FE3D726A43A94505807516FC3%7C136072130089168&v=1.0";
        final String zuiduotuijianURL="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&orderby=goods_sum&page=1&sig=05D2057FE3D726A43A94505807516FC3%7C136072130089168&v=1.0";
        final String zuishouhuanyigUrl="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&orderby=followers&page=9&sig=05D2057FE3D726A43A94505807516FC3|136072130089168&v=1.0";
        final String zuixinjiaruUrl="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&orderby=action_time&page=9&sig=05D2057FE3D726A43A94505807516FC3|136072130089168&v=1.0";
        final String zuixintuijianUrl="http://mobile.iliangcang.com/user/masterList?app_key=Android&count=18&orderby=goods_sum&page=1&sig=05D2057FE3D726A43A94505807516FC3%7C136072130089168&v=1.0";
        morentuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromNet(morenUrl);
                window.dismiss();
            }
        });
        zuiduotuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromNet(zuiduotuijianURL);
                window.dismiss();
            }
        });
        zuishouhuanying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromNet(zuishouhuanyigUrl);
                window.dismiss();
            }
        });
        zuixinjiaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromNet(zuixinjiaruUrl);
                window.dismiss();
            }
        });
        zuixintuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromNet(zuixintuijianUrl);
                window.dismiss();
            }
        });
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                window.dismiss();
            }
        });
    }

    private void getDataFromNet(String url) {

        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MasterFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        MasterBean masterBean = JSONObject.parseObject(response, MasterBean.class);
        List<MasterBean.DataBean.ItemsBean> items = masterBean.getData().getItems();
        if (items.size() > 0 && items != null) {
            adapter = new MasterFragmentAdapter(getActivity(), items);
            recyclerviewMasterfragment.setAdapter(adapter);
            GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
            recyclerviewMasterfragment.setLayoutManager(manager);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
