package com.example.examreview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.examreview.model.Question;
import com.google.gson.Gson;

public class DisplayAnswer extends AppCompatActivity {
    private TextView answerTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_answer);
        answerTV=findViewById(R.id.ans_container);

        Question q;
        Bundle bundle;
        bundle= getIntent().getExtras();
        if(bundle!=null){
            //retrieve object from intent
            Gson gson= new Gson();
            q=gson.fromJson(bundle.getString("questionObj"), Question.class);

            answerTV.setText(q.getQtext());
        }
    }
}
