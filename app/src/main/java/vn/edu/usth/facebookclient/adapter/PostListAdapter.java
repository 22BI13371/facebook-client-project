package vn.edu.usth.facebookclient.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.facebookclient.Post;
import vn.edu.usth.facebookclient.PostList;
import vn.edu.usth.facebookclient.R;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.PostViewHolder> {

    Context context;
    static ArrayList<Post> postArrayList;

    public PostListAdapter(Context context, ArrayList<Post> postArrayList) {
        this.context = context;
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_post_list,parent,false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Post post = postArrayList.get(position);
        holder.updatedText.setText(post.getUpdatedText());
        holder.time.setText(post.getTime());
        holder.commentNumber.setText(post.getCommentNumber());
        holder.iconNumber.setText(post.getIconNumber());
        holder.icon.setImageResource(post.getIcon());
        holder.imagePost.setImageResource(post.getImagePost());
        holder.avatar.setImageResource(post.getAvatar());

        boolean isExpanded = postArrayList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);


    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{

        ImageView avatar, imagePost, icon;
        TextView updatedText, time, iconNumber, commentNumber;
        LinearLayout expandableLayout;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatarPost);
            imagePost = itemView.findViewById(R.id.imagePost);
            icon = itemView.findViewById(R.id.iconPost);
            updatedText = itemView.findViewById(R.id.updatedTv);
            time = itemView.findViewById(R.id.timeTv);
            iconNumber = itemView.findViewById(R.id.numberIcon);
            commentNumber = itemView.findViewById(R.id.commentNumber);

            expandableLayout = itemView.findViewById(R.id.expandable);

            commentNumber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Post post = postArrayList.get(getAdapterPosition());
                    post.setExpanded(!post.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });

        }
    }

}
