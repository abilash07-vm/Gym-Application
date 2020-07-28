package com.example.gymapplicants;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements planDetailDialog.passPlanInterface {
    public static final String TRAINING_KEY = "training";
    private static final String TAG = "TrainingActivity";
    private Button btnAddToMyPlan;
    private ImageView Trainingimg;
    private TextView TrainingName, longDesc;

    @Override
    public void getPlan(Plans plans) {
        Log.d(TAG, "getPlan: plan: " + plans.toString());
        if (Utils.addPlan(plans)) {
            Toast.makeText(this, plans.getTraining().getName() + " for " + plans.getMinutes() + " Minutes ,On " + plans.getDay() + " added Sucessfully ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PlanActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        init();
        Intent intent = getIntent();
        if (intent != null) {
            final Training training = intent.getParcelableExtra(TRAINING_KEY);
            if (training != null) {
                TrainingName.setText(training.getName());
                longDesc.setText(training.getLongDesc());
                Glide.with(this).asBitmap().load(training.getImageUrl()).into(Trainingimg);
                btnAddToMyPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        planDetailDialog dialog = new planDetailDialog();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(TRAINING_KEY, training);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(), "plan detail dialog");
                    }
                });
            }
        }
    }

    private void init() {
        Log.d(TAG, "init: Started");
        btnAddToMyPlan = findViewById(R.id.btnAddToYourPlan);
        Trainingimg = findViewById(R.id.TrainingImg);
        TrainingName = findViewById(R.id.TrainingName);
        longDesc = findViewById(R.id.longDec);
    }
}