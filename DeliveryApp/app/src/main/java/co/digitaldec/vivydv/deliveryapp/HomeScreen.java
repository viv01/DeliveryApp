package co.digitaldec.vivydv.deliveryapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A login screen that offers login via email/password.
 */
public class HomeScreen extends AppCompatActivity {

    FloatingActionButton addconsignment;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        context=this;

        final ListView listview = (ListView) findViewById(R.id.allconsignmentslist);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7" };

        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }
        //final homescreenlviewadapter adapter = new homescreenlviewadapter(this,android.R.layout.simple_list_item_1, list);
        final homescreenlviewadapter adapter = new homescreenlviewadapter(this,R.layout.allconsignmentslistrow, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener (new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // Start AddConsignment activity
                Intent myIntent = new Intent(HomeScreen.this,AddConsignment.class);
                startActivity(myIntent);
            }
        });

        addconsignment = (FloatingActionButton) findViewById(R.id.automaterobot);
        addconsignment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Start AViewConsignment activity
                Intent myIntent = new Intent(HomeScreen.this,ViewConsignment.class);
                startActivity(myIntent);
            }
        });

    }



}