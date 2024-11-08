package vn.edu.usth.facebookclient.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.usth.facebookclient.R;
import vn.edu.usth.facebookclient.Video.Video;
import vn.edu.usth.facebookclient.Video.VideoPlayer;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private final List<Video> allVideos;
    private final Context context;
    public VideoAdapter(Context ctx, List<Video> videos){
        this.allVideos = videos;
        this.context = ctx;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(allVideos.get(position).getTitle());
        Picasso.get()
                .load(allVideos.get(position).getImageUrl())
                .error(R.drawable.antony_to_balloon_dior_2024_here_we_go_v0_1mke82tdkxoc1)
                .into(holder.videoImage);
        holder.vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = holder.getAdapterPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    Bundle b = new Bundle();
                    b.putSerializable("VideoData", allVideos.get(currentPosition));
                    Intent intent = new Intent(context, VideoPlayer.class);
                    intent.putExtras(b);
                    view.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return allVideos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView videoImage;
        TextView title;
        View vv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoImage = itemView.findViewById(R.id.videoThumbnail);
            title = itemView.findViewById(R.id.videoTitle);
            vv = itemView;

        }
    }
}
