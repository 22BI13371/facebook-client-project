package vn.edu.usth.facebookclient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import vn.edu.usth.facebookclient.adapter.ReelsViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Reels#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Reels extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private View mview;
    private final int[] tabIcons = {
            R.drawable.home,
            R.drawable.friends,
            R.drawable.more,
            R.drawable.noti,
            R.drawable.menu
    };
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Reels() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Reels.
     */
    // TODO: Rename and change types and number of parameters
    public static Reels newInstance(String param1, String param2) {
        Reels fragment = new Reels();
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
        // Inflate the layout for this fragment
        mview =  inflater.inflate(R.layout.fragment_reels, container, false);
        tabLayout = mview.findViewById(R.id.tab);
//        viewPager = mview.findViewById(R.id.reels_pager);
//        viewPager.setOffscreenPageLimit(5);
        ReelsViewPagerAdapter adapter = new ReelsViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        //viewPager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Configure the tab for the corresponding position
            // You can set the tab title, icon, etc. here
            tab.setIcon(tabIcons[position]);
        }).attach();

        return mview;
    }
}