package net.sf.firstapp;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

public class PersonActivity extends AppCompatActivity {

    private Toolbar personToolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    TabViewAdapater  adapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person);

        personToolbar = findViewById(R.id.person_toolbar);
        tabLayout = findViewById(R.id.tabUsersLayout);
        viewPager2 = findViewById(R.id.viewUsersPager);

        personToolbar = findViewById(R.id.person_toolbar);
        personToolbar.setTitle("Person Activity");
        setSupportActionBar(personToolbar);

        tabLayout.addTab(tabLayout.newTab().setText("Home"));
        tabLayout.addTab(tabLayout.newTab().setText("Share"));
        tabLayout.addTab(tabLayout.newTab().setText("Camera"));

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapater = new TabViewAdapater(fragmentManager, getLifecycle());
        viewPager2.setAdapter(adapater);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}