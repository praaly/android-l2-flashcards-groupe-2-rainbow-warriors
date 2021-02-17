package com.example.flashcard_rainbowwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         *Sends the user to the "AboutActivity" activity
         * */
        Button aboutButton = findViewById(R.id.aboutButton);
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Access to the version of the application present in the build.gradle*/
                Context context = getApplicationContext();
                PackageManager packageManager = context.getPackageManager();
                String packageName = context.getPackageName();
                String myVersionName = "not available";
                try {
                    myVersionName = packageManager.getPackageInfo(packageName, 0).versionName;
                } catch (PackageManager.NameNotFoundException e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("appName", "Gun's Quizz");
                intent.putExtra("groupName", "Rainbow Warriors");
                intent.putExtra("versionName", myVersionName);
                startActivity(intent);
            }
        });
    }
}