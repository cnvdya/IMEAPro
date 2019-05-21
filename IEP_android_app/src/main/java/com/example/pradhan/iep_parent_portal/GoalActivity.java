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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.pradhan.iep_parent_portal.responseVO.GoalDto;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class GoalActivity extends AppCompatActivity {

    TextView goalTitle;
    TextView goalDesc;
    ImageView imageView;
    String baseUrl = "http://10.0.2.2:8080/student/";
    RequestQueue requestQueue;
    String url;
    ListView goalList;
    GoalDto[] goals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

//        Intent intent = getIntent();

//        if(intent.hasExtra("USER_ID")){
//            userid = intent.getStringExtra("USER_ID");
//            sessionid=intent.getStringExtra("SESSION_ID");
//        }
        url="getgoals?studentId=103";
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

//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("USER_ID", userid);
//                params.put("SESSION_ID", sessionid);
//
//                return params;
//            }
        };

        //  stores.get(0);

        requestQueue.add(objectRequest);
        goalList = (ListView)findViewById(R.id.goalDtoList);


        goalList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
            GoalDto goal = goals[position];
            Log.d("ID clicked",goal.getGoalID()+"");
            Intent i = new Intent(getApplicationContext(),GoalDetailActivity.class);
                i.putExtra("GOAL_ID",goal.getGoalID());
                i.putExtra("GOAL_TITLE",goal.getGoalTitle());
                i.putExtra("GOAL_DESC",goal.getDescription());
                startActivity(i);
            }

        });
    }



    private void setResponse(String s) {

        Gson gson = new Gson();

        goals =  gson.fromJson(s,GoalDto[].class);


        for(GoalDto goal :goals ){
            Log.d("GOAL TITLE:",goal.getGoalTitle());
            Log.d("GOAL DESCRIPTION:",goal.getDescription());
        }

        CustomAdapter goallist = new CustomAdapter(goals);
        goalList.setAdapter(goallist);

    }

    private class CustomAdapter extends BaseAdapter {
        GoalDto[] goals;
        CustomAdapter(GoalDto[] goals){
            this.goals = goals;
        }

        @Override
        public int getCount() {
            Log.d("LENGTH",goals.length+"");
            return goals.length;
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

            view = getLayoutInflater().inflate(R.layout.goal_layout,null);
            goalTitle = (TextView)view.findViewById(R.id.goal_name);
            goalDesc = (TextView)view.findViewById(R.id.goal_desc);
            imageView = (ImageView)view.findViewById(R.id.imageView);

            goalTitle.setText(goals[i].getGoalTitle());
            goalDesc.setText(goals[i].getDescription());

            return view;
        }
    }
}
