package com.example.antoangiaothong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tvBack, tvNext, tvCurrentQuestion, tvTotalQuestion;
    private ViewPager2 viewPager2;
    private List<Question> mListQuestion;
    private int mCurrentItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        mListQuestion = getListQuestion();
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, mListQuestion);
        viewPager2.setAdapter(viewPagerAdapter);

        initListener();
    }


    private void initViews() {
        tvBack = findViewById(R.id.tv_back);
        tvNext = findViewById(R.id.tv_next);
        tvCurrentQuestion = findViewById(R.id.tv_current);
        tvTotalQuestion = findViewById(R.id.tv_total);
        viewPager2 = findViewById(R.id.view_pager);
        mCurrentItem = 0;
    }

    private void initListener() {
        tvTotalQuestion.setText(String.valueOf(mListQuestion.size()));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tvCurrentQuestion.setText(String.valueOf(position + 1));
                mCurrentItem = position;
                updateNextBackButton(position);
            }
        });

        tvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(mCurrentItem + 1);
            }
        });

        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager2.setCurrentItem(mCurrentItem - 1);
            }
        });
    }

    private void updateNextBackButton(int position) {
        if (position == 0) {
            tvBack.setVisibility(View.INVISIBLE);
        } else {
            tvBack.setVisibility(View.VISIBLE);
        }

        if (position == mListQuestion.size() - 1) {
            tvNext.setVisibility(View.INVISIBLE);
        } else {
            tvNext.setVisibility(View.VISIBLE);
        }
    }

    private List<Question> getListQuestion() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("1"));
        list.add(new Question("2"));
        list.add(new Question("3"));
        list.add(new Question("4"));
        list.add(new Question("5"));
        list.add(new Question("6"));
        list.add(new Question("7"));
        list.add(new Question("8"));
        list.add(new Question("9"));
        list.add(new Question("10"));
        return list;
    }
}