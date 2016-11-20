package com.sonhnlab.pc.zeamo;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.sonhnlab.pc.core.view.BaseRecyclerViewAdapter;
import com.sonhnlab.pc.zeamo.helper.FontHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by SonhnLab on 11/20/2016.
 */

public class AppBindingAdapter {

    //region Binding Adapters

    @BindingAdapter(value = {"items"})
    public static <T> void setAdapter(RecyclerView recyclerView, List<T> items) {
        if (recyclerView.getAdapter() instanceof BaseRecyclerViewAdapter) {
            BaseRecyclerViewAdapter adapter = (BaseRecyclerViewAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.setData(items);
            }
            return;
        }
    }

    @BindingAdapter(value = {"imageUrl", "placeHolder"})
    public static void loadImage(ImageView view, String url, Drawable error) {
        Picasso.with(view.getContext())
                .load(url)
                .error(error)
                .into(view);
    }

    @BindingAdapter(value = {"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        if (url == null || url.equals("")) {
            return;
        }
        Picasso.with(view.getContext())
                .load(url)
                .into(view);
    }

    @BindingAdapter(value = {"videoUrl"})
    public static void loadVideo(SimpleExoPlayerView view, String url) {
        if (url == null || url.equals("")) {
            return;
        }

        Uri mp4VideoUri = Uri.parse(url);
        String appName = view.getContext().getString(R.string.app_name);

        SimpleExoPlayer player = view.getPlayer();
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(view.getContext(),
                Util.getUserAgent(view.getContext(), appName), bandwidthMeter);
        ExtractorsFactory extractorsFactory = new DefaultExtractorsFactory();
        MediaSource videoSource = new ExtractorMediaSource(mp4VideoUri,
                dataSourceFactory, extractorsFactory, null, null);
        player.prepare(videoSource);
    }


    @BindingAdapter({"android:src"})
    public static void loadImage(ImageView view, int resource) {
        view.setImageResource(resource);
    }

    @BindingAdapter(value = {"font"})
    public static void setFont(TextView textView, String fontName) {
        textView.setTypeface(FontHelper.getTypeface(textView.getContext(), fontName));
    }

    //endregion
}
