package com.example.pradhan.iep_parent_portal;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.pradhan.iep_parent_portal.responseVO.MessageDto;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FeedbackActivity extends AppCompatActivity {

    EditText date_edttxt;
    String baseUrl = "http://10.0.2.2:8080/student/";
    RequestQueue requestQueue;
    String url;
    int taskID;
    String taskdesc;
    int  totaleval, compeval;
    EditText comment;
    Spinner task,strategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        date_edttxt=(EditText) findViewById(R.id.date_edttxt);
        comment=(EditText) findViewById(R.id.comment);
        task=(Spinner) findViewById(R.id.task_spinner);
        strategy=(Spinner) findViewById(R.id.strategy);

        Intent intent = getIntent();

        if(intent.hasExtra("TASK_ID")){
            taskID = intent.getIntExtra("TASK_ID",0);
            taskdesc=intent.getStringExtra("TASK_DESC");
            totaleval=intent.getIntExtra("TOTAL_EVAL",0);
            compeval= intent.getIntExtra("COMP_EVAL",0);
        }

        url="saveevaluation";
    }

    public void submitFeedback(View view){
        requestQueue = Volley.newRequestQueue(this);
        Log.d("TASK ID ", taskID+"");
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.POST,
                baseUrl + url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
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
            @Override
            public byte[] getBody() {
                try {
                    JSONObject jsonObject = new JSONObject();
                    Log.d("taskID",taskID+"");
                    jsonObject.put("evaluationDate", date_edttxt.getText().toString());
                    jsonObject.put("comments", comment.getText().toString());
                    jsonObject.put("strategyUsed", strategy.getSelectedItem().toString());
                    jsonObject.put("taskID",taskID);
                    final String mRequestBody = jsonObject.toString();

                    return mRequestBody == null ? null : mRequestBody.getBytes("utf-8");
                } catch (JSONException uee) {
                    uee.printStackTrace();
                    Log.e("ERROR RESPONSE", uee.getMessage());
                    return null;

                } catch (UnsupportedEncodingException uee) {
                    uee.printStackTrace();
                    Log.e("ERROR RESPONSE", uee.getMessage());
                    return null;
                }
            }


        };


        requestQueue.add(objectRequest);
    }

    private void setResponse(String s) {

        Gson gson = new Gson();
//
        MessageDto msg  =  gson.fromJson(s,MessageDto.class);

        if(msg.getMessage().equals("SUCCESS")){
           Intent i = new Intent(this,TaskActivity.class);
            i.putExtra("TASK_ID",taskID);
            i.putExtra("TASK_DESC",taskdesc);
            i.putExtra("TOTAL_EVAL",totaleval);
            i.putExtra("COMP_EVAL",compeval);
            Toast.makeText(this, "Feedback added successfully", Toast.LENGTH_LONG).show();
            startActivity(i);
            finish();

        }

        else {
            Toast.makeText(this, msg.getMessage(), Toast.LENGTH_LONG).show();
        }


    }



    public void showCalendar(View view){
        Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        System.out.println("the selected " + mDay);
        DatePickerDialog dialog = new DatePickerDialog(this,
                new mDateSetListener(), mYear, mMonth, mDay);
        dialog.show();
    }

    class mDateSetListener implements DatePickerDialog.OnDateSetListener {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            // getCalender();
            int mYear = year;
            int mMonth = monthOfYear;
            int mDay = dayOfMonth;
            date_edttxt.setText(new StringBuilder()
                    // Month is 0 based so add 1
                    .append(mMonth + 1).append("/").append(mDay).append("/")
                    .append(mYear).append(" "));
            System.out.println(date_edttxt.getText().toString());


        }
    }
}
