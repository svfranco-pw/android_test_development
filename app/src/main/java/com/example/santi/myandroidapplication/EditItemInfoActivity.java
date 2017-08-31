package com.example.santi.myandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by franco.santiago on 8/29/2017.
 */

public class EditItemInfoActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceBundle) {
        super.onCreate(savedInstanceBundle);
        setContentView(R.layout.activity_edit_item_info);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView content = (TextView) findViewById(R.id.contextText2);
        TextView detail = (TextView) findViewById(R.id.detailText2);


        Intent i = getIntent();
        String foodtype = i.getStringExtra("content");
        String food = i.getStringExtra("detail");

        content.setText(foodtype);
        detail.setText(food);
    }

}
