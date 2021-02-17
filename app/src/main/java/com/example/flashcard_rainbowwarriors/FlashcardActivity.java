package com.example.flashcard_rainbowwarriors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FlashcardActivity extends AppCompatActivity {

    private AnswerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcard);
        Intent intent = getIntent();
        Flashcard flashcard = intent.getParcelableExtra("flashcard");

        TextView questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(flashcard.question);

        ImageView questionPictureView = findViewById(R.id.questionPictureView);
        //Button playSoundButton = findViewById(R.id.playSoundButton);
        // TODO look for sound or image resource when needed

        questionPictureView.setImageDrawable(getResources().getDrawable(R.drawable.home_gun));

        //Log.d("Flashcard Activity", flashcard.answers.get(0));
        adapter = new AnswerAdapter(flashcard.answers);

        RecyclerView recyclerView = findViewById(R.id.answerRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}