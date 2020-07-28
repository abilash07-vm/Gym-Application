package com.example.gymapplicants;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.example.gymapplicants.TrainingActivity.TRAINING_KEY;

public class PlanAdaptor extends RecyclerView.Adapter<PlanAdaptor.ViewHolder> {
    private RemovePlan removePlan;
    private ArrayList<Plans> plan = new ArrayList<>();
    private Context context;
    private String type = "";
    public PlanAdaptor(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.plan_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.txtName.setText(plan.get(position).getTraining().getName());
        holder.txtDesc.setText(plan.get(position).getTraining().getLongDesc());
        holder.txtTime.setText(String.valueOf(plan.get(position).getMinutes()));
        Glide.with(context).asBitmap().load(plan.get(position).getTraining().getImageUrl()).into(holder.cardViewImg);
        if (plan.get(position).isIsacomplished()) {
            holder.checkImg.setVisibility(View.VISIBLE);
        } else {
            holder.checkImg.setVisibility(View.GONE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TrainingActivity.class);
                intent.putExtra(TRAINING_KEY, plan.get(position).getTraining());
                context.startActivity(intent);
            }
        });
        if (type.equals("edit")) {
            holder.emptyCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Finished").setMessage("Have you Finished " + plan.get(position).getTraining().getName() + " ?");
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            for (Plans p : plan) {
                                if (p.equals(plan.get(position))) {
                                    p.setIsacomplished(true);
                                }
                            }
                            notifyDataSetChanged();
                        }
                    });
                    builder.create().show();
                }
            });
            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context).setTitle("Remove").setMessage("Are you sure to delete " + plan.get(position).getTraining().getName() + "from your plan ?");
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                removePlan = (RemovePlan) context;
                                removePlan.OnRemovePlanResult(plan.get(position));
                            } catch (ClassCastException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    builder.create().show();
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return plan.size();
    }

    public void setPlan(ArrayList<Plans> plan) {
        this.plan = plan;
    }

    public void setType(String type) {
        this.type = type;
    }

    public interface RemovePlan {
        void OnRemovePlanResult(Plans plan);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialCardView parent;
        private ImageView cardViewImg, checkImg, emptyCircle;
        private TextView txtName, txtTime, txtDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.CardView);
            cardViewImg = itemView.findViewById(R.id.CardViewTrainingImage);
            checkImg = itemView.findViewById(R.id.check);
            txtName = itemView.findViewById(R.id.CardViewTrainingName);
            txtTime = itemView.findViewById(R.id.time);
            txtDesc = itemView.findViewById(R.id.CardViewDesc);
            emptyCircle = itemView.findViewById(R.id.emptycircle);
        }
    }
}
