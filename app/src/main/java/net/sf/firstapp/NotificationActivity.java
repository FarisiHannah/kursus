package net.sf.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class NotificationActivity extends AppCompatActivity {

    private Toolbar notificationToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_notification);

        notificationToolbar = findViewById(R.id.notification_toolbar);
        notificationToolbar.setTitle("Notification Activity");
        setSupportActionBar(notificationToolbar);
    }


}