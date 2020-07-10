package com.example.notepad;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends Activity {
    Button n,s,o;
    EditText e;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n= findViewById(R.id.b1);
        s= findViewById(R.id.b2);
        o= findViewById(R.id.b3);
        e= findViewById(R.id.Writeup);
    }
    public void onclick(View v) {
        final EditText name=new EditText(this);
        AlertDialog.Builder a=new AlertDialog.Builder(this);
        a.setView(name);
        if (v.getId() == R.id.b2) {
            a.setMessage("save file");
            a.setPositiveButton("save",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        @SuppressLint("WorldReadableFiles") FileOutputStream f=openFileOutput(name.getText().toString()+".txt",MODE_WORLD_READABLE);
                        f.write(e.getText().toString().getBytes());
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error "+e,Toast.LENGTH_LONG).show();
                    }
                }
            });
            a.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            a.show();
        }
        if(v.getId()==R.id.b3) {
            a.setMessage("open file");
            a.setPositiveButton("open",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    int c;
                    e.setText("");
                    try {
                        FileInputStream f = openFileInput(name.getText().toString()+".txt");
                        while ((c = f.read()) != -1)
                        {
                            e.setText((e.getText().toString() + (char) c));
                        }
                    }catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error "+e,Toast.LENGTH_LONG).show();
                    }
                }
            });
            a.setNegativeButton("cancel",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            a.show();
        }
        if(v.getId()==R.id.b1) {
            e.setText("");
        }
    }
}