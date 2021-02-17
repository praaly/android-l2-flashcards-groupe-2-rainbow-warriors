package com.example.flashcard_rainbowwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        /*Receives the values sent by MainActivity*/
        Intent srcIntent = getIntent();
        String appName = srcIntent.getStringExtra("appName");
        String groupName = srcIntent.getStringExtra("groupName");
        String versionName = srcIntent.getStringExtra("versionName");

        /*Creation of the ui with the received values*/
        TextView appTitleView = findViewById(R.id.appTitleTextView);
        appTitleView.setText(appName);
        TextView groupNameTextView = findViewById(R.id.groupNameTextView);
        groupNameTextView.setText("Created by" + " " + groupName);
        TextView versionNameTextView = findViewById(R.id.versionNameTextView);
        versionNameTextView.setText("Version :" + " " + versionName);
    }
}