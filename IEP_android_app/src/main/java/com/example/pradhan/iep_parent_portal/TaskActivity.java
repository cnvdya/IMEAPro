package com.example.pradhan.iep_parent_portal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pradhan.iep_parent_portal.responseVO.EvaluationDto;
import com.example.pradhan.iep_parent_portal.responseVO.TaskDto;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class TaskActivity extends AppCompatActivity {

    String taskdesc;
    int taskID, totaleval, compeval;
    float percentage;
    String baseUrl = "http://10.0.2.2:8080/student/";
    RequestQueue requestQueue;
    String url;
    EvaluationDto[] evaluations;
    ListView evaluationList;
    TextView feedback_cmnt, feedback_date, feedback_sentiment, strategy_used, result;

    ImageView imageView;
    TextView taskDesc_Txt;
    TextView status_Txt, percentage_Txt;
    ImageView imageView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Intent intent = getIntent();

        if(intent.hasExtra("TASK_ID")){
            taskID = intent.getIntExtra("TASK_ID",0);
            taskdesc=intent.getStringExtra("TASK_DESC");
            totaleval=intent.getIntExtra("TOTAL_EVAL",0);
            compeval= intent.getIntExtra("COMP_EVAL",0);
        }

        taskDesc_Txt=(TextView)findViewById(R.id.task_desc);
        status_Txt= (TextView)findViewById(R.id.status);
        percentage_Txt= (TextView)findViewById(R.id.percentage);
        imageView1= (ImageView) findViewById(R.id.imageView1);
        taskDesc_Txt.setText(taskdesc);


        percentage=compeval*100/totaleval;

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println(df.format(percentage));
        percentage_Txt.setText(df.format(percentage)+"% Completed");
        if(percentage<=0){
            status_Txt.setText("Not Started");
            imageView1.setImageResource(R.drawable.notstartedicon);
        }
        else if(percentage>0&&percentage<100){
            status_Txt.setText("In Progress");
            imageView1.setImageResource(R.drawable.inprogressicon);
        }
        else if(percentage>=100){
            status_Txt.setText("Complete");
            imageView1.setImageResource(R.drawable.completedicon);
        }

        url="getevaluations?taskID="+taskID;
        requestQueue = Volley.newRequestQueue(this);


        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                baseUrl + url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("REST RESPONSE", response.toString());
                        try {
                            setResponse(response.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("ERROR RESPONSE", error.toString());
                    }
                }
        )


        {
            @Override
            public String getBodyContentType() {
                return "application/json; charset=utf-8";
            }

        };


        requestQueue.add(objectRequest);
        evaluationList = (ListView)findViewById(R.id.evaluationDtoList);
    }

    public void addFeedback (View view){
        Log.d("MY_APP","add feedback called");
        Intent i = new Intent(this,FeedbackActivity.class);
        i.putExtra("TASK_ID",taskID);
        i.putExtra("TASK_DESC",taskdesc);
        i.putExtra("TOTAL_EVAL",totaleval);
        i.putExtra("COMP_EVAL",compeval);
        startActivity(i);


    }

    private void setResponse(String s) {

        Gson gson = new Gson();

        evaluations =  gson.fromJson(s, EvaluationDto[].class);


        for(EvaluationDto evaluation :evaluations ){
            Log.d("EVALUATION FEEDBACK:",evaluation.getComments());
        }

        CustomAdapter evaluationlist = new CustomAdapter(evaluations);
        evaluationList.setAdapter(evaluationlist);

    }


    private class CustomAdapter extends BaseAdapter {
        EvaluationDto[] evalutaions;
        CustomAdapter(EvaluationDto[] evalutaions){
            this.evalutaions = evalutaions;
        }

        @Override
        public int getCount() {
            Log.d("LENGTH",evalutaions.length+"");
            return evalutaions.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {

            view = getLayoutInflater().inflate(R.layout.evaluation_layout,null);
            feedback_cmnt=(TextView)view.findViewById(R.id.feedback_cmnt);
            feedback_date=(TextView)view.findViewById(R.id.feedback_date);
            feedback_sentiment=(TextView)view.findViewById(R.id.feedback_sentiment);
            strategy_used=(TextView)view.findViewById(R.id.strategy_used);
            result=(TextView)view.findViewById(R.id.result);
            imageView=(ImageView)view.findViewById(R.id.imageView);

            feedback_cmnt.setText(evalutaions[i].getComments());
            feedback_date.setText(evalutaions[i].getEvaluationDate());
            feedback_sentiment.setText(evalutaions[i].getAverageScore());
            strategy_used.setText(evalutaions[i].getStrategyUsed());

            if(evalutaions[i].getPassed()==1){
                result.setText("Complete");
                imageView.setImageResource(R.drawable.ic_check_circle_green_24dp);
            }
            else{
                result.setText("Needs Improvement");
                imageView.setImageResource(R.drawable.ic_error_yellow_24dp);
            }

            return view;
        }
    }
}
