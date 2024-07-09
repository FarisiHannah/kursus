package net.sf.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PersonActivity extends AppCompatActivity {

    private Toolbar personToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_person);

        personToolbar = findViewById(R.id.person_toolbar);
        personToolbar.setTitle("Person Activity");
        setSupportActionBar(personToolbar);

    }
}