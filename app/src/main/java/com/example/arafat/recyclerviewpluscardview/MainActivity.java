package com.example.arafat.recyclerviewpluscardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ExampleItem> exampleItems = new ArrayList<>();
        exampleItems.add(new ExampleItem(R.drawable.ic_android, "Line 1", "Line 2"));
        exampleItems.add(new ExampleItem(R.drawable.ic_android, "Line 3", "Line 4"));
        exampleItems.add(new ExampleItem(R.drawable.ic_android, "Line 5", "Line 6"));
    }
}
