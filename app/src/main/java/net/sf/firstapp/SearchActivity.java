package net.sf.firstapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SearchActivity extends AppCompatActivity {

    private Toolbar searchToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);

        searchToolbar = findViewById(R.id.search_toolbar);
        searchToolbar.setTitle(" Search Activity");
        searchToolbar.setNavigationIcon(ContextCompat.getDrawable(this,R.drawable.baseline_arrow_back_32));
        setSupportActionBar(searchToolbar);
    }
}