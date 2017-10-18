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

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.android.clustering.ClusterManager;

import com.a408group.model.*;
import com.google.maps.android.util.CalcZoom;


import org.json.JSONException;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple activity demonstrating ClusterManager.
 */
public class MapWithClusteredMarkersActivity extends TIBaseMapActivity {
    private ClusterManager<TourItem> mClusterManager;
    String Origin="";

    @Override
    protected void doMapDisplay(ArrayList<TourItem> tourItems) {
        List<LatLng> points=new ArrayList<LatLng>();
        String[] ll=Origin.split(",");

        LatLng point=new LatLng(Double.parseDouble(ll[0]),Double.parseDouble(ll[1]));
        points.add(point);
        for(TourItem item:tourItems)
        {
            point=new LatLng(item.getLat(),item.getLng());
            points.add(point);
        }
        CameraUpdate cu= CalcZoom.getZoomCameraUpdate(points);
        getMap().moveCamera(cu);


        mClusterManager = new ClusterManager<TourItem>(this, getMap());
        getMap().setOnCameraIdleListener(mClusterManager);
        mClusterManager.addItems(this.tourItems);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        String tourItemsJSON = (String) b.get("TourItems");
        this.Origin = (String) b.get("Origin");
        Gson gson = new Gson();
        this.tourItems = gson.fromJson(tourItemsJSON,
                new TypeToken<ArrayList<TourItem>>() {
                }.getType());

        String[] ll=Origin.split(",");


        TourItem tiOrigin=new TourItem();
        tiOrigin.setLocationName("Start");
        tiOrigin.setLat(Float.parseFloat(ll[0]));
        tiOrigin.setLng(Float.parseFloat(ll[1]));
        this.tourItems.add(0,tiOrigin);
    }
}