package com.example.gymapplicants;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class All_Training_Activity extends AppCompatActivity {
    private static final String TAG = "All_Training_Activity Started";
    private RecyclerView recyclerView;
    private TrainingAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__training_);

        recyclerView = findViewById(R.id.recyview);
        adaptor = new TrainingAdaptor(this);
        recyclerView.setAdapter(adaptor);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<Training> allTrainings = Utils.getTrainings();
        if (allTrainings != null) {
            adaptor.setTrainings(allTrainings);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

        startActivity(intent);
    }
}