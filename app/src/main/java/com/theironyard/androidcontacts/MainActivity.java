package com.theironyard.androidcontacts;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {
    ArrayAdapter<String> contacts;

    ListView list;
    EditText name;
    EditText phone;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.listView);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        add = (Button) findViewById(R.id.button);

        contacts = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        list.setAdapter(contacts);

        add.setOnClickListener(this);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (!name.getText().toString().equals("") && !phone.getText().toString().equals("")) {
            String contact = name.getText().toString() + " " + "(" + phone.getText().toString() + ")";
            contacts.add(contact);
            name.setText("");
            phone.setText("");
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String contact = contacts.getItem(position);
        contacts.remove(contact);
        return true;
    }
}
