package com.maxin.liang.activity.tuijian;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.maxin.liang.R;
import com.maxin.liang.activity.BaseActivity;
import com.maxin.liang.adapter.InfoTextAdapter;
import com.maxin.liang.bean.share.InfoBean.VideoInfoBean;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import butterknife.Bind;
import okhttp3.Call;

import static com.maxin.liang.adapter.share.TuiJianAdapter.CONTEXT;
import static com.maxin.liang.adapter.share.TuiJianAdapter.PASSTIME;
import static com.maxin.liang.adapter.share.TuiJianAdapter.TUIJIANID;
import static com.maxin.liang.adapter.share.TuiJianAdapter.UP;

public class TuiJianTextInfoActivity extends BaseActivity {

    @Bind(R.id.info_text)
    TextView infoText;
    @Bind(R.id.info_playcount)
    TextView infoPlaycount;
    @Bind(R.id.info_zan)
    TextView infoZan;
    @Bind(R.id.info_date)
    TextView infoDate;
    @Bind(R.id.info_recyclerview)
    RecyclerView infoRecyclerview;
    @Bind(R.id.activity_tui_jian_info)
    LinearLayout activityTuiJianInfo;
    private String videoUrl;
    private String playcount;
    private String up;
    private String text;
    private String passTime;

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        String id = getIntent().getStringExtra(TUIJIANID);
        up = getIntent().getStringExtra(UP);
        text = getIntent().getStringExtra(CONTEXT);
        passTime = getIntent().getStringExtra(PASSTIME);


        infoText.setText(text);
        infoZan.setText(up+"赞");
        infoDate.setText(passTime);

        String url="http://c.api.budejie.com/topic/comment_list/"+id+"/0/budejie-android-6.6.3/0-20.json";
        getDataFromNet(url);
    }

    private void getDataFromNet(String url) {
        OkHttpUtils.get().url(url).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                Log.e("TuiJianVideoInfoActivity", "onError= "+e.getMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                processData(response);
            }
        });
    }
    private void processData(String response) {
        VideoInfoBean videoInfoBean = JSONObject.parseObject(response, VideoInfoBean.class);
        List<VideoInfoBean.NormalBean.ListBean> list = videoInfoBean.getNormal().getList();
        if(list.size()>0&&list!=null) {
            infoRecyclerview.setAdapter(new InfoTextAdapter(this,list));
            infoRecyclerview.setLayoutManager(new GridLayoutManager(this,1));
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_tui_jian_text_info;
    }


}
