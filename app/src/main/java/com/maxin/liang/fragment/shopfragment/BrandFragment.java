package com.maxin.liang.fragment.shopfragment;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.maxin.liang.R;
import com.maxin.liang.activity.BrandInfoActivity;
import com.maxin.liang.bean.shop.BrandBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 * 品牌
 */

public class BrandFragment extends Fragment {
    public static final String BRANDID = "brand_id";
    @Bind(R.id.listview_brand)
    ListView listviewBrand;

    private MyAdapter myAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.brand_fragment, null);
        ButterKnife.bind(this, view);
        initData();
        return view;
    }

    private void initData() {
        getDataFromNet();
    }

    private void getDataFromNet() {
        String url = "http://mobile.iliangcang.com/brand/brandList?app_key=Android&count=20&page=1&sig=430BD99E6C913B8B8C3ED109737ECF15%7C830952120106768&v=1.0";
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("BrandFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        BrandBean brandBean = JSON.parseObject(response, BrandBean.class);
        final List<BrandBean.DataBean.ItemsBean> items = brandBean.getData().getItems();
        if (items.size() > 0 && items != null) {
            myAdapter = new MyAdapter(getActivity(),items);
            listviewBrand.setAdapter(myAdapter);
        }
        listviewBrand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BrandBean.DataBean.ItemsBean itemsBean = items.get(i);
                Intent intent = new Intent(getActivity(), BrandInfoActivity.class);
                intent.putExtra(BRANDID,itemsBean.getBrand_id());
                Log.e("BrandFragment", ""+itemsBean.getBrand_id());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    class MyAdapter extends BaseAdapter {

        private final Context context;
        private final List<BrandBean.DataBean.ItemsBean> items;

        public MyAdapter(Context context, List<BrandBean.DataBean.ItemsBean> items) {
            this.context=context;
            this.items=items;
        }

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
            return items.get(i).getBrand_id();
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = View.inflate(context, R.layout.brand_item, null);
                viewHolder=new ViewHolder(view);
                view.setTag(viewHolder);
            }else {
                viewHolder= (ViewHolder) view.getTag();
            }
            viewHolder.tvBrandItem.setText(items.get(i).getBrand_name());
            Glide.with(context)
                    .load(items.get(i).getBrand_logo()).into(viewHolder.ivBrandItem);
            return view;
        }

         class ViewHolder {
            @Bind(R.id.iv_brand_item)
            ImageView ivBrandItem;
            @Bind(R.id.tv_brand_item)
            TextView tvBrandItem;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);

            }
        }
    }
}
