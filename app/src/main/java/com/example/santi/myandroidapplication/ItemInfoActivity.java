package com.example.santi.myandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Santi on 8/29/2017.
 */

public class ItemInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView content = (TextView) findViewById(R.id.textView2);
        TextView detail = (TextView) findViewById(R.id.textView);


        Intent i = getIntent();

        String foodtype = i.getStringExtra("content");
        String food = i.getStringExtra("detail");

        content.setText(foodtype);
        detail.setText(food);
    }

    public void editItem(View view) {
        Intent intent;
        intent = new Intent(this, EditItemInfoActivity.class);

        String content = ((TextView) findViewById(R.id.textView2)).getText().toString();
        String detail = ((TextView) findViewById(R.id.textView)).getText().toString();
        intent.putExtra("content", content);
        intent.putExtra("detail", detail);
        startActivity(intent);
    }

}
