package vn.edu.usth.facebookclient;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.edu.usth.facebookclient.adapter.FriendListItemAdapter;
import vn.edu.usth.facebookclient.adapter.FriendRequestAdapter;

public class friend_list extends Fragment {

    private RecyclerView friendRequestsRecyclerView;
    private RecyclerView peopleYouMayKnowRecyclerView;
    private RecyclerView friendListRecyclerView;
    private TextView textView;
    private FriendListItemAdapter friendListItemAdapter;

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

        GraphRequest graphRequestFriend = GraphRequest.newMyFriendsRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONArrayCallback() {
            @Override
            public void onCompleted(@Nullable JSONArray jsonArray, @Nullable GraphResponse graphResponse) {
                assert jsonArray != null;
                Log.d("Graph response", jsonArray.toString());
                ArrayList<FBFriend> fbFriends = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i ++) {
                    try {
                        JSONObject object = jsonArray.getJSONObject(i);
                        fbFriends.add(new FBFriend(object.getString("id"), object.getString("name")));
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                friendListItemAdapter = new FriendListItemAdapter(fbFriends);
                friendListRecyclerView.setAdapter(friendListItemAdapter);
            }
        });

        graphRequestFriend.executeAsync();

        // Sample data for friend requests and people you may know
        List<String> friendRequests = Arrays.asList("John", "Sara", "Michael", "Anna", "David", "John", "Sara", "Michael", "Anna", "David", "John", "Sara", "Michael", "Anna", "David");
//        List<String> peopleYouMayKnow = Arrays.asList("Mary", "James", "Emily", "Peter", "Jane");

        // Set the adapters
        friendRequestsRecyclerView.setAdapter(new FriendRequestAdapter(friendRequests));
//        peopleYouMayKnowRecyclerView.setAdapter(new PeopleYouMayKnowAdapter(peopleYouMayKnow));

        return view;
    }
}
