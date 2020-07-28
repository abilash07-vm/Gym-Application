package com.example.gymapplicants;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import static com.example.gymapplicants.TrainingActivity.TRAINING_KEY;

public class planDetailDialog extends DialogFragment {
    private Button btnDismiss, btnAdd;
    private TextView trainingName;
    private EditText minutes;
    private Spinner daySpinner;
    private passPlanInterface passPlanInterface;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan, null);
        init(view);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(view).setTitle("Enter Details");
        Bundle bundle = getArguments();
        if (bundle != null) {
            final Training training = bundle.getParcelable(TRAINING_KEY);
            if (training != null) {
                trainingName.setText(training.getName());
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day = daySpinner.getSelectedItem().toString();
                        int min = Integer.valueOf(minutes.getText().toString());
                        Plans plans = new Plans(training, min, day, false);
                        try {
                            passPlanInterface = (passPlanInterface) getActivity();
                            passPlanInterface.getPlan(plans);
                            dismiss();
                        } catch (ClassCastException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        return builder.create();
    }

    private void init(View view) {
        btnAdd = view.findViewById(R.id.btnAdd);
        btnDismiss = view.findViewById(R.id.btnDismiss);
        trainingName = view.findViewById(R.id.trainingName);
        minutes = view.findViewById(R.id.txtMin);
        daySpinner = view.findViewById(R.id.daySpinner);
    }

    public interface passPlanInterface {
        void getPlan(Plans plans);
    }
}
