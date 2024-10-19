package vn.edu.usth.facebookclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.usth.facebookclient.FBFriend;
import vn.edu.usth.facebookclient.R;

public class FriendListItemAdapter extends RecyclerView.Adapter<FriendListItemAdapter.FriendItemViewHolder> {

    private ArrayList<FBFriend> fbFriends;

    public FriendListItemAdapter(ArrayList<FBFriend> fbFriends) {
        this.fbFriends = fbFriends;
    }

    @NonNull
    @Override
    public FriendItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_rv, parent, false);
        return new FriendItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendItemViewHolder holder, int position) {
        Picasso.get().load("https://graph.facebook.com/" + fbFriends.get(position).getId() + "/picture?type=large").into(holder.imageView);
        holder.textView.setText(fbFriends.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return fbFriends.size();
    }

    public void clear() {
        fbFriends.clear();
        notifyDataSetChanged();
    }

    public static class FriendItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public FriendItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.friendAvatarItem);
            textView = itemView.findViewById(R.id.friendNameItem);
        }
    }
}
