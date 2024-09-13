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

public class PeopleYouMayKnowAdapter extends RecyclerView.Adapter<PeopleYouMayKnowAdapter.ViewHolder> {

    private final List<String> peopleYouMayKnow;

    public PeopleYouMayKnowAdapter(List<String> peopleYouMayKnow) {
        this.peopleYouMayKnow = peopleYouMayKnow;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_people_you_may_know, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameTextView.setText(peopleYouMayKnow.get(position));
        // Add more logic for add friend and delete buttons if necessary
    }

    @Override
    public int getItemCount() {
        return peopleYouMayKnow.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;
        public final Button addFriendButton;
        public final Button deleteButton;

        public ViewHolder(View view) {
            super(view);
            nameTextView = view.findViewById(R.id.nameTextView);
            addFriendButton = view.findViewById(R.id.addFriendButton);
            deleteButton = view.findViewById(R.id.deleteButton);
        }
    }
}
