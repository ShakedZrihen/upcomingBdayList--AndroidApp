package com.shenkar.shakedzrihen.upcomingbdaylist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

class BirthdayListAdapter extends RecyclerView.Adapter<BirthdayListAdapter.ViewHolder> {

    private ArrayList<BirthdayListItem> birthday;

    public BirthdayListAdapter(ArrayList<BirthdayListItem> birthday) {
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
        holder.fullName.setText(birthday.get(position).getFullName());

        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat simpleDataFormat = new SimpleDateFormat(myFormat);
        holder.birthday.setText(simpleDataFormat.format(
                birthday.get(position).getBirthday().getTime()
        ));

        holder.comment.setText(birthday.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return birthday.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView fullName;
        public TextView birthday;
        public TextView comment;

        public ViewHolder(View itemView) {
            super(itemView);
            fullName = itemView.findViewById(R.id.fullName);
            birthday = itemView.findViewById(R.id.bday);
            comment = itemView.findViewById(R.id.description);
        }
    }
}
