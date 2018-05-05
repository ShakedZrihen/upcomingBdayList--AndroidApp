package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

class BirthdayListAdapter extends RecyclerView.Adapter<BirthdayListAdapter.ViewHolder> {

    private ArrayList<String> birthday;

    public BirthdayListAdapter(ArrayList<String> birthday) {
        this.birthday = birthday;
    }

    @Override
    public BirthdayListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.birthday_row,
                parent,
                false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BirthdayListAdapter.ViewHolder holder, int position) {
        holder.fullName.setText(birthday.get(position));
    }

    @Override
    public int getItemCount() {
        return birthday.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fullName;
        public ViewHolder(View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullName);
        }
    }
}
