package com.example.gymapplicants;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "PlanActivity";
    private TextView mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;
    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView, fridayRecView, saturdayRecView, sundayRecView;
    private RelativeLayout noPlanRelativeLayout;
    private NestedScrollView nestedScrollView;
    private Button btnAddPlan;
    private PlanAdaptor mondayAdaptor, tuesdayAdaptor, wednesdayAdaptor, thursdayAdaptor, fridayAdaptor, saturdayAdaptor, sundayAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initView();
        ArrayList<Plans> plans = Utils.getPlans();
        if (plans != null) {
            if (plans.size() > 0) {
                nestedScrollView.setVisibility(View.VISIBLE);
                noPlanRelativeLayout.setVisibility(View.GONE);
                initRecviews();
                setEditOnclickLisenners();
            } else {
                noPlanRelativeLayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                btnAddPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PlanActivity.this, All_Training_Activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        } else {
            noPlanRelativeLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
            btnAddPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PlanActivity.this, All_Training_Activity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    private void setEditOnclickLisenners() {
        final Intent intent = new Intent(this, EditActivity.class);
        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Monday");
                startActivity(intent);
            }
        });
        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Tuesday");
                startActivity(intent);
            }
        });
        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Wednesday");
                startActivity(intent);
            }
        });
        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Thursday");
                startActivity(intent);
            }
        });
        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Friday");
                startActivity(intent);
            }
        });
        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Saturday");
                startActivity(intent);
            }
        });
        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day", "Sunday");
                startActivity(intent);
            }
        });
    }

    private void initRecviews() {
        Log.d(TAG, "initRecviews: Started");
        mondayAdaptor = new PlanAdaptor(this);
        mondayRecView.setAdapter(mondayAdaptor);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this));
        mondayAdaptor.setPlan(getPlansByDay("Monday"));

        tuesdayAdaptor = new PlanAdaptor(this);
        tuesdayRecView.setAdapter(tuesdayAdaptor);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        tuesdayAdaptor.setPlan(getPlansByDay("Tuesday"));

        wednesdayAdaptor = new PlanAdaptor(this);
        wednesdayRecView.setAdapter(wednesdayAdaptor);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        wednesdayAdaptor.setPlan(getPlansByDay("Wednesday"));

        thursdayAdaptor = new PlanAdaptor(this);
        thursdayRecView.setAdapter(thursdayAdaptor);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        thursdayAdaptor.setPlan(getPlansByDay("Thursday"));

        fridayAdaptor = new PlanAdaptor(this);
        fridayRecView.setAdapter(fridayAdaptor);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        fridayAdaptor.setPlan(getPlansByDay("Friday"));

        saturdayAdaptor = new PlanAdaptor(this);
        saturdayRecView.setAdapter(saturdayAdaptor);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        saturdayAdaptor.setPlan(getPlansByDay("Saturday"));

        sundayAdaptor = new PlanAdaptor(this);
        sundayRecView.setAdapter(sundayAdaptor);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        sundayAdaptor.setPlan(getPlansByDay("Sunday"));
    }

    private ArrayList<Plans> getPlansByDay(String day) {
        ArrayList<Plans> allPlans = Utils.getPlans();
        ArrayList<Plans> plan = new ArrayList<>();
        for (Plans p : allPlans) {
            if (p.getDay().equalsIgnoreCase(day)) {
                plan.add(p);
            }
        }
        return plan;
    }

    private void initView() {
        mondayEdit = findViewById(R.id.mondayEdit);
        tuesdayEdit = findViewById(R.id.tuesdayEdit);
        wednesdayEdit = findViewById(R.id.wednesdayEdit);
        thursdayEdit = findViewById(R.id.thurdayEdit);
        fridayEdit = findViewById(R.id.fridayEdit);
        saturdayEdit = findViewById(R.id.saturdayEdit);
        sundayEdit = findViewById(R.id.sundayEdit);
        mondayRecView = findViewById(R.id.mondayRecView);
        tuesdayRecView = findViewById(R.id.tuesdayRecView);
        wednesdayRecView = findViewById(R.id.wednesdayRecView);
        thursdayRecView = findViewById(R.id.thurdayRecView);
        fridayRecView = findViewById(R.id.fridayRecView);
        saturdayRecView = findViewById(R.id.saturdayRecView);
        sundayRecView = findViewById(R.id.sundayRecView);
        noPlanRelativeLayout = findViewById(R.id.parent);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        btnAddPlan = findViewById(R.id.btnAddPlan);

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}