package com.example.browser;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tapadoo.alerter.Alerter;

import hotchemi.android.rate.AppRate;

public class MainActivity2 extends AppCompatActivity {

    public static final String MSG = "com.example.browser";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AppRate.with(MainActivity2.this)
                .setInstallDays(0)
                .setLaunchTimes(0)
                .setRemindInterval(0)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(MainActivity2.this);
    }

    public void web(View view) {
        Intent intent = new Intent(this, MainActivity3.class);
        EditText editText = findViewById(R.id.editText);
        String url = editText.getText().toString();
        intent.putExtra(MSG, url);
        startActivity(intent);
        Toast.makeText(this, "Directing to "+url, Toast.LENGTH_SHORT).show();
    }

    public void google(View view) {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
        Toast.makeText(this, "Directing to google.com", Toast.LENGTH_SHORT).show();
    }

    private boolean is_netAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void check(View view1) {
        if (is_netAvailable()) {
            Alerter.create(MainActivity2.this)
                    .setTitle("Internet Status")
                    .setText("Status:- Active")
                    .setIcon(R.drawable.ic_android_black_24dp)
                    .setBackgroundColorRes(R.color.colorAccent)
                    .setDuration(5000)
                    .enableSwipeToDismiss()
                    .enableProgress(true)
                    .setProgressColorRes(R.color.colorPrimary)
                    .show();
        } else {
            Alerter.create(MainActivity2.this)
                    .setTitle("Internet Status")
                    .setText("Status:- Not Active")
                    .setIcon(R.drawable.ic_android_black_24dp)
                    .setBackgroundColorRes(R.color.colorAccent)
                    .setDuration(5000)
                    .enableSwipeToDismiss()
                    .enableProgress(true)
                    .setProgressColorRes(R.color.colorPrimary)
                    .show();
        }
    }
}