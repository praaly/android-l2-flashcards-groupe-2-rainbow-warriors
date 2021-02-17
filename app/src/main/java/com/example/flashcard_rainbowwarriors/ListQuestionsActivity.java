package com.example.flashcard_rainbowwarriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListQuestionsActivity extends AppCompatActivity {
    private ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_questions);

//        Intent intent = getIntent();
//        Flashcard flashcard = intent.getParcelableExtra("flashcard");

        ArrayList flashcards = new ArrayList<>();
        for (int i = 0; i<30; i++) {
            flashcards.add(new Flashcard("Question 1", 0, 0, new ArrayList<String>(), 0));
            flashcards.add(new Flashcard("Question 2", 0, 0, new ArrayList<String>(), 0));
            flashcards.add(new Flashcard("Question 3", 0, 0, new ArrayList<String>(), 0));
        }

        adapter = new ListAdapter(flashcards);

        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}