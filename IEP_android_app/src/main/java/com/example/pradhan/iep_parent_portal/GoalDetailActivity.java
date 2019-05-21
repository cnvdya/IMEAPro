package com.example.pradhan.iep_parent_portal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.pradhan.iep_parent_portal.responseVO.GoalDto;
import com.example.pradhan.iep_parent_portal.responseVO.TaskDto;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.text.DecimalFormat;

public class GoalDetailActivity extends AppCompatActivity {

    int goalID;
    String goalTitle, goalDesc;
    String baseUrl = "http://10.0.2.2:8080/student/";
    RequestQueue requestQueue;
    String url;
    ListView taskList;
    TaskDto[] tasks;
    TextView taskDesc;
    TextView goalTitle_Txt;
    TextView goalDesc_Txt;
    TextView status_Txt, percentage_Txt;
    ImageView imageView;
    int totalTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_detail);

        Intent intent = getIntent();

        if(intent.hasExtra("GOAL_ID")){
            goalID = intent.getIntExtra("GOAL_ID",0);
            goalTitle=intent.getStringExtra("GOAL_TITLE");
            goalDesc=intent.getStringExtra("GOAL_DESC");
        }

        goalTitle_Txt=(TextView)findViewById(R.id.goal_name);
        goalDesc_Txt=(TextView)findViewById(R.id.goal_desc);
        status_Txt= (TextView)findViewById(R.id.status);
        percentage_Txt= (TextView)findViewById(R.id.percentage);
        imageView= (ImageView) findViewById(R.id.imageView);
        goalTitle_Txt.setText(goalTitle);
        goalDesc_Txt.setText(goalDesc);

        url="gettasks?goalId="+goalID;
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
        taskList = (ListView)findViewById(R.id.taskDtoList);

        taskList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                TaskDto task = tasks[position];
                totalTask=task.getEvaluationTotal();
                Log.d("ID clicked",task.getTaskID()+"");
                Intent i = new Intent(getApplicationContext(),TaskActivity.class);
                i.putExtra("TASK_ID",task.getTaskID());
                i.putExtra("TASK_DESC",task.getTaskDescription());
                i.putExtra("TOTAL_EVAL",totalTask);
                i.putExtra("COMP_EVAL",task.getEvaluationCompleted());
                startActivity(i);
            }

        });



    }

    public void addFeedback (View view){
        Log.d("MY_APP","add feedback called");
        Intent i = new Intent(this,FeedbackActivity.class);
        startActivity(i);

    }




    private void setResponse(String s) {

        Gson gson = new Gson();

        tasks =  gson.fromJson(s,TaskDto[].class);
        int totalEval=0, compEval=0;
        float percentage=0;


        for(TaskDto task :tasks ){
            Log.d("GOAL TITLE:",task.getTaskDescription());
            totalEval=totalEval+task.getEvaluationTotal();
            compEval=compEval+task.getEvaluationCompleted();
        }

        percentage=compEval*100/totalEval;

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        System.out.println(df.format(percentage));
        percentage_Txt.setText(df.format(percentage)+"% Completed");
        if(percentage<=0){
            status_Txt.setText("Not Started");
            imageView.setImageResource(R.drawable.notstartedicon);
        }
        else if(percentage>0&&percentage<100){
            status_Txt.setText("In Progress");
            imageView.setImageResource(R.drawable.inprogressicon);
        }
        else if(percentage>=100){
            status_Txt.setText("Complete");
            imageView.setImageResource(R.drawable.completedicon);
        }

        CustomAdapter tasklist = new CustomAdapter(tasks);
        taskList.setAdapter(tasklist);

    }



    private class CustomAdapter extends BaseAdapter {
        TaskDto[] tasks;
        CustomAdapter(TaskDto[] tasks){
            this.tasks = tasks;
        }

        @Override
        public int getCount() {
            Log.d("LENGTH",tasks.length+"");
            return tasks.length;
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

            view = getLayoutInflater().inflate(R.layout.task_layout,null);
            taskDesc = (TextView)view.findViewById(R.id.task_name);
            taskDesc.setText(tasks[i].getTaskDescription());

            return view;
        }
    }
}
