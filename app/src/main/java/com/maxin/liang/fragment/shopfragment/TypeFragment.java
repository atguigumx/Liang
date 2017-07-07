package com.maxin.liang.fragment.shopfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.GoodsListActivity;
import com.maxin.liang.bean.shop.TypeBean;
import com.maxin.liang.utils.Constants;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class TypeFragment extends Fragment {
    public static final String POSITION = "position";
    @Bind(R.id.type_grid)
    GridView typeGrid;
    private List<TypeBean.DataBean.ItemsBean> items;
    private MyGridAdapter adapter;
    private String[] urls = new String[]{
            Constants.JIAJU1,
            Constants.JIAJU2,
            Constants.WENJU,
            Constants.SHUMA,
            Constants.WANLE,
            Constants.CHUWEI,
            Constants.MEISHI,
            Constants.NANZHUANG,
            Constants.NVZHUANG,
            Constants.TONGZHUANG,
            Constants.XIEBAO,
            Constants.PEISHI,
            Constants.MEIHU,
            Constants.HUWAI,
            Constants.ZHIWU,
            Constants.TUSHU,
            Constants.LIWU,
            Constants.TUIJIAN,
            Constants.YISHU
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.type_fragment, null);
        ButterKnife.bind(this, view);
        initData();
        initListener();
        return view;
    }

    private void initListener() {
        typeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), GoodsListActivity.class);
                intent.putExtra(POSITION,urls[i]);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        getDataFromNet();
    }

    private void getDataFromNet() {
        String url = "http://mobile.iliangcang.com/goods/goodsCategory?app_key=Android&sig=430BD99E6C913B8B8C3ED109737ECF15%7C830952120106768&v=1.0";
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("Type", "HttpOnError");
            }

            @Override
            public void onResponse(String response, int id) {
                processDate(response);
            }
        });
    }

    private void processDate(String response) {
        TypeBean typeBean = JSON.parseObject(response, TypeBean.class);
        items = typeBean.getData().getItems();
        if (items.size() > 0 && items != null) {
            adapter = new MyGridAdapter();
            typeGrid.setAdapter(adapter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class MyGridAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return items == null ? 0 : items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return Long.parseLong(items.get(i).getCat_id());
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(getActivity(), R.layout.type_item, null);
                viewHolder=new ViewHolder(view);
                view.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) view.getTag();
            }
            Glide.with(getActivity()).load(items.get(i).getNew_cover_img()).into(viewHolder.ivTypeItem);
            return view;
        }

         class ViewHolder {
            @Bind(R.id.iv_type_item)
            ImageView ivTypeItem;
            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
}
