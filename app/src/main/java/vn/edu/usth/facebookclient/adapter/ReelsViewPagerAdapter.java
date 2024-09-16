package vn.edu.usth.facebookclient.adapter;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import vn.edu.usth.facebookclient.GroupsFragment;
import vn.edu.usth.facebookclient.MakePostFragment;
import vn.edu.usth.facebookclient.Notifications;
import vn.edu.usth.facebookclient.PostList;
import vn.edu.usth.facebookclient.Reels;
import vn.edu.usth.facebookclient.friend_list;


public class ReelsViewPagerAdapter extends FragmentStateAdapter {
    private String[] titles = new String[] { "Posts", "Friends", "Notifications", "Profile" };  // Add your tab titles here
    public ReelsViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }



    @Override
    public int getItemCount() {

        return 5; // number of pages for a ViewPager
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new Reels();
            case 1: return new friend_list();
            case 2: return new MakePostFragment();
            case 3: return new Notifications();
        }
        return new Notifications();
    }
    public CharSequence getPageTitle(int page) {
        // returns a tab title corresponding to the specified page
        return titles[page];
    }
//    public CharSequence getPageTitle(int page) {
//// returns a tab title corresponding to the specified page
//        return titles[page];
//    }
}