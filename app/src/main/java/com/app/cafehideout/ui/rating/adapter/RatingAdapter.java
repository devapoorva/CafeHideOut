package com.app.cafehideout.ui.rating.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.cafehideout.R;
import com.app.cafehideout.ui.rating.communication.RatingComm;
import com.app.cafehideout.ui.rating.model.RatingModel;

import java.util.List;

/**
 * Created by Apoorv Vardhman on 03-02-2020
 *
 * @Email :  apoorv.vardhman@gmail.com
 * @Author :  Apoorv Vardhman (developerapoorv.xyz)
 * @Linkedin :  https://in.linkedin.com/in/apoorv-vardhman
 * Contact :  +91 8434014444
 */
public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {

    private List<RatingModel> tableModelList;
    private Context context;
    private RatingComm ratingComm;

    public RatingAdapter(List<RatingModel> tableModelList, Context context,RatingComm ratingComm) {
        this.tableModelList = tableModelList;
        this.context = context;
        this.ratingComm = ratingComm;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_rating,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(tableModelList.get(position).getParameterName());
        holder.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingComm.rating(tableModelList.get(position),rating);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_rating_name);
            ratingBar = itemView.findViewById(R.id.rb_feedback);
        }
    }

}
