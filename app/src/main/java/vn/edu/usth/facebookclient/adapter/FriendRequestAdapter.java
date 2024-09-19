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

// Adapter class to handle the list of friend requests in a RecyclerView
public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {

    // List of friend requests' names to be displayed
    private final List<String> friendRequests;

    // Constructor to initialize the list of friend requests
    public FriendRequestAdapter(List<String> friendRequests) {
        this.friendRequests = friendRequests;
    }

    // This method inflates the layout for each friend request item (called when a new ViewHolder is created)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout for each friend request
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friend_request, parent, false);
        return new ViewHolder(view);
    }

    // This method binds the data to each item in the list (called for every visible item)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Bind the name of the friend request to the TextView
        holder.nameTextView.setText(friendRequests.get(position));
        // Future work: add click listeners for confirm and delete buttons here
        // e.g. holder.confirmButton.setOnClickListener(...)
    }

    // Returns the total number of items in the list
    @Override
    public int getItemCount() {
        return friendRequests.size();
    }

    // ViewHolder class that holds references to each view inside a single item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;   // TextView to display friend's name
        public final Button confirmButton;    // Button to confirm the friend request
        public final Button deleteButton;     // Button to delete the friend request

        // Constructor that binds views from the item layout (called when ViewHolder is created)
        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);  // Friend's name TextView
            confirmButton = view.findViewById(R.id.confirmButton); // Confirm request button
            deleteButton = view.findViewById(R.id.deleteButton);   // Delete request button
        }
    }
}