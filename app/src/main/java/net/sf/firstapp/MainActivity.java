package net.sf.firstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private Fragment fragmentHome;
    private Fragment sendFragment;
    private Fragment shareFragment;
    private Fragment cameraFragment;


    private static final int FRAGMENT_HOME=0;
    private static final int FRAGMENT_SENT=1;
    private static final int FRAGMENT_CAMERA=2;
    private static final int FRAGMENT_SHARE=3;

    private void startTransactionFragment(Fragment fragment){
        if(!fragment.isVisible())
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_frame_layout,fragment).commit();
        }
    }

    private void showHomeFragment(){
        fragmentHome = HomeFragment.newInstance();
        startTransactionFragment(fragmentHome);
    }

    private void showCameraFragment(){
        cameraFragment = CameraFragment.newInstance();
        startTransactionFragment(cameraFragment);
    }

    private void showSendFragment(){
        sendFragment = SendFragment.newInstance("test","test2");
        startTransactionFragment(sendFragment);
    }

    private void showShareFragment(){
        shareFragment = ShareFragment.newInstance("test","test2");
        startTransactionFragment(shareFragment);
    }

    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_frame_layout);
        if(visibleFragment==null){
            selectedFragment(0);
            navView.getMenu().getItem(FRAGMENT_HOME).setChecked(true);
        }
    }

    private void selectedFragment(int index){
        switch (index) {
            case FRAGMENT_HOME:
                showHomeFragment();
                break;
            case FRAGMENT_SENT:
                showSendFragment();
                break;
            case FRAGMENT_CAMERA:
                showCameraFragment();
                break;
            case FRAGMENT_SHARE:
                showShareFragment();
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.drawer_home){
            selectedFragment(FRAGMENT_HOME);
        }
        if(item.getItemId()==R.id.drawer_send){
            selectedFragment(FRAGMENT_SENT);
        }
        if(item.getItemId()==R.id.drawer_camera){
            selectedFragment(FRAGMENT_CAMERA);
        }
        if(item.getItemId()==R.id.drawer_share){
            selectedFragment(FRAGMENT_SHARE);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //identify all widgets
        toolbar = findViewById(R.id.activity_main_toolbar);

        drawerLayout=findViewById(R.id.main) ;
        navView = findViewById(R.id.activity_navigation_view);

        //event handling widgets
        toolbar.setTitle("Test Android Toolbar");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this,R.drawable.icon_menu_32));
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this,R.drawable.baseline_more_white_32));
        setSupportActionBar(toolbar);

        //event handling untuk drawer layout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        toggle.syncState();

        //event handling untuk navigation view
        navView.setNavigationItemSelectedListener(this);

        showFirstFragment();
    }

    //menyematkan option menu kedalam toolbar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.menu_search){
            startActivity(new Intent(this,SearchActivity.class));
            return true;
        }
        if(item.getItemId()==R.id.menu_message) {
            startActivity(new Intent(this,MessageActivity.class));
            return true;
        }
        if(item.getItemId()==R.id.menu_notification){
            startActivity(new Intent(this,NotificationActivity.class));
            return true;
        }
        if(item.getItemId()==R.id.menu_person){
            startActivity(new Intent(this,PersonActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}