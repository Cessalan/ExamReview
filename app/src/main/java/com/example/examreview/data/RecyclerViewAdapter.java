package com.example.examreview.data;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examreview.DisplayAnswer;
import com.example.examreview.R;
import com.example.examreview.model.Question;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Question> questionList;
    private Question q;

    public RecyclerViewAdapter(Context context, ArrayList<Question> questionList){
        this.context=context;
        this.questionList=questionList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    q=questionList.get(position);

    holder.questionTv.setText(q.getQtext());
    holder.questionTv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent= new Intent(context, DisplayAnswer.class);
            Gson gson= new Gson();
            String questionString=gson.toJson(q);

            intent.putExtra("questionObj",questionString);
            context.startActivity(intent);

        }
    });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView questionTv;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            questionTv=itemView.findViewById(R.id.text_container);

        }



    }
}
