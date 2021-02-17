package com.example.flashcard_rainbowwarriors;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

public class Flashcard implements Parcelable {
    String question;
    int picture;
    int sound;
    HashMap<Integer, String> answers;
    int indexRightAnswer;

    public Flashcard(String question, int picture, int sound, HashMap<Integer, String> answers, int indexRightAnswer) {
        this.question = question;
        this.picture = picture;
        this.sound = sound;
        this.answers = answers;
        this.indexRightAnswer = indexRightAnswer;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeInt(picture);
        dest.writeInt(sound);
        dest.writeInt(indexRightAnswer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Flashcard> CREATOR = new Creator<Flashcard>() {
        @Override
        public Flashcard createFromParcel(Parcel in) {
            return new Flashcard(in);
        }

        @Override
        public Flashcard[] newArray(int size) {
            return new Flashcard[size];
        }
    };

    public int getIndexRightAnswer() {
        return indexRightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public int getPicture() {
        return picture;
    }

    public int getSound() {
        return sound;
    }

    public HashMap<Integer, String> getAnswers() {
        return answers;
    }

    protected Flashcard(Parcel in) {
        question = in.readString();
        picture = in.readInt();
        sound = in.readInt();
    }

}
