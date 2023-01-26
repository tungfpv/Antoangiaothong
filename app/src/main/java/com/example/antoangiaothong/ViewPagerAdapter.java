package com.example.antoangiaothong;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private List<Question> mListQuestion;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, List<Question> list) {
        super(fragmentActivity);
        this.mListQuestion = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        QuestionFragment questionFragment = new QuestionFragment();
        Question question = mListQuestion.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("question_object_key", question);
        questionFragment.setArguments(bundle);

        return questionFragment;
    }

    @Override
    public int getItemCount() {
        if (mListQuestion != null) {
            return mListQuestion.size();
        }
        return 0;
    }
}
