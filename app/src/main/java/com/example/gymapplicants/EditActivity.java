package com.example.gymapplicants;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanAdaptor.RemovePlan {

    private TextView editName;
    private RecyclerView recyclerView;
    private Button btnAddPlan;
    private PlanAdaptor adaptor;

    @Override
    public void OnRemovePlanResult(Plans plan) {
        if (Utils.removePlan(plan)) {
            Toast.makeText(this, "Removed Sucessfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, PlanActivity.class);
            startActivity(intent);
//            adaptor.setPlan(getPlansByDay(plan.getDay()));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        initViews();

        adaptor = new PlanAdaptor(this);
        adaptor.setType("edit");
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Intent intent = getIntent();
        if (intent != null) {
            String day = intent.getStringExtra("day");
            if (day != null) {
                editName.setText(day);

                ArrayList<Plans> plan = getPlansByDay(day);
                adaptor.setPlan(plan);
            }
            btnAddPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent addPlanIntent = new Intent(EditActivity.this, All_Training_Activity.class);
                    startActivity(addPlanIntent);
                }
            });
        }
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

    private void initViews() {
        editName = findViewById(R.id.editDay);
        recyclerView = findViewById(R.id.editrecyview);
        btnAddPlan = findViewById(R.id.btnAddPlan);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}