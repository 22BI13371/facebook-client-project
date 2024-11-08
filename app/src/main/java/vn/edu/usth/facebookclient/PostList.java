package vn.edu.usth.facebookclient;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

import vn.edu.usth.facebookclient.adapter.CommentAdapter;
import vn.edu.usth.facebookclient.adapter.PostListAdapter;

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
    private static final String TAG_COMMENTS = "POST_COMMENTS_TAG";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Post> postArrayList;
    private ArrayList<Comment> commentArrayList;
    private CommentAdapter commentAdapter;
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

        dataInitialize();

        RecyclerView recyclerView = view.findViewById(R.id.all_posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        PostListAdapter postListAdapter = new PostListAdapter(getContext(),postArrayList);
        recyclerView.setAdapter(postListAdapter);
        postListAdapter.notifyDataSetChanged();

    }

    private void dataInitialize() {
        postArrayList = new ArrayList<>();

        String[] postUpdatedText = new String[]{
                getString(R.string.Emily),
                getString(R.string.Ronaldo),
                getString(R.string.mbappe_updated_his_cover_photo),
        };

        String[] postTime = new String[]{
                getString(R.string.time_counter_text),
                getString(R.string.three_days_ago),
                getString(R.string.four_days_ago),
        };

        String[] postLike = new String[]{
                getString(R.string.like_number),
                getString(R.string._3b),
                getString(R.string.like_score)
        };
        String[] postComment = new String[]{
                getString(R.string.comment_number),
                getString(R.string.comment_score),
                getString(R.string.comment_number)
        };

        int[] postAvatar = new int[]{
                R.drawable.girl,
                R.drawable.ronaldo_2308_813_jpg,
                R.drawable.mbappe_real_betis_1,
        };

        int[] postImage = new int[]{
                R.drawable.nature_full_size_desktop_7680x4320_wallpaper_preview,
                R.drawable.ronaldo_900,
                R.drawable.mbappe,
        };
        int[] postIcon = new int[]{
                R.drawable.sad,
                R.drawable.heart,
                R.drawable.png_transparent_facebook_reaction_haha_hd_logo_thumbnail
        };

        for(int i = 0; i<postUpdatedText.length;i++){
            Post posts = new Post(postAvatar[i],postImage[i],postIcon[i],postUpdatedText[i],postTime[i],postLike[i],postComment[i]);
            postArrayList.add(posts);
        }

    }

    private void loadComments(){

    }
}