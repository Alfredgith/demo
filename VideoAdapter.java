✅ COMPLETE VideoAdapter.java
Java
package com.example.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.model.Video;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private List<Video> videos;
    private Context context;

    public VideoAdapter(List<Video> videos, Context context) {
        this.videos = videos;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_video, parent, false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {

        Video video = videos.get(position);

        holder.tvTitle.setText(video.getTitle());

        holder.videoView.setVideoPath(video.getVideoUrl());

        MediaController mediaController =
                new MediaController(context);

        mediaController.setAnchorView(holder.videoView);

        holder.videoView.setMediaController(mediaController);

        holder.videoView.seekTo(1);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {

        VideoView videoView;
        TextView tvTitle;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoView = itemView.findViewById(R.id.videoView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
        }
    }
}
✅ ALSO CREATE item_video.xml
Inside:
Plain text
res/layout/item_video.xml
✅ item_video.xml
XML
<?xml version="1.0" encoding="utf-8"?>

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="8dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <TextView
        android:id="@+id/tvTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textStyle="bold"/>

    <VideoView
        android:id="@+id/videoView"
        android:layout_width="match_paren"
        android:layout_height="250dp"
        android:layout_marginTop="8dp"/>

</LinearLayout>
✅ IMPORTANT IMPORT
Inside HomeFragment.java add:
Java
import com.example.app.adapter.VideoAdapter;t
🔥 WHY THIS FIXES IT
Now Android Studio can find:
Plain text
VideoAdapter
because: