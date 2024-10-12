package vn.edu.usth.facebookclient;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Homepage extends AppCompatActivity {
    //private static final String EMAIL = "email";
    private final int[] tabIcons = {
            R.drawable.home,
            R.drawable.friends,
            R.drawable.more,
            R.drawable.noti,
            R.drawable.menu,
            R.drawable.profile
    };
    private Menu menu;
    private int position;
    ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hompage);

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//
//            return insets;
//        });

//        PostList postList = new PostList();
//
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.main, postList)
//                .commit();
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(this);

        viewPager = findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(6);
        viewPager.setAdapter(adapter);
//        viewPager.setUserInputEnabled(false);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            // Set the icon for the tab
//            if (position < tabIcons.length) {
//                tab.setIcon(tabIcons[position]);
//            }
            tab.setIcon(tabIcons[position]);
            // Optionally set the title if required
            //tab.setText(adapter.getPageTitle(position));
        }).attach();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Homepage");

        toolbar.showOverflowMenu();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.d("ViewPager", String.valueOf(position));
                switch (position) {
                    case 0:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Homepage");
                        break;
                    case 1:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Friends");
                        break;
                    case 2:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Add Post");
                        break;
                    case 3:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Noptifications");
                        break;
                    case 4:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Menu");
                        break;
                    case 5:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Profile");
                        break;
                    default:
                        invalidateOptionsMenu();
                        getSupportActionBar().setTitle("Facebook Client");
                        break;
                }
            }
        });

//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);

    }


    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        int currectPagePos = viewPager.getCurrentItem();
        this.menu = menu;
        MenuItem menuItem;

        switch (currectPagePos) {
            case 0:
                menu.findItem(R.id.app_bar_profile).setVisible(true);
                menu.findItem(R.id.app_bar_settings).setVisible(false);
                menu.findItem(R.id.app_bar_refresh).setVisible(false);
                menu.findItem(R.id.app_bar_profile).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                break;
            case 1:
            case 2:
                menuItem = menu.findItem(R.id.app_bar_settings).setVisible(false);
                menu.findItem(R.id.app_bar_refresh).setVisible(false);
                break;
            case 3:
            case 4:
                menuItem = menu.findItem(R.id.app_bar_search).setVisible(false);
                menu.findItem(R.id.app_bar_settings).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                break;
            case 6:
                menu.findItem(R.id.app_bar_refresh).setVisible(false);

            default:
                break;
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int duration = Toast.LENGTH_SHORT;
        CharSequence refreshToast = "Refreshing";

        if (item.getItemId() == R.id.app_bar_refresh) {
            Toast toast = Toast.makeText(this /* MyActivity */, refreshToast, duration);
            toast.show();
            return true;
        } else if (item.getItemId() == R.id.app_bar_search) {
            Toast toast = Toast.makeText(this, "Searching", duration);
            toast.show();
            return true;
        } else if (item.getItemId() == R.id.app_bar_logout) {
            Toast toast = Toast.makeText(this, "Logging out", duration);
            toast.show();
            finish();
            return true;
        } else if (item.getItemId() == R.id.app_bar_profile) {
            viewPager.setCurrentItem(5, false);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

        //    @Override
//    public void onProfileButtonClicked() {
//        Fragment fragment = getParentFragmentManager().findFragmentById(R.id.main_frame_layout);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.main_frame_layout, new MyProfile()) // Replace with MyProfile fragment
//                .addToBackStack(null) // Add transaction to back stack
//                .commit();
//    }
    }
}