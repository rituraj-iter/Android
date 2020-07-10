package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    double a;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    void DollarstoRupees()
    {
        EditText d= (EditText) findViewById(R.id.entry1);
        d.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText  i=(EditText) findViewById(R.id.entry2);
        i.setInputType(InputType.TYPE_CLASS_NUMBER);
        double a=Integer.parseInt(d.getText().toString());
        double result=a*76.24;
        i.setText(String.valueOf(result));
    }
    void RupeestoDollars()
    {
        EditText d= (EditText) findViewById(R.id.entry1);
        d.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText  i=(EditText) findViewById(R.id.entry2);
        i.setInputType(InputType.TYPE_CLASS_NUMBER);
        double a=Integer.parseInt(i.getText().toString());
        double result=a/76.24;
        d.setText(String.valueOf(result));
    }
    public void tap(View view)
    {
        DollarstoRupees();
        Button b2=(Button) findViewById(R.id.TAP2);
        b2.setEnabled(false);
    }
    public void clear(View view)
    {
        Button b1=(Button) findViewById(R.id.TAP);
        b1.setEnabled(true);
        Button b2=(Button) findViewById(R.id.TAP2);
        b2.setEnabled(true);
        EditText d= (EditText) findViewById(R.id.entry1);
        EditText i=(EditText) findViewById(R.id.entry2);
        d.setText("");
        i.setText("");
    }
    public void tap2(View view)
    {
        Button b1=(Button) findViewById(R.id.TAP);
        b1.setEnabled(false);
        RupeestoDollars();
    }
}
