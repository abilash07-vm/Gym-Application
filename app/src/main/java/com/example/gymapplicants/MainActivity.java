package com.example.gymapplicants;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnMyplan, btnAllActivity, btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Utils.initTraining();
        System.out.println(Utils.getTrainings());
        btnAllActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, All_Training_Activity.class);
                startActivity(intent);
            }
        });
        btnMyplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlanActivity.class);
                startActivity(intent);
            }
        });
        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this).setTitle("About").setMessage("Created by Abilash \n" + "Visit For more");
                builder.setNegativeButton("Dissmiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(MainActivity.this, WebsiteActivity.class);
                        startActivity(intent);
                    }
                });
                builder.create().show();
            }
        });
    }

    private void init() {
        Log.d(TAG, "init: Started");
        btnMyplan = findViewById(R.id.btnMyPlans);
        btnAllActivity = findViewById(R.id.btnAllActivities);
        btnAboutUs = findViewById(R.id.AboutUs);
    }
}