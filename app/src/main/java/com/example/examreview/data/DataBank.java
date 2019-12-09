package com.example.examreview.data;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.examreview.controller.AppController;
import com.example.examreview.model.Question;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class DataBank {

    private String url="https://raw.githubusercontent.com/curiousily/simple-quiz/master/script/statements.json";
    AppController appController= new AppController();
    ArrayList<Question> questionArrayList= new ArrayList<>();


    public List<Question> getQuestions(final Interface callback){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for(int i=0;i<response.length();i++){

                            try{
                                Question question= new Question();
                                question.setQtext(response.getJSONArray(i).getString(0));
                                question.setAnswerTrue(response.getJSONArray(i).getBoolean(1));
                                questionArrayList.add(question);

                            }catch(Exception e){
                                e.printStackTrace();
                            }


                        }
                        if(callback!=null){
                            callback.processFinished(questionArrayList);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
       AppController.getInstance().addToRequestQueue(jsonArrayRequest);
        return questionArrayList;
    }







}
