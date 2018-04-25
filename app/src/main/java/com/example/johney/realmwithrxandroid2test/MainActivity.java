package com.example.johney.realmwithrxandroid2test;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.johney.realmwithrxandroid2test.animation.AnimationActivity;
import com.example.johney.realmwithrxandroid2test.throttle.ThrottleSearchActivity;

import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {
    private ViewGroup container;
    private final TreeMap<String, Class<? extends Activity>> buttons = new TreeMap<String, Class<? extends Activity>>() {{
        put("Animation", AnimationActivity.class);
        put("Throttle search", ThrottleSearchActivity.class);
        }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.list);
        setupButtons();
    }

    private void setupButtons() {
        for (final Map.Entry<String, Class<? extends Activity>> entry : buttons.entrySet()) {
            Button button = new Button(this);
            button.setText(entry.getKey());
            button.setOnClickListener(view -> startActivity(entry.getValue()));
            container.addView(button);
        }
    }

    private void startActivity(Class<? extends Activity> activityClass) {
        startActivity(new Intent(this, activityClass));
    }
}
