package vn.edu.usth.facebookclient;

import android.content.Intent;
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

import com.facebook.CallbackManager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    //private LoginButton loginButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

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

        ViewPager2 viewPager = findViewById(R.id.pager);
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
                        getSupportActionBar().setTitle("Homepage");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Friends");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Add Post");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Noptifications");
                        break;
                    case 4:
                        getSupportActionBar().setTitle("Menu");
                        break;
                    case 5:
                        getSupportActionBar().setTitle("Profile");
                        break;
                    default:
                        getSupportActionBar().setTitle("Facebook Client");
                        break;
                }
            }
        });

//        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
//        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
//        tabLayout.getTabAt(2).setIcon(tabIcons[2]);


//        loginButton = findViewById(R.id.login_button);
//        callbackManager = CallbackManager.Factory.create();
//
//        loginButton.setPermissions(Arrays.asList("email", "user_gender", "user_age_range"));
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Log.d("debug", "Login successful");
//            }
//
//            @Override
//            public void onCancel() {
//                Log.d("debug", "Login canceled");
//            }
//
//            @Override
//            public void onError(@NonNull FacebookException e) {
//                Log.d("debug", "Login error");
//            }
//        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
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
        this.menu = menu;
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