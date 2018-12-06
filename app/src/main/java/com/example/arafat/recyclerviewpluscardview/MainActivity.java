package com.example.arafat.recyclerviewpluscardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ExampleItem> mExampleList;
    int value = 0;

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

               /* //not necessary
                if(value==0) {
                    mExampleList.get(position).changeText1("clicked");
                    mAdapter.notifyItemChanged(position);
                    value = 1;
                } else {
                    mExampleList.get(position).changeText1("again clicked");
                    mAdapter.notifyItemChanged(position);
                    value = 0;
                    System.out.println("hello world");
                }*/

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra("Example Item", mExampleList.get(position));

                startActivity(intent);
            }
        });
    }

    private void createExampleList() {
        mExampleList = new ArrayList<>();

        mExampleList.add(new ExampleItem(R.drawable.anemone, "Anemone", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.calla_lily, "Calla Lily", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.dahlia, "Dahlia", "Line 6"));
    }

}
