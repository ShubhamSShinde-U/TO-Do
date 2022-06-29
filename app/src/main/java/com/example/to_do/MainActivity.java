package com.example.to_do;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> todolist;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        todolist=new ArrayList<>();
        arrayAdapter=new ArrayAdapter<>(this,R.layout.list_view_layout,todolist);
        listView = findViewById(R.id.id_list_view);

        listView.setAdapter(arrayAdapter);
        editText=findViewById(R.id.id_edit_text);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView =(TextView) view;
                //additemtolist(textView);
                textView.setPaintFlags(textView.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
            }
        });

    }

    public void additemtolist(View view) {
        todolist.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();

        editText.setText("");
    }
}