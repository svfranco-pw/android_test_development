package com.example.santi.myandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private ListView mainListView;
    private ArrayAdapter<String> listAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainListView = (ListView) findViewById( R.id.mainListView );

        // Create a list of food.
        String[] planets = new String[] { "Burger", "Pizza", "Pasta" };
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the food list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, planetList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Selected item
                String content = ((TextView) view).getText().toString();

                Intent intent = new Intent(getApplicationContext(), ItemInfoActivity.class);

                if(content.equals("Pizza")) {
                    intent.putExtra("detail", "Pepperoni");
                } else if (content.equals("Burger")) {
                    intent.putExtra("detail", "Cheeseburger");
                } else if (content.equals("Pasta")) {
                    intent.putExtra("detail", "Carbonara");
                }
                intent.putExtra("content", content);
                startActivity(intent);
            }
        });
    }

    /** Called when the user taps the Add menu*/
    private void addItem(View view) {
        Intent intent;
        intent = new Intent(this, LinkingActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch(item.getItemId()) {
            case R.id.add:
                intent = new Intent(this, LinkingActivity.class);
                startActivity(intent);
                return(true);
            case R.id.edit:
                intent = new Intent(this, DisplayMessageActivity.class);
                startActivity(intent);
                return(true);
            case R.id.delete:
                //Toast.makeText(this, R.string.about_toast, Toast.LENGTH_LONG).show();
                return(true);
        }
            return(super.onOptionsItemSelected(item));
    }
}
