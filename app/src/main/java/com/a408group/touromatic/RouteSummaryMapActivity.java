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

import com.a408group.model.GoogleRouteLegWrapper;
import com.a408group.model.TourItem;
import com.a408group.model.TourItems;
import com.a408group.model.TourRoute;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.maps.android.PolyUtil;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;
import java.util.List;

import com.google.maps.android.util.CalcZoom;
import com.a408group.model.routing.*;

/**
 * Simple activity demonstrating ClusterManager.
 */
public class RouteSummaryMapActivity extends PolyBaseMapActivity {
    private ClusterManager<TourItem> mClusterManager;
    String points = null;
    private static String LINE = "";

    @Override
    protected void doMapDisplay(String points, ArrayList<TourItem> items) {

        List<LatLng> decodedPath = PolyUtil.decode(LINE);
        CameraUpdate cu = CalcZoom.getZoomCameraUpdate(decodedPath);
        mMap.moveCamera(cu);
        mMap.addPolyline(new PolylineOptions().addAll(decodedPath));
        for (TourItem item : items) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(item.getLat(), item.getLng())).title(item.getLocationName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        }

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        LINE = (String) b.get("PolylineOverview");
        String tourItemsJSON = (String) b.get("TourRoute");
        Gson gson = new Gson();
        TourRoute route = gson.fromJson(tourItemsJSON, TourRoute.class);
        ArrayList<GoogleRouteLegWrapper> legs = route.getLegs();
        items = new ArrayList<TourItem>();
        for (GoogleRouteLegWrapper leg : legs) {
            TourItem item = leg.getTourItem();
            items.add(item);
        }
        points = LINE;


    }
}