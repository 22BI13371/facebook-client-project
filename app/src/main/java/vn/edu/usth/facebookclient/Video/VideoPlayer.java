package vn.edu.usth.facebookclient.Video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

import vn.edu.usth.facebookclient.R;

public class VideoPlayer extends AppCompatActivity {

    public static final String TAG = "VideoPlayer";
    ProgressBar round;
    ImageView fullScreenFunc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video_player);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //toolbar.setTitle();




        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);


        round = findViewById(R.id.progressBar);
        fullScreenFunc = findViewById(R.id.fullScreenOp);

        Intent intent = getIntent();
        Bundle data = intent.getExtras();
        assert data != null;
        Video v = (Video) data.getSerializable("VideoData");
        assert v != null;
        getSupportActionBar().setTitle(v.getTitle());
//        assert v != null;
        //Log.d(TAG, "oncreate: " + v.getTitle());

        TextView title = findViewById(R.id.videoTitle);
        TextView desc = findViewById(R.id.videoDesc);
        VideoView videoPlayer = findViewById(R.id.videoView);

        assert v != null;
        title.setText(v.getTitle());
        desc.setText(v.getDescription());
        Uri videoUrl = Uri.parse(v.getVideoUrl());
        videoPlayer.setVideoURI(videoUrl);
        MediaController mc = new MediaController(this);
        videoPlayer.setMediaController(mc);

        videoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoPlayer.start();
                round.setVisibility(View.GONE);
            }
        });
        fullScreenFunc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hide Action bar
                Objects.requireNonNull(getSupportActionBar()).hide();
                //Hide status bar
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}