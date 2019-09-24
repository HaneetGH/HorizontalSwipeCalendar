

package com.haneet.horizontalswipecalendar.base;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;



public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@androidx.annotation.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**/
        setBinding();
        attachViewModel();


    }


    protected abstract void setBinding();

    protected abstract void attachViewModel();


}
