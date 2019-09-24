# HorizontalSwipeCalendar ![GitHub Actions status | HaneetGH/HorizontalSwipeCalendar](https://github.com/HaneetGH/HorizontalSwipeCalendar/workflows/Android%20CI/badge.svg)
NOTE:- This isn't a Library
Horizontal Swipe Calendar





## How to use
Download Code and include files from com.haneet.horizontalswipecalendar

## Screenshots

<a href="https://ibb.co/R4jscDp"><img src="https://i.ibb.co/dJmVD50/device-2019-09-24-192009.png"  width="282" height="386" alt="device-2019-09-24-192009" border="0"></a>



# Simple Usage

```xml

   <?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

        <variable
            name="finalDate"
            type="String" />

        <variable
            name="adapterDate"
            type="com.haneet.horizontalswipecalendar.adapter.AdapterDateScroll" />

        <variable
            name="adapterHour"
            type="com.haneet.horizontalswipecalendar.adapter.AdapterHourScroll" />

        <variable
            name="adapterMin"
            type="com.haneet.horizontalswipecalendar.adapter.AdapterMinScroll" />
    </data>

    <LinearLayout
        android:orientation="vertical"

        android:layout_width="match_parent"
        android:background="@color/trans"
        android:layout_height="wrap_content">

        <TextView
            android:textSize="@dimen/_14sdp"
            android:text="Return Date And Time"
            android:textColor="@color/white"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <LinearLayout

            android:background="@drawable/two_top_side_round_white"
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <LinearLayout
                android:layout_marginTop="@dimen/_80sdp"
                android:id="@+id/ll"
                android:layout_gravity="bottom"
                android:orientation="vertical"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">

                <LinearLayout
                    android:orientation="vertical"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <TextView
                        android:textStyle="bold"
                        android:background="@drawable/four_side_less_round_kinda_blue"
                        android:textColor="@color/white"
                        android:layout_gravity="center"
                        android:text="@{finalDate}"
                        android:gravity="center"
                        android:padding="@dimen/_5sdp"
                        android:layout_width="@dimen/_142sdp"
                        android:layout_height="wrap_content" />


                    <ImageView
                        android:layout_gravity="center"
                        android:src="@drawable/scroll_calendar_connector"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content" />
                </LinearLayout>

                <FrameLayout
                    android:layout_marginTop="-1dp"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <androidx.recyclerview.widget.RecyclerView
                        android:fitsSystemWindows="true"
                        android:id="@+id/dateList"
                        android:layout_width="match_parent"

                        android:layout_height="match_parent"
                        android:adapter="@{adapterDate}"
                        android:orientation="horizontal"
                        tools:listitem="@layout/calender_date_cell"
                        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />

                    <LinearLayout


                        android:layout_gravity="center"
                        android:weightSum="1"
                        android:layout_width="@dimen/_45sdp"
                        android:layout_height="@dimen/_67sdp"
                        android:orientation="horizontal">

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                        <LinearLayout
                            android:layout_weight=".9"

                            android:padding="@dimen/_1sdp"
                            android:gravity="center"
                            android:layout_gravity="center"
                            android:weightSum="3"
                            android:layout_width="match_parent"
                            android:orientation="vertical"

                            android:layout_height="match_parent">

                            <LinearLayout
                                android:id="@+id/selectedItemView"

                                android:gravity="center"
                                android:layout_gravity="center"

                                android:layout_width="match_parent"
                                android:orientation="vertical"
                                android:background="@drawable/two_top_side_trans_round_blue"
                                android:layout_height="match_parent">

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:textColor="@color/white"
                                    android:layout_weight="1"
                                    android:textSize="@dimen/_11ssp"

                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />

                                <TextView
                                    android:textStyle="bold"
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textSize="@dimen/_15ssp"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:textSize="@dimen/_11ssp"
                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />
                            </LinearLayout>
                        </LinearLayout>

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                    </LinearLayout>


                </FrameLayout>

                <FrameLayout
                    android:layout_marginTop="@dimen/_10sdp"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <androidx.recyclerview.widget.RecyclerView
                        android:id="@+id/hourlist"
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:orientation="horizontal"
                        android:adapter="@{adapterHour}"
                        tools:listitem="@layout/calender_hr_cell"
                        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />


                    <LinearLayout


                        android:layout_gravity="center"
                        android:weightSum="1"
                        android:layout_width="@dimen/_45sdp"
                        android:layout_height="match_parent"
                        android:orientation="horizontal">

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                        <LinearLayout
                            android:layout_weight=".9"

                            android:padding="@dimen/_1sdp"
                            android:gravity="center"
                            android:layout_gravity="center"
                            android:weightSum="3"
                            android:layout_width="match_parent"
                            android:orientation="vertical"

                            android:layout_height="match_parent">

                            <LinearLayout
                                android:id="@+id/selectedItemViewh"

                                android:gravity="center"
                                android:layout_gravity="center"

                                android:layout_width="match_parent"
                                android:orientation="vertical"
                                android:background="@drawable/two_top_side_trans_round_blue"
                                android:layout_height="match_parent">

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:textColor="@color/white"
                                    android:layout_weight="1"
                                    android:textSize="@dimen/_11ssp"

                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />

                                <TextView
                                    android:textStyle="bold"
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textSize="@dimen/_15ssp"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:layout_width="wrap_content"
                                    android:layout_height="16dp" />

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:textSize="@dimen/_11ssp"
                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />
                            </LinearLayout>
                        </LinearLayout>

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                    </LinearLayout>


                </FrameLayout>

                <FrameLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <androidx.recyclerview.widget.RecyclerView
                        android:id="@+id/minList"
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:orientation="horizontal"
                        android:adapter="@{adapterMin}"
                        tools:listitem="@layout/calender_mnt_cell"
                        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager" />

                    <LinearLayout


                        android:layout_gravity="center"
                        android:weightSum="1"
                        android:layout_width="@dimen/_45sdp"
                        android:layout_height="@dimen/_47sdp"
                        android:orientation="horizontal">

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                        <LinearLayout
                            android:layout_weight=".9"

                            android:padding="@dimen/_1sdp"
                            android:gravity="center"
                            android:layout_gravity="center"
                            android:weightSum="3"
                            android:layout_width="match_parent"
                            android:orientation="vertical"

                            android:layout_height="match_parent">

                            <LinearLayout
                                android:id="@+id/selectedItemViewmin"

                                android:gravity="center"
                                android:layout_gravity="center"

                                android:layout_width="match_parent"
                                android:orientation="vertical"
                                android:background="@drawable/two_bottom_side_trans_round_blue"
                                android:layout_height="match_parent">

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:textColor="@color/white"
                                    android:layout_weight="1"
                                    android:textSize="@dimen/_11ssp"

                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />

                                <TextView
                                    android:textStyle="bold"
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textSize="@dimen/_15ssp"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:layout_width="wrap_content"
                                    android:layout_height="15dp" />

                                <TextView
                                    android:gravity="center"
                                    android:layout_gravity="center"
                                    android:textStyle="bold"
                                    android:layout_weight="1"
                                    android:textColor="@color/white"

                                    android:textSize="@dimen/_11ssp"
                                    android:layout_width="wrap_content"
                                    android:layout_height="0dp" />
                            </LinearLayout>
                        </LinearLayout>

                        <TextView
                            android:layout_weight=".05"
                            android:background="@color/grey"
                            android:layout_width="0dp"
                            android:layout_height="match_parent" />

                    </LinearLayout>

                </FrameLayout>
            </LinearLayout>

            <TextView
                android:layout_marginRight="@dimen/_15sdp"
                android:layout_marginTop="@dimen/_10sdp"
                android:layout_gravity="right"
                android:textSize="@dimen/_16ssp"
                android:textColor="@color/blue_light"
                android:text="@string/continue_text"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
        </LinearLayout>


    </LinearLayout>
</layout>
```
```Java

	  int CAL_TILL=1;// This number will add in year which tells system to fetch cal till that date

//Here we have Three Methods
dateFillModel();
hourFillModel(selectedDate, selectedHour);
minFillModel(selectedMin);
```

These will populate the Dates

TODO
Optimize.
Good Readme
Simple Code
work as libs 
###PS if you have any idea, image, template please open new issue and give me the image , and i well try to add it to the Library.
## Permission
git update-index --chmod=+x gradlew
## License
Open
