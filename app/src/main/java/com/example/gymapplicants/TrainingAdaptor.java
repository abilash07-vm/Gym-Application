package com.example.gymapplicants;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.example.gymapplicants.TrainingActivity.TRAINING_KEY;

public class TrainingAdaptor extends RecyclerView.Adapter<TrainingAdaptor.Viewholder> {
    private static final String TAG = "TrainingAdaptor";
    private Context context;
    private ArrayList<Training> trainings = new ArrayList<>();

    public TrainingAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_item, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: Started");
        holder.ActivityName.setText(trainings.get(position).getName());
        holder.shortDesc.setText(trainings.get(position).getShortDesc());
        Glide.with(context).asBitmap().load(trainings.get(position).getImageUrl()).into(holder.img);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, trainings.get(position).getName() + " is clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, TrainingActivity.class);
                intent.putExtra(TRAINING_KEY, trainings.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public void setTrainings(ArrayList<Training> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private MaterialCardView parent;
        private ImageView img;
        private TextView ActivityName, shortDesc;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            img = itemView.findViewById(R.id.img);
            ActivityName = itemView.findViewById(R.id.txt);
            shortDesc = itemView.findViewById(R.id.desc);
        }
    }
}
