/*
 *  Created by Surajit Deka on 25/6/19 12:38 PM
 *  Copyright (c) Letstrack 2019 . All rights reserved.
 *  Last modified 13/6/19 11:45 AM
 *
 */

package com.haneet.horizontalswipecalendar;

import android.view.View;

public interface RecyclerViewClickListener {

    void onClick(View v, int position);

    void onLongClick(View v, int position);


}
