package com.haneet.horizontalswipecalendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import com.haneet.horizontalswipecalendar.adapter.AdapterDateScroll;
import com.haneet.horizontalswipecalendar.adapter.AdapterHourScroll;
import com.haneet.horizontalswipecalendar.adapter.AdapterMinScroll;
import com.haneet.horizontalswipecalendar.base.BaseActivity;
import com.haneet.horizontalswipecalendar.databinding.ActivityMainBinding;
import com.haneet.horizontalswipecalendar.model.calendar.DateModel;
import com.haneet.horizontalswipecalendar.model.calendar.HourModel;
import com.haneet.horizontalswipecalendar.model.calendar.MinModel;
import com.haneet.horizontalswipecalendar.utils.Utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.haneet.horizontalswipecalendar.utils.Utilities.buildCustomCalender;
import static com.haneet.horizontalswipecalendar.utils.Utilities.buildCustomHourCalender;
import static com.haneet.horizontalswipecalendar.utils.Utilities.buildCustomMinCalender;
import static com.haneet.horizontalswipecalendar.utils.Utilities.getCurrentDate;

public class MainActivity extends BaseActivity implements RecyclerViewClickListener {
    ActivityMainBinding binding;
    final Handler handler = new Handler();
    String selectedDate;
    int selectedHour;
    int selectedMin;
    int tempYear;
    int futureDayCount = 0;
    int futureHourCount = 0;
    final Calendar calCurrent = Calendar.getInstance();
    AdapterMinScroll adapterMinScroll;
    AdapterHourScroll adapterHourScroll;
    AdapterDateScroll adapterDateScroll;
int CAL_TILL=1;// This number will add in year which tells system to fetch cal till that date
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        dateFillModel();

        binding.setFinalDate(Utilities.getFinalDate(adapterDateScroll.getSelectedDate(), adapterHourScroll.getSelectedHour(), Integer.parseInt(adapterMinScroll.getSelectedMin())));
    }

    @Override
    protected void attachViewModel() {

    }

    private void minFillModel(int selectedPassMIn) {

      /*  Calendar cal = Calendar.getInstance();

        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM-hh-mm");
        Date date = null;
        try {
            date = format.parse(selectedPassD + "-" + passHour + "-" + selectedPassMIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(date);*/
        List<MinModel> dateList = buildCustomMinCalender(selectedPassMIn);
        adapterMinScroll = new AdapterMinScroll(dateList, this, MainActivity.this);
        SnapHelper snapHelper = new LinearSnapHelper();
        binding.minList.setOnFlingListener(null);
        snapHelper.attachToRecyclerView(binding.minList);
        binding.setAdapterMin(adapterMinScroll);
        adapterMinScroll.setSelecteditem(3);
        binding.selectedItemViewmin.setVisibility(View.GONE);
        binding.minList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                final LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                //layoutManager.setSmoothScrollbarEnabled(true);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:


                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                binding.selectedItemViewmin.setVisibility(View.GONE);
                                adapterMinScroll.setUnSelecteditem(adapterMinScroll.getlastSelectedItem());
                                adapterMinScroll.setSelecteditem(layoutManager.findFirstCompletelyVisibleItemPosition() + 3);
                                selectedMin = Integer.parseInt(adapterMinScroll.getSelectedMin());
                                binding.setFinalDate(Utilities.getFinalDate(adapterDateScroll.getSelectedDate(), adapterHourScroll.getSelectedHour(), Integer.parseInt(adapterMinScroll.getSelectedMin())));


                            }
                        }, 700);
                        System.out.println("The RecyclerView is not scrolling");
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        // binding.selectedItemView.setVisibility(View.GONE);
                        // adapterMinScroll.setSelecteditem(-1);
                        adapterMinScroll.setUnSelecteditem(adapterMinScroll.getlastSelectedItem());
                        binding.selectedItemViewmin.setVisibility(View.VISIBLE);
                        System.out.println("Scrolling now");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        System.out.println("Scroll Settling");
                        break;

                }


            }
        });

    }

    private void hourFillModel(String selectedPassDate, int selectedPassHour) {
        Calendar cal = Calendar.getInstance();
        final Calendar calC = Calendar.getInstance();


        cal.setTime(getHourBasedDate(selectedPassDate, selectedPassHour));
        List<HourModel> dateList = buildCustomHourCalender(cal.get(Calendar.HOUR_OF_DAY));
        adapterHourScroll = new AdapterHourScroll(dateList, this, MainActivity.this);

        SnapHelper snapHelper = new LinearSnapHelper();
        binding.hourlist.setOnFlingListener(null);
        snapHelper.attachToRecyclerView(binding.hourlist);
        binding.setAdapterHour(adapterHourScroll);
        adapterHourScroll.setSelecteditem(3);
        binding.selectedItemViewh.setVisibility(View.GONE);
        binding.hourlist.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                final LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                layoutManager.setSmoothScrollbarEnabled(true);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                binding.selectedItemViewh.setVisibility(View.GONE);


                                adapterHourScroll.setUnSelecteditem(adapterHourScroll.getlastSelectedItem());
                                adapterHourScroll.setSelecteditem(layoutManager.findFirstCompletelyVisibleItemPosition() + 3);
                                selectedHour = adapterHourScroll.getSelectedHour();

                                if (Utilities.isDateIsInFuture(selectedDate) || selectedHour > calC.get(Calendar.HOUR)) {
                                    selectedMin = 0;
                                    futureHourCount++;

                                } else {
                                    futureHourCount = 0;
                                    selectedMin = calC.get(Calendar.MINUTE);

                                }
                                // selectedHour = adapterHourScroll.getSelectedHour();
                                if (futureHourCount < 2) {
                                    minFillModel(selectedMin);
                                } else
                                    binding.setFinalDate(Utilities.getFinalDate(adapterDateScroll.getSelectedDate(), adapterHourScroll.getSelectedHour(), Integer.parseInt(adapterMinScroll.getSelectedMin())));

                            }
                        }, 800);

                        System.out.println("The RecyclerView is not scrolling");
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        // binding.selectedItemView.setVisibility(View.GONE);
                        adapterHourScroll.setUnSelecteditem(adapterHourScroll.getlastSelectedItem());
                        binding.selectedItemViewh.setVisibility(View.VISIBLE);
                        System.out.println("Scrolling now");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        System.out.println("Scroll Settling");
                        break;

                }

                //      adapterDateScroll.setSelecteditem(layoutManager.findFirstCompletelyVisibleItemPosition() + 3);
            }
        });
        minFillModel(selectedMin);

    }

    private Date getHourBasedDate(String selectedPassDate, int selectedPassHour) {

        SimpleDateFormat format = new SimpleDateFormat("EEE-dd-MMM-yyyy-hh");
        Date date = null;
        try {
            date = format.parse(selectedPassDate + "-" + selectedPassHour);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    private void dateFillModel() {
        tempYear = Calendar.getInstance().get(Calendar.YEAR) + CAL_TILL;

        Calendar calEnd = Calendar.getInstance();
        calEnd.set(Calendar.MONTH, 11);
        calEnd.set(Calendar.DATE, 32);
        calEnd.set(Calendar.YEAR, tempYear);
        getDefaultValues(calCurrent);
        Log.d("DATE", selectedDate);
        List<DateModel> dateList = buildCustomCalender(calCurrent.getTime(), calEnd.getTime());
        adapterDateScroll = new AdapterDateScroll(dateList, MainActivity.this, this);
        SnapHelper snapHelper = new LinearSnapHelper();
        binding.dateList.setOnFlingListener(null);
        snapHelper.attachToRecyclerView(binding.dateList);

        binding.setAdapterDate(adapterDateScroll);
        adapterDateScroll.setSelecteditem(3);
        binding.selectedItemView.setVisibility(View.GONE);
        binding.dateList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);


                final LinearLayoutManager layoutManager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                layoutManager.setSmoothScrollbarEnabled(true);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                binding.selectedItemView.setVisibility(View.GONE);
                                adapterDateScroll.setUnSelecteditem(adapterDateScroll.getlastSelectedItem());
                                adapterDateScroll.setSelecteditem(layoutManager.findFirstCompletelyVisibleItemPosition() + 3);
                                System.out.println(adapterDateScroll.getSelectedDate());
                                selectedDate = adapterDateScroll.getSelectedDate();
                                if (Utilities.isDateIsInFuture(selectedDate)) {
                                    futureDayCount++;
                                    selectedHour = 0;

                                } else {
                                    futureDayCount = 0;
                                    selectedHour = calCurrent.get(Calendar.HOUR_OF_DAY);

                                }

                                if (futureDayCount < 2) {
                                    hourFillModel(selectedDate, selectedHour);
                                } else
                                    binding.setFinalDate(Utilities.getFinalDate(adapterDateScroll.getSelectedDate(), adapterHourScroll.getSelectedHour(), Integer.parseInt(adapterMinScroll.getSelectedMin())));


                            }
                        }, 800);


                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        // binding.selectedItemView.setVisibility(View.GONE);

                        binding.selectedItemView.setVisibility(View.VISIBLE);

                        //adapterDateScroll.setSelecteditem(-1);
                        adapterDateScroll.setUnSelecteditem(adapterDateScroll.getlastSelectedItem());
                        System.out.println("Scrolling now");
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        System.out.println("Scroll Settling");
                        break;

                }
                //      adapterDateScroll.setSelecteditem(layoutManager.findFirstCompletelyVisibleItemPosition() + 3);
            }
        });


        hourFillModel(selectedDate, selectedHour);


    }

    private void getDefaultValues(Calendar cal2) {
        selectedDate = getCurrentDate();
        selectedHour = cal2.get(Calendar.HOUR_OF_DAY);
        selectedMin = cal2.get(Calendar.MINUTE);
    }

    @Override
    public void onClick(View v, int position) {

    }

    @Override
    public void onLongClick(View v, int position) {

    }
}
