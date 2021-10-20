package com.example.motto_app;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetData {

    private final Context context;
    private String url;
    private Integer index;
    private String name;
    private String text;


    public GetData(Context context, String url, Integer index, String name) {
        this.context = context;
        this.url = url;
        this.index = index;
        this.name = name;
    }

    public void RequestGiver() {
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            JSONObject info = response.getJSONObject(index);
                            text = info.getString(name);

                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(context, "Something wrong", Toast.LENGTH_SHORT).show();
                    }
                });

        queue.add(request);
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

































//    RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
//    String url ="http://10.0.2.2:8080/quiz";
//
//    JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
//        @Override
//        public void onResponse(JSONArray response) {
//            String question = "";
//
//            try {
//                JSONObject cityInfo = response.getJSONObject(0);
//                question = cityInfo.getString("question");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//            Toast.makeText(MainActivity.this, "Question: " + question, Toast.LENGTH_SHORT).show();
//        }
//    }, new Response.ErrorListener() {
//        @Override
//        public void onErrorResponse(VolleyError error) {
//            error.printStackTrace();
//            Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
//        }
//    });
//
//                queue.add(request);