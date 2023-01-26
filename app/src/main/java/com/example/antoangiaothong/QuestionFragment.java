package com.example.antoangiaothong;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);
        TextView textViewQuestion = view.findViewById(R.id.tv_question_content);
        Bundle bundle = getArguments();
        Question question = (Question) bundle.get("question_object_key");
        String questionName = question.getName();
        textViewQuestion.setText("This is question " + questionName);
        return view;
    }
}
