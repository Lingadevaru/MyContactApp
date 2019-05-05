package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);//Content is set to the activity_second xml file

        // Get the transferred data from source activity.
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");

        //Multiple data lines(\n) are splitted and assigned into string array
        String[] splitarray = message.split("\n");

        //Array is assigned into different string variable
        String name = splitarray[0];
        String phone = splitarray[1];
        String id = splitarray[2];
        String PhotoId = splitarray[3];

        //Text view is assigned with different string to display in the User Interface
        TextView textView1 = (TextView)findViewById(R.id.requestDataTextView1);
        textView1.setText(name);

        TextView textView2 = (TextView)findViewById(R.id.requestDataTextView2);
        textView2.setText(phone);

        TextView textView3 = (TextView)findViewById(R.id.requestDataTextView3);
        textView3.setText(id);

        TextView textView4 = (TextView)findViewById(R.id.requestDataTextView4);
        textView4.setText(PhotoId);

    }
}
