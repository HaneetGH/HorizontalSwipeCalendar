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
import com.haneet.horizontalswipecalendar.databinding.CalenderDateCellBinding;
import com.haneet.horizontalswipecalendar.model.calendar.DateModel;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdapterDateScroll extends RecyclerView.Adapter<AdapterDateScroll.MyViewHolder> {

    private List<DateModel> list;
    private RecyclerViewClickListener listener;
    private Activity context;

    private static final int VIEW_TYPE_PADDING = 1;
    private static final int VIEW_TYPE_ITEM = 2;
    private int paddingWidthDate = 0;

    private int selectedItem = -1;

    public AdapterDateScroll(List<DateModel> list, Activity activity, RecyclerViewClickListener listener) {
        this.list = list;
        this.listener = listener;
        this.context = activity;

    }


    @NonNull
    @Override
    public AdapterDateScroll.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CalenderDateCellBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.calender_date_cell, parent, false);
        return new AdapterDateScroll.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDateScroll.MyViewHolder holder, int position) {
        if (selectedItem != -1 && selectedItem == position) {
            list.get(position).setSetSelected(true);
        } else list.get(position).setSetSelected(false);

        if (position % 2 == 0) {
            holder.binding.setIfEven(true);
        } else holder.binding.setIfEven(false);
        holder.binding.setModel(list.get(position));
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
        private CalenderDateCellBinding binding;

        public MyViewHolder(@NonNull CalenderDateCellBinding binding) {
            super(binding.getRoot());
            this.binding = binding;


        }
    }

    public void setSelecteditem(int selecteditem) {
        Log.d("POSITION", String.valueOf(selecteditem));
        this.selectedItem = selecteditem;
        notifyItemChanged(selectedItem);
    }

    public void setUnSelecteditem(int selecteditem) {
        Log.d("POSITION", String.valueOf(selecteditem));
        list.get(selectedItem).setSetSelected(false);
        notifyItemChanged(selectedItem);
    }

    public int getlastSelectedItem() {
        return selectedItem;
    }


    public String getSelectedDate() {
        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM");
   /*     Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Integer.parseInt(list.get(selectedItem).getDay()));
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(list.get(selectedItem).getDayNum()));
        Date date = null;
        try {
            date = format.parse(list.get(selectedItem).getDay() + "-" + list.get(selectedItem).getDayNum() + "-" + list.get(selectedItem).getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        calendar.setTime(date)*/;

        return list.get(selectedItem).getDay() + "-" + list.get(selectedItem).getDayNum() + "-" + list.get(selectedItem).getDate()+"-"+list.get(selectedItem).getYear();
    }

    public int getCurrentYear()

    {
       return  list.get(selectedItem).getYear();
    }
}
