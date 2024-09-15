package vn.edu.usth.facebookclient;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class MainActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    //private LoginButton loginButton;
    //private static final String EMAIL = "email";
    private final int[] tabIcons = {
            R.drawable.home,
            R.drawable.friends,
            R.drawable.more,
            R.drawable.noti,
            R.drawable.user__1_
    };


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
        viewPager.setOffscreenPageLimit(5);
        viewPager.setAdapter(adapter);

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
}