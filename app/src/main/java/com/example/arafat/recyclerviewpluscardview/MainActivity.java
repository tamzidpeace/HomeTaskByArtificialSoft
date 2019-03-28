package com.example.arafat.recyclerviewpluscardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> mExampleList;
    int value = 0;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createExampleList();
        createRecyclerView();


    }

    private void createRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(mExampleList);


        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new ExampleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();

        //api call
        String baseUrl = "https://api.myjson.com/bins/15baeq";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, baseUrl, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            for (int i = 0; i < response.getJSONArray("search_result").length() ; i++) {
                                String id = response.getJSONArray("search_result").getJSONObject(i).getString("id");
                                String user = response.getJSONArray("search_result").getJSONObject(i).getString("User");
                                String name = response.getJSONArray("search_result").getJSONObject(i).getString("name");
                                String who = response.getJSONArray("search_result").getJSONObject(i).getString("who");
                                String image = response.getJSONArray("search_result").getJSONObject(i).getString("image");
                                mExampleList.add(new ExampleItem
                                        (image, "ID: " + id, "User: " + user, "Name: " +name, "Who: " +who));
                            }
                            //Log.d(TAG, "onResponse: " + id);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);

        //mExampleList.add(new ExampleItem(R.drawable.anemone, "Anemone", "Line 2"));
        //mExampleList.add(new ExampleItem(R.drawable.calla_lily, "Calla Lily", "Line 4"));
        //mExampleList.add(new ExampleItem(R.drawable.dahlia, "Dahlia", "Line 6"));
    }

}
