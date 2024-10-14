package vn.edu.usth.facebookclient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import vn.edu.usth.facebookclient.adapter.FriendRequestAdapter;

public class friend_list extends Fragment {

    private RecyclerView friendRequestsRecyclerView;
    private RecyclerView peopleYouMayKnowRecyclerView;
    private RecyclerView friendListRecyclerView;
    private TextView textView;

    public friend_list() {
        // Required empty public constructor
    }

    public static friend_list newInstance() {
        return new friend_list();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend_list, container, false);
        textView = view.findViewById(R.id.friendListTextView);

        // Initialize RecyclerViews
        friendRequestsRecyclerView = view.findViewById(R.id.friendRequestsRecyclerView);
//        peopleYouMayKnowRecyclerView = view.findViewById(R.id.peopleYouMayKnowRecyclerView);
        friendListRecyclerView = view.findViewById(R.id.friendListRecyclerView);

        // Set layout managers
        friendRequestsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        peopleYouMayKnowRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        friendListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        friendListRecyclerView.setVisibility(View.INVISIBLE);

        Button myFriendButton = view.findViewById(R.id.myFriendsButton);
        Button friendRequestButton = view.findViewById(R.id.friendRequestButton);

        myFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friendRequestsRecyclerView.setVisibility(View.INVISIBLE);
                friendListRecyclerView.setVisibility(View.VISIBLE);
                textView.setText(R.string.my_friends);
            }
        });

        friendRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                friendListRecyclerView.setVisibility(View.INVISIBLE);
                friendRequestsRecyclerView.setVisibility(View.VISIBLE);
                textView.setText(R.string.friend_requests);
            }
        });

        // Sample data for friend requests and people you may know
        List<String> friendRequests = Arrays.asList("John", "Sara", "Michael", "Anna", "David", "John", "Sara", "Michael", "Anna", "David", "John", "Sara", "Michael", "Anna", "David");
//        List<String> peopleYouMayKnow = Arrays.asList("Mary", "James", "Emily", "Peter", "Jane");

        // Set the adapters
        friendRequestsRecyclerView.setAdapter(new FriendRequestAdapter(friendRequests));
//        peopleYouMayKnowRecyclerView.setAdapter(new PeopleYouMayKnowAdapter(peopleYouMayKnow));

        return view;
    }
}
