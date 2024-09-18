package vn.edu.usth.facebookclient;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;


public class HomeFragmentPagerAdapter extends FragmentStateAdapter {
    private String[] titles = new String[] { "Posts", "Friends", "Notifications", "Profile" };  // Add your tab titles here
    public HomeFragmentPagerAdapter(AppCompatActivity activity) {
        super(activity);
    }



    @Override
    public int getItemCount() {

        return 6; // number of pages for a ViewPager
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            default: return new PostList();
            case 1: return new friend_list();
            case 2: return new MakePostFragment();
            case 3: return new Notifications();
            case 4: return new friend_list();
            case 5: return new MyProfile();
        }

        return new Menu();

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