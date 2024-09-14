package vn.edu.usth.facebookclient.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import vn.edu.usth.facebookclient.R;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {

    private final List<String> friendRequests;

    public FriendRequestAdapter(List<String> friendRequests) {
        this.friendRequests = friendRequests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend_request, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(friendRequests.get(position));
        // Add more logic for confirm and delete buttons if necessary
    }

    @Override
    public int getItemCount() {
        return friendRequests.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;
        public final Button confirmButton;
        public final Button deleteButton;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            confirmButton = view.findViewById(R.id.confirmButton);
            deleteButton = view.findViewById(R.id.deleteButton);
        }
    }
}
