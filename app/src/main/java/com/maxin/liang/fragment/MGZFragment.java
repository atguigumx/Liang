package com.maxin.liang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxin.liang.R;
import com.maxin.liang.activity.MGZActivity;
import com.maxin.liang.activity.MainActivity;
import com.maxin.liang.adapter.mgz.MGZAdapter;
import com.maxin.liang.bean.mgz.MGZBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/6.
 */

public class MGZFragment extends Fragment {
    @Bind(R.id.recyclerview_mgz)
    RecyclerView recyclerviewMgz;
    String url = "http://mobile.iliangcang.com/topic/magazineList?app_key=Android&author_id=1&sig=2FA0974FFF1BC3DFA562AA63C8B5A84F%7C118265010131868&v=1.0";
    @Bind(R.id.tv_title_date)
    TextView tvTitleDate;
    @Bind(R.id.mgz_titile)
    LinearLayout mgzTitile;
    private String[] keys;
    private List<MGZBean> beans = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_mgz, null);
        ButterKnife.bind(this, view);
        getDataFromNet(url);
        initView();
        return view;
    }

    private void initView() {
        mgzTitile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MGZActivity.class);
                startActivity(intent);
                MainActivity activity = (MainActivity) getActivity();
                activity.overridePendingTransition(R.anim.start_down,R.anim.close_up);
            }
        });
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MGZFragment", "onError" + e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }


        });
    }

    private void processData(String response) {
        try {
            JSONObject object = new JSONObject(response);
            if (object != null) {
                JSONObject data = object.optJSONObject("data");
                if (data != null) {
                    JSONObject items = data.optJSONObject("items");
                    if (items != null) {
                        JSONArray arrs = items.optJSONArray("keys");
                        if (arrs != null && arrs.length() > 0) {
                            keys = new String[arrs.length()];
                            for (int i = 0; i < arrs.length(); i++) {
                                keys[i] = (String) arrs.opt(i);
                            }
                            JSONObject infos = items.optJSONObject("infos");
                            for (int i = 0; i < arrs.length(); i++) {
                                JSONArray jsonArray = infos.optJSONArray(keys[i]);
                                for (int j = 0; j < jsonArray.length(); j++) {
                                    JSONObject jsonObject = jsonArray.optJSONObject(j);
                                    MGZBean productionBean = new MGZBean();
                                    productionBean.setAccess_url(jsonObject.optString("access_url"));
                                    productionBean.setTaid(jsonObject.optString("taid"));
                                    productionBean.setTopic_name(jsonObject.optString("topic_name"));
                                    productionBean.setCat_id(jsonObject.optString("cat_id"));
                                    productionBean.setAuthor_id(jsonObject.optString("author_id"));
                                    productionBean.setTopic_url(jsonObject.optString("topic_url"));
                                    productionBean.setCover_img(jsonObject.optString("cover_img"));
                                    productionBean.setCover_img_new(jsonObject.optString("cover_img_new"));
                                    productionBean.setHit_number(jsonObject.optInt("hit_number"));
                                    productionBean.setAddtime(jsonObject.optString("addtime").substring(0, 10));
                                    productionBean.setContent(jsonObject.optString("content"));
                                    productionBean.setNav_title(jsonObject.optString("nav_title"));
                                    productionBean.setAuthor_name(jsonObject.optString("author_name"));
                                    productionBean.setCat_name(jsonObject.optString("cat_name"));
                                    beans.add(productionBean);
                                }
                            }

                        }
                    }
                }
            }
            if (beans != null && beans.size() > 0) {
                MGZAdapter adapter = new MGZAdapter(getActivity(), beans);
                recyclerviewMgz.setAdapter(adapter);
                recyclerviewMgz.setLayoutManager(new GridLayoutManager(getActivity(),1));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
