package demo.anonymous.example.com.baseactivity.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import demo.anonymous.example.com.baseactivity.R;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Glide图片加载工具类
 */
public class GlideUtil {

    /**
     * 加载图片
     *
     * @param context
     * @param resourceId
     * @param mImageView
     */
    static public<T> void setImage(Context context, T resourceId, ImageView mImageView) {
        Glide.with(context).load(resourceId).
                animate(R.anim.anim_glide_image_load).
                placeholder(R.mipmap.glide_loading).//加载时显示的图片
                error(R.mipmap.glide_loading).//加载错误时显示的图片
                fallback(R.mipmap.glide_loading).//出现数据为空的时候现实的图片
                into(mImageView);
    }


    /**
     * 加载图片（圆形）
     *
     * @param context
     * @param resourceId
     * @param mImageView
     */
    static public<T> void setCircleImage(Context context, T resourceId, ImageView mImageView) {
        Glide.with(context).load(resourceId).
                animate(R.anim.anim_glide_image_load).
                placeholder(R.mipmap.glide_loading).
                error(R.mipmap.glide_loading).
                fallback(R.mipmap.glide_loading).
        bitmapTransform(new CropCircleTransformation(context)).
        into(mImageView);

    }

    /**
     * 加载的图片（圆角）
     * coner自定义角度
     *
     * @param context
     * @param resourceId
     * @param coner      圆弧的弧度
     * @param mImageView
     */
    static public<T> void setRoundImage(Context context, T resourceId, int coner, ImageView mImageView) {
        Glide.with(context).load(resourceId).
//                animate(R.anim.anim_glide_image_load).
                bitmapTransform(new RoundedCornersTransformation(context,coner,0)).
                placeholder(R.mipmap.glide_loading).
                error(R.mipmap.glide_loading).
                fallback(R.mipmap.glide_loading).
                into(mImageView);
    }

    /**
     * 加载gif动画（网络获取）
     *
     * @param context
     * @param resourceId
     * @param mImageView
     */
    static public<T> void setGifImage(Context context, T resourceId, ImageView mImageView) {
        Glide.with(context).load(resourceId).asGif().
                diskCacheStrategy(DiskCacheStrategy.SOURCE).
//                animate(R.anim.anim_glide_image_load).
                placeholder(R.mipmap.glide_loading).//加载时显示的图片
                error(R.mipmap.glide_loading).//加载错误时显示的图片
                fallback(R.mipmap.glide_loading).//出现数据为空的时候现实的图片
                into(mImageView);
    }

}
