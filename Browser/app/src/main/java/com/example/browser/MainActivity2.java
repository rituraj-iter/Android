package com.example.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    public static final String MSG = "com.example.browser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void web(View view) {
        Intent intent=new Intent(this,MainActivity3.class);
        EditText editText=findViewById(R.id.editText);
        String url=editText.getText().toString();
        intent.putExtra(MSG,url);
        startActivity(intent);
    }

    public void google(View view) {
        Intent intent=new Intent(this,MainActivity4.class);
        startActivity(intent);
    }
}