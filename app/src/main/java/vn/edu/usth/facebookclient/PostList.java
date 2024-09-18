package vn.edu.usth.facebookclient;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PostList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PostList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Post_list.
     */
    // TODO: Rename and change types and number of parameters
    public static PostList newInstance(String param1, String param2) {
        PostList fragment = new PostList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_post_list, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // Find the ImageButton in the fragment's layout
//        ImageButton profileButton = view.findViewById(R.id.toProfile);
//
//        profileButton.setOnClickListener(v -> {
//            Fragment fragment = getParentFragmentManager().findFragmentById(R.id.main_frame_layout);
//            if (fragment != null) {
//                getChildFragmentManager().beginTransaction()
////                        .hide(this) // Safely hide the fragment if it's not null
//                        .replace(R.id.main_frame_layout, new MyProfile()) // Replace with MyProfile fragment
//                        .addToBackStack(null) // Allow back navigation
//                        .commit();
//            } else {
//                // Optionally log or handle the case where no fragment is found
//                Log.d("FragmentTransaction", "No fragment found in the container to hide.");
//            }
//        });
//    }

    // Interface for communication
    public interface OnProfileButtonClickListener {
        void onProfileButtonClicked();
    }

    private OnProfileButtonClickListener callback;

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnProfileButtonClickListener) {
//            callback = (OnProfileButtonClickListener) context;
//        } else {
//            throw new RuntimeException(context.toString() + " must implement OnProfileButtonClickListener");
//        }
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Find the ImageButton in the fragment's layout
        ImageButton profileButton = view.findViewById(R.id.toProfile);

        // Set the click listener for the ImageButton
//        profileButton.setOnClickListener(v -> {
//            if (callback != null) {
//                callback.onProfileButtonClicked(); // Notify the activity
//            }
//        });
        profileButton.setOnClickListener(v -> {
            // Get the ViewPager from the activity
            ViewPager2 viewPager = getActivity().findViewById(R.id.pager);

            // Switch to the ProfileFragment (assuming it is at index 1)
            viewPager.setCurrentItem(5, false);
        });
    }
}