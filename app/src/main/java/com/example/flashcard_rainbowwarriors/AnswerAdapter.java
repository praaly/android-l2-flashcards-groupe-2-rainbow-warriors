package com.example.flashcard_rainbowwarriors;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<String> answers;

    public AnswerAdapter(ArrayList<String> answers) {
        this.answers = answers;
    }

    @NonNull
    @Override
    public AnswerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.answer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnswerAdapter.ViewHolder holder, int position) {
        String answer = answers.get(position);
        holder.answerRadioButton.setText(answer);

/*        Country country = countries.get(position);
        holder.flag.setImageResource(country.getPicture());
        holder.symbol.setText(country.getCurrencySymbol());
        holder.rate.setText(country.getRate() + "");

        holder.itemView.setTag(country);
        holder.itemView.setOnClickListener(this);*/
    }

    @Override
    public int getItemCount() {
        return answers.size();
    }

    @Override
    public void onClick(View v) {

        //return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final RadioButton answerRadioButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            answerRadioButton = itemView.findViewById(R.id.answerRadioButton);
        }
    }
}
