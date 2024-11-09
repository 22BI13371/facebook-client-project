package vn.edu.usth.facebookclient.FriendProfile;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.facebookclient.adapter.FriendProfileAdapter;
import vn.edu.usth.facebookclient.FriendProfile.Friend;
import vn.edu.usth.facebookclient.R;

public class FriendProfileActivity extends AppCompatActivity {
    public static final String TAG = "FriendProfileActivity";
    RecyclerView friendListView;
    FriendProfileAdapter adapter;
    List<Friend> allFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_friend_profile);

        allFriends = new ArrayList<>();
        friendListView = findViewById(R.id.friendListView);
        friendListView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FriendProfileAdapter(this, allFriends);
        friendListView.setAdapter(adapter);

        getJsonData();
    }

    private void getJsonData() {
        String URL = "https://example.com/api/friends";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray friendsArray = response.getJSONArray("friends");
                    for (int i = 0; i < friendsArray.length(); i++) {
                        JSONObject friendJson = friendsArray.getJSONObject(i);
                        Friend friend = new Friend(
                                friendJson.getString("id"),
                                friendJson.getString("name"),
                                friendJson.getString("avatar"),
                                friendJson.getString("background"),
                                friendJson.getString("education"),
                                friendJson.getString("location"),
                                friendJson.getString("homeTown"),
                                friendJson.getString("relationshipStatus")
                        );
                        allFriends.add(friend);
                    }
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e(TAG, "JSON parsing error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Volley error: " + error.getMessage());
            }
        });

        requestQueue.add(objectRequest);
    }
}