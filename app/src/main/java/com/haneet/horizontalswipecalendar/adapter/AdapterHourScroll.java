package com.haneet.horizontalswipecalendar.adapter;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.haneet.horizontalswipecalendar.R;
import com.haneet.horizontalswipecalendar.RecyclerViewClickListener;
import com.haneet.horizontalswipecalendar.databinding.CalenderHrCellBinding;
import com.haneet.horizontalswipecalendar.model.calendar.HourModel;

import java.util.List;

public class AdapterHourScroll extends RecyclerView.Adapter<AdapterHourScroll.MyViewHolder> {

    private List<HourModel> list;
    private RecyclerViewClickListener listener;
    private Activity context;
    private int selectedItem = -1;

    public AdapterHourScroll(List<HourModel> list, RecyclerViewClickListener listener, Activity activity) {
        this.list = list;
        this.listener = listener;
        this.context = activity;
    }


    @NonNull
    @Override
    public AdapterHourScroll.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CalenderHrCellBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.calender_hr_cell, parent, false);
        return new AdapterHourScroll.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHourScroll.MyViewHolder holder, int position) {
        holder.binding.setModel(list.get(position));
        if (selectedItem != -1 && selectedItem == position) {
            list.get(position).setSetSelected(true);
        } else list.get(position).setSetSelected(false);

        if (position % 2 == 0) {
            holder.binding.setIfEven(true);
        } else holder.binding.setIfEven(false);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        holder.binding.layout.setLayoutParams(new LinearLayout.LayoutParams((width / 7), ViewGroup.LayoutParams.WRAP_CONTENT));
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CalenderHrCellBinding binding;

        public MyViewHolder(@NonNull CalenderHrCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

    public void setSelecteditem(int selecteditem) {
        Log.d("POSITION", String.valueOf(selecteditem));
        this.selectedItem = selecteditem;
        notifyItemChanged(selecteditem);
    }

    public void setUnSelecteditem(int selecteditem) {
        Log.d("POSITION", String.valueOf(selecteditem));

        notifyItemChanged(selecteditem);
    }

    public int getlastSelectedItem() {
        return selectedItem;
    }

    public int getSelectedHour() {
        if (selectedItem < list.size())
            return Integer.parseInt(list.get(selectedItem).getHour());
        else return 0;
    }
}
