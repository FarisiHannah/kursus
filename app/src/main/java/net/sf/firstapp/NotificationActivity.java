package net.sf.firstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;

import net.sf.firstapp.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {

    private Toolbar notificationToolbar;
    private  ActivityNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        binding = ActivityNotificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        notificationToolbar = findViewById(R.id.notification_toolbar);
        notificationToolbar.setTitle("Notification Activity");
        setSupportActionBar(notificationToolbar);

        if(getSupportFragmentManager().findFragmentById(R.id.notifFragmentLayout)!=null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.notifFragmentLayout,HomeFragment.newInstance());
        }

        binding.navBottom.setOnItemSelectedListener(i -> {

            selectedFragmentByTitle(i.getTitle().toString());
            return true;

        });
        showFirstFragment();

    }

    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.activity_frame_layout);
        if(visibleFragment==null){
            selectedFragmentByTitle("Home");
        }
    }

    private void selectedFragmentByTitle(String title) {
        if(title.equals("Home")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.notifFragmentLayout,HomeFragment.newInstance()).commit();
        }
        else if(title.equals("Share")) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notifFragmentLayout,ShareFragment.newInstance("",""))
                    .commit();
        }
        else if(title.equals("Camera")) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notifFragmentLayout,CameraFragment.newInstance()).commit();
        }
    }
}