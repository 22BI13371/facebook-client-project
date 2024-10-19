package vn.edu.usth.facebookclient;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView profileNameTextView;
    private TextView profileLocationTextView;
    private TextView profileHometOwnTextView;
    private ImageView profilePicImageView;
    private ImageView profileBackgroundPicImageView;

    public MyProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MyProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static MyProfile newInstance(String param1, String param2) {
        MyProfile fragment = new MyProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_profile, container, false);
        profileNameTextView = view.findViewById(R.id.profileName);
        profilePicImageView = view.findViewById(R.id.profile_image);
        profileBackgroundPicImageView = view.findViewById(R.id.profileBackgroundImage);
        profileLocationTextView = view.findViewById(R.id.locationTextView);
        profileHometOwnTextView = view.findViewById(R.id.homeTownTextView);

        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest graphRequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                @Override
                public void onCompleted(@Nullable JSONObject jsonObject, @Nullable GraphResponse graphResponse) {
                    try {
                        assert jsonObject != null;
                        String name = jsonObject.getString("name");
                        String id  = jsonObject.getString("id");
                        String location = jsonObject.getJSONObject("location").getString("name");
                        String homeTown = jsonObject.getJSONObject("hometown").getString("name");

//                        Picasso.get().load("htt[://graph.facebook.com/" + id + "/picture?type=large").into(profilePicImageView);
//                        Picasso.get().load("htt[://graph.facebook.com/" + id + "/picture?type=cover").into(profileBackgroundPicImageView);
                        profileNameTextView.setText(name);
                        profileLocationTextView.setText(location);
                        profileHometOwnTextView.setText(homeTown);

                        Log.d("profile graph request", jsonObject.toString());
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            Bundle bundle = new Bundle();
            bundle.putString("fields", "gender, name ,id , location, hometown, relationship_status");

            graphRequest.setParameters(bundle);

            graphRequest.executeAsync();
        }
        // Inflate the layout for this fragment
        return view;
    }
}
