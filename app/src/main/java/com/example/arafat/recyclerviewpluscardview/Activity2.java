 package com.example.arafat.recyclerviewpluscardview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

 public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Intent intent = getIntent();
        ExampleItem exampleItem = intent.getParcelableExtra("Example Item");

        int image = exampleItem.getmImageResource();
        String text1 = exampleItem.getmText1();
        String text2 = exampleItem.getmText2();

        ImageView imageView = findViewById(R.id.image_activity2);
        TextView textView1 = findViewById(R.id.text1_activity2);
        TextView textView2 = findViewById(R.id.text2_activity2);

        imageView.setImageResource(image);
        textView1.setText(text1);
        textView2.setText(text2);

    }
}
