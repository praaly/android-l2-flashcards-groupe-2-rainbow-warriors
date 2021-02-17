package com.example.flashcard_rainbowwarriors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<Integer, String> hash = new HashMap<Integer, String>();
        hash.put(0, "Réponse 1");
        hash.put(1, "Réponse 2");
        Flashcard flashcard = new Flashcard("Question", 0, 0, hash, 0);

        findViewById(R.id.startButton).setOnClickListener(new View.OnClickListener() {

          @Override
          public void onClick(View v) {
              Intent intent = new Intent(MainActivity.this, FlashcardActivity.class);
              intent.putExtra("flashcard", flashcard);
              startActivity(intent);
          }
        });

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

                // TODO This should take informations from manifest
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("appName", "Gun's Quizz");
                intent.putExtra("groupName", "Rainbow Warriors");
                intent.putExtra("versionName", myVersionName);
                startActivity(intent);
            }
        });
    }
}