package net.sf.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MessageActivity extends AppCompatActivity {

    private Toolbar messageToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_message);

        messageToolbar = findViewById(R.id.message_toolbar);
        messageToolbar.setTitle("Message Activity");
        setSupportActionBar(messageToolbar);
    }
}