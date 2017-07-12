package com.maxin.liang.fragment.mgzfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.activity.MGZActivity;
import com.maxin.liang.activity.MainActivity;
import com.maxin.liang.adapter.mgz.AuthorsAdapter;
import com.maxin.liang.bean.mgz.AuthorBean;
import com.maxin.liang.utils.NetConfig;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by shkstart on 2017/7/12.
 */

public class MGZAuthorFragment extends Fragment {
    public static final String MGZCHEKID = "mgz_chekid";
    public static final String MGZAUTHORNAME = "mgz_name";
    public static final String MGZURL = "mgz_url";
    private String[] urls = {
            NetConfig.LIANGCANG_URL,
            NetConfig.VOICER_URL,
            NetConfig.NLINE_URL,
            NetConfig.AMCREATIVE_URL,
            NetConfig.AOTUBANG_URL,
            NetConfig.MOGAN_URL,
            NetConfig.ILLAB_URL,
            NetConfig.DESIGHN_STATION_URL,
            NetConfig.TFHOURS_URL,
            NetConfig.TOPTS_URL,
            NetConfig.MTRIP_URL,
            NetConfig.WITHEATING_URL
    };
    @Bind(R.id.listview_author)
    ListView listviewAuthor;
    String authorUrl="http://mobile.iliangcang.com/topic/magazineAuthorList?app_key=Android&sig=2FA0974FFF1BC3DFA562AA63C8B5A84F%7C118265010131868&v=1.0";
    private AuthorsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.author_fragment, null);
        ButterKnife.bind(this, view);
        getDateFromNet();

        listviewAuthor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                if(i<urls.length) {
                    intent.putExtra(MGZURL, urls[i]);
                }
                intent.putExtra(MGZCHEKID,R.id.rb_main_magzine);
                intent.putExtra(MGZAUTHORNAME,adapter.getItem(i).getAuthor_name());

                MGZActivity activity = (MGZActivity) getActivity();
                activity.finish();
                activity.overridePendingTransition(R.anim.bottom_in, R.anim.top_out);

                startActivity(intent);
            }
        });

        return view;
    }

    private void getDateFromNet() {
        OkHttpUtils.get().url(authorUrl).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("MGZAuthorFragment", "onError="+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }

    private void processData(String response) {
        AuthorBean authorBean = JSONObject.parseObject(response, AuthorBean.class);
        List<AuthorBean.DataBean.ItemsBean> items = authorBean.getData().getItems();
        if(items!=null&&items.size()>0) {
            adapter = new AuthorsAdapter(getActivity(), items);
            listviewAuthor.setAdapter(adapter);

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
