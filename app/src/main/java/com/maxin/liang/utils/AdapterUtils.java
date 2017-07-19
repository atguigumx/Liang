package com.maxin.liang.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.DisplayMetrics;

/**
 * 作者: WuKai
 * 时间: 2017/7/6
 * 邮箱: 648838173@qq.com
 * 作用:
 */

public class AdapterUtils {

    private static DisplayMetrics dm;
    public int screenWidth;
    public int screenHeigh;
    private Context context;
    private static AdapterUtils utils = new AdapterUtils();
    private Activity activity;

    private AdapterUtils() {
    }

    public static AdapterUtils getInstance(Activity activity) {
        if (activity != null) {
            dm = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        }
        return utils;
    }

    public int getScreenWidth() {
        return dm.widthPixels;
    }

    public int getScreenHeigh() {
        return dm.heightPixels;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param pxValue
     * @param （DisplayMetrics类中属性scaledDensity）
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }
    public static int dp2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (dip2px(context,pxValue) / fontScale + 0.5f);
    }
    /**
     * 转为圆形图片
     *
     * @param src 源图片
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src) {
        return toRound(src, false);
    }

    /**
     * 转为圆形图片
     *
     * @param src     源图片
     * @param recycle 是否回收
     * @return 圆形图片
     */
    public static Bitmap toRound(final Bitmap src, final boolean recycle) {
        int width = src.getWidth();
        int height = src.getHeight();
        int radius = Math.min(width, height) >> 1;
        Bitmap ret = Bitmap.createBitmap(width, height, src.getConfig());
        Paint paint = new Paint();
        Canvas canvas = new Canvas(ret);
        Rect rect = new Rect(0, 0, width, height);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(width >> 1, height >> 1, radius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(src, rect, rect, paint);
        if (recycle && !src.isRecycled()) src.recycle();
        return ret;
    }
}

