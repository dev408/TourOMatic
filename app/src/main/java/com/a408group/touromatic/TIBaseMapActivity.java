/*
 * Copyright 2013 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.a408group.touromatic;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.a408group.model.TourItem;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.MapStyleOptions;

import java.util.ArrayList;

public abstract class TIBaseMapActivity extends BaseMapActivity implements OnMapReadyCallback {

    protected ArrayList<TourItem> tourItems=null;

    public void setData(ArrayList<TourItem> tourItems) {

        this.tourItems=tourItems;
    }
    /**
     * Run the demo-specific code.
     */
    protected abstract void doMapDisplay(ArrayList<TourItem> tourItems);

    @Override
    public void onMapReady(GoogleMap map) {
        if (mMap != null) {
            return;
        }
        mMap = map;
        UiSettings settings=map.getUiSettings();
        settings.setMyLocationButtonEnabled(true);
        settings.setZoomControlsEnabled(true);
        settings.setZoomGesturesEnabled(true);
        doMapDisplay(tourItems);
    }
}
