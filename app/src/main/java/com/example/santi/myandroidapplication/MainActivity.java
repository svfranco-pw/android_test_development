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


        /*// storing string resources into Array
        String[] teams = getResources().getStringArray(R.array.teams);

        // Binding resources Array to ListAdapter
        this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, R.id.textview, teams));

        ListView lv = getListView();*/

        //listView = (ListView) findViewById(R.id.textview);

        // Find the ListView resource.
        mainListView = (ListView) findViewById( R.id.mainListView );

        // Create and populate a List of planet names.
        String[] planets = new String[] { "Mercury", "Venus", "Earth" };
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll( Arrays.asList(planets) );

        // Create ArrayAdapter using the planet list.
        listAdapter = new ArrayAdapter<String>(this, R.layout.list_item, planetList);

        // Set the ArrayAdapter as the ListView's adapter.
        mainListView.setAdapter( listAdapter );

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Selected item
                String team = ((TextView) view).getText().toString();

                Intent intent = new Intent(getApplicationContext(), ItemInfoActivity.class);
                intent.putExtra("team", team);
                startActivity(intent);
            }
        });
    }

    /** Called when the user taps the Send button */
    public void addItem(View view) {
        Intent intent;
        intent = new Intent(this, LinkingActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE, message);
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
                //EditText editText = (EditText) findViewById(R.id.editText);
                //String message = editText.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE, message);
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
