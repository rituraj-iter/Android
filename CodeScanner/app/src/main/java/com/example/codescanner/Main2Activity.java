package com.example.codescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Main2Activity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView z;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        z=new ZXingScannerView(this);
        setContentView(z);
    }
    public void handleResult(Result result) {
        MainActivity.textView.setText(result.getText());
        onBackPressed();
    }
    protected void onResume() {
        super.onResume();
        z.setResultHandler(this);
        z.startCamera();
    }
    protected void onPause() {
        super.onPause();
        z.stopCamera();
    }
}
