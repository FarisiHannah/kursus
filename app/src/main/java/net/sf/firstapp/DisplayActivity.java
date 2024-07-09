package net.sf.firstapp;

import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;


public class DisplayActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        toolbar = findViewById(R.id.display_toolbar);
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this,R.drawable.baseline_arrow_back_32));
        setSupportActionBar(toolbar);
    }
}