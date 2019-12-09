package com.example.examreview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.examreview.data.DataBank;
import com.example.examreview.data.Interface;
import com.example.examreview.data.RecyclerViewAdapter;
import com.example.examreview.model.Question;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Question> questionList;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;
    private List<Question> newList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        questionList=new DataBank().getQuestions(new Interface() {
            @Override
            public void processFinished(ArrayList<Question> questionArrayList) {
                for(int i=0;i<questionArrayList.size();i++){
                    Log.d("json data","processFinished  :"+questionArrayList.get(i).getQtext());}

                recyclerView=findViewById(R.id.recyclerV);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                recyclerViewAdapter= new RecyclerViewAdapter(MainActivity.this, questionArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });



    }
}
