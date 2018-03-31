package com.gatsan.track;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;


import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.gatsan.track.Fragment.HistoryRecords;
import com.gatsan.track.Fragment.Information;
import com.gatsan.track.Fragment.TrackingFragment;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class MainActivity extends AppCompatActivity {

    Drawer result;
    Toolbar toolbar;
    AHBottomNavigation bottomNavigation;
    String userInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        userInfo = intent.getStringExtra("key");


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, new TrackingFragment()).commit();
        loadDrawer(savedInstanceState);
        bottomNavigation(savedInstanceState);


    }

    private void loadDrawer(Bundle savedInstanceState) {
        //Head
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withCompactStyle(false)
                .withSavedInstance(savedInstanceState)
                .build();


        //Drawer
        result = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .withFullscreen(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("Devices").withIdentifier(0),
                        new PrimaryDrawerItem().withName("settings").withIdentifier(1),
                        new SecondaryDrawerItem().withName("about").withIdentifier(2),
                        new DividerDrawerItem(),
                        new PrimaryDrawerItem().withName("logout").withIdentifier(3)
                ).withSavedInstance(savedInstanceState)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        if (drawerItem != null) {
                            if (drawerItem.getIdentifier() == 0) {

//                                getSupportFragmentManager()
//                                        .beginTransaction()
//                                        .add(R.id.content_layout, new SendCommandFragment())
//                                        .commit();
                            }
                            if (drawerItem.getIdentifier() == 1) {

//                                getSupportFragmentManager()
//                                        .beginTransaction()
//                                        .add(R.id.content_layout, new SendCommandFragment())
//                                        .commit();
                            }
                            else if (drawerItem.getIdentifier() == 2) {
                                //logOut();
                            }
                            else {

                            }


                        }

                        return false;


                    }
                })
                .build();
    }

    private void bottomNavigation(Bundle savedInstanceState) {

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);

        // Create items
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("History",R.drawable.ic_history);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Tracking",R.drawable.ic_directions_car);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("Information",R.drawable.ic_info);



        // Add items
        bottomNavigation.addItem(item1);
        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);




        // Set current item programmatically
        bottomNavigation.setCurrentItem(1);

        bottomNavigation.setAccentColor(Color.parseColor("#40C4FF"));

        // Disable the translation inside the CoordinatorLayout
        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.setForceTint(true);

// Display color under navigation bar (API 21+)
// Don't forget these lines in your style-v21
// <item name="android:windowTranslucentNavigation">true</item>
// <item name="android:fitsSystemWindows">true</item>
        bottomNavigation.setTranslucentNavigationEnabled(true);

        // Set listeners
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                // Do something cool here..
                if (position == 0) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, new HistoryRecords()).commit();
                    Toast.makeText(MainActivity.this, "Tracking", Toast.LENGTH_SHORT).show();
                }
                if (position == 1) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, new TrackingFragment()).commit();
                    Toast.makeText(MainActivity.this, "History", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.crossfade_content, new Information()).commit();
                    Toast.makeText(MainActivity.this, "info", Toast.LENGTH_SHORT).show();
                }


                return true;
            }
        });
        bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
            @Override public void onPositionChange(int y) {
                // Manage the new y position
            }
        });

    }

}
