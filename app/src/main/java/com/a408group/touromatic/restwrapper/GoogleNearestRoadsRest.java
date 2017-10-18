package com.a408group.touromatic.restwrapper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import com.a408group.retrofit.GoogleNearestRoadsAPIClient;
import com.a408group.retrofit.GoogleNearestRoadsAPIInterface;
import com.a408group.model.TourItem;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;
import com.a408group.model.nearestroads.NearestRoads;
import com.a408group.model.nearestroads.*;
import com.google.maps.android.clustering.algo.GridBasedAlgorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.algo.SortClusters;
import com.google.maps.android.clustering.algo.StaticCluster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Collection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleNearestRoadsRest {

    TextView responseText;
    static GoogleNearestRoadsAPIInterface apiInterface;
    static Context activity;
    static ArrayList<TourItem> tourItems;
    static String origin;
    static String mode;

    public static void init(Context activity) {
        apiInterface = GoogleNearestRoadsAPIClient.getClient().create(GoogleNearestRoadsAPIInterface.class);
        GoogleNearestRoadsRest.activity = activity;
    }

    public static  String getOrigin(List<SnappedPoint> snappedPoints)
    {


        String latPart=snappedPoints.get(0).getLocation().getLatitude().toString();
        String lngPart=snappedPoints.get(0).getLocation().getLongitude().toString();
        String placeOrigin=  latPart + "," + lngPart;
        return placeOrigin;

    }
    public static  String getDestination(List<SnappedPoint> snappedPoints) {
        String latPart = snappedPoints.get(snappedPoints.size() - 1).getLocation().getLatitude().toString();
        String lngPart = snappedPoints.get(snappedPoints.size() - 1).getLocation().getLongitude().toString();
        String destination = latPart + "," + lngPart;
        return destination;
    }
    public static String buildWaypoints(List<SnappedPoint> snappedPoints)
    {
        String waypoints="optimize:true";
        for(int i=1;i<snappedPoints.size()-1;i++)      {

            String latPart=snappedPoints.get(i).getLocation().getLatitude().toString();
            String lngPart=snappedPoints.get(i).getLocation().getLongitude().toString();
            String waypoint=  latPart + "," + lngPart;
            //       String waypoint= "place_id:" + snappedPoints.get(i).getPlaceId();

            waypoints=waypoints+"|";
            waypoints=waypoints+waypoint;
        }
        return waypoints;
    }
    public static String buildWaypoints(ArrayList<TourItem> items) {
        String waypoints="optimize:true";

        for (TourItem item : items) {

            String latPart = item.getLat().toString();
            String lngPart = item.getLng().toString();
            String waypoint = latPart + "," + lngPart;
            //       String waypoint= "place_id:" + snappedPoints.get(i).getPlaceId();
            //   if (waypoints.length() > 0)
            waypoints = waypoints + "|";
            waypoints = waypoints + waypoint;
        }
        return waypoints;

    }
    public static String buildWaypoints(ArrayList<TourItem> tourItemArryList,List<SnappedPoint> snappedPoints)
    {


        GridBasedAlgorithm gba=new GridBasedAlgorithm();
        gba.addItems(tourItems);
        Set<Cluster> clusters= gba.getClusters(12.00);


        String pt[]=origin.split(",");
        LatLng latLng=new LatLng(Double.parseDouble(pt[0]),Double.parseDouble(pt[1]));

        //sort the list, give the Comparator the current location
        ArrayList<Cluster> listClusters=new ArrayList<Cluster>(clusters);
        Collections.sort(listClusters, new SortClusters(latLng));


      //  String waypoints="optimize:true|";
        String waypoints="";
        for (Cluster cluster:listClusters) {
            String cName=cluster.getClass().getName();
            if(cluster.getClass().getName().contains("StaticCluster"))
            {
                ArrayList<TourItem> items = (ArrayList<TourItem>) cluster.getItems();

                for (TourItem item : items) {

                    String latPart = item.getLat().toString();
                    String lngPart = item.getLng().toString();
                    String waypoint = latPart + "," + lngPart;
                    //       String waypoint= "place_id:" + snappedPoints.get(i).getPlaceId();
                    if (waypoints.length() > 0)
                        waypoints = waypoints + "|";
                    waypoints = waypoints + waypoint;
                }
            }
            else
            {
                int x=1;
            }


        }
        return  waypoints;
    }
    public static void doGoogleNearestRoads(String origin, String mode, final ArrayList<TourItem> tourItems) {

        GoogleNearestRoadsRest.tourItems=tourItems;
        // category=Museums+and+Cultural+Institutions
        //  https://maps.googleapis.com/maps/api/directions/json?
        // origin=Boston,MA
        // &destination=Concord,MA
        // &waypoints=Charlestown,MA|Lexington,MA
        // &key=AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM
        // 1st 10 in tourItems for now
        int lastIndex=21;
        GoogleNearestRoadsRest.mode=mode;
        GoogleNearestRoadsRest.origin=origin;
        String waypoints=origin;

        for(int i=0;i<Math.min(tourItems.size(),lastIndex);i++)
        {

            String waypointLatLng=tourItems.get(i).getLat() + "," + tourItems.get(i).getLng();

            waypoints=waypoints+"|";
            waypoints=waypoints+waypointLatLng;

        }

        Call<NearestRoads> googleNearestRestCall = apiInterface.doGoogleNearestRoads(
                 waypoints,
                "AIzaSyA8Gu7lWWELKW1ZMGkPDIWEXAbFpYVe2Nk");


        googleNearestRestCall.enqueue(new Callback<NearestRoads>() {
            @Override
            public void onResponse(Call<NearestRoads> call, Response<NearestRoads> response) {
                NearestRoads nearestRoads = response.body();
                List<SnappedPoint> snappedPoints = nearestRoads.getSnappedPoints();
                String snappedOrigin=GoogleNearestRoadsRest.getOrigin(snappedPoints);
                String destination=GoogleNearestRoadsRest.getDestination(snappedPoints);
/*
                for (int i = 1; i< snappedPoints.size() -1; i++)
                {
                    SnappedPoint point=snappedPoints.get(i);
                    int originalIndex=snappedPoints.get(i).getOriginalIndex();
                    tourItems.get(originalIndex).setLat(point.getLocation().getLatitude().floatValue());
                    tourItems.get(originalIndex).setLng(point.getLocation().getLongitude().floatValue());
                }
                */
           //     String waypoints=GoogleNearestRoadsRest.buildWaypoints(tourItems,snappedPoints);
                String waypoints=GoogleNearestRoadsRest.buildWaypoints(tourItems);

                GoogleRoutingRest.init(activity);
                GoogleRoutingRest.doGoogleRoute(snappedOrigin,destination,GoogleNearestRoadsRest.mode,GoogleNearestRoadsRest.tourItems,waypoints);


            }

            @Override
            public void onFailure(Call<NearestRoads> call, Throwable t) {

            }
            public void openWebPage(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(intent);
                }
            }
        });



/*
        tourItemsRestCall.enqueue(new Callback<TourItems>() {

            @Override
          public void onResponse(Call<TourItems> call, Response<TourItems> response) {

                TourItems tourItems = response.body();


                String text=tourItems.getTourItem().toString();

                Intent i = new Intent(SearchRest.activity, SearchResultListActivity.class);
                SearchRest.activity.startActivity(i);
                DispatchEvent de=new DispatchEvent();
                de.dispatchName="DispatchObject";
                de.dispatchObject=tourItems;
                EventBus.getDefault().post(de);


            }

            @Override
            public void onFailure(Call<TourItems> call, Throwable t) {
                call.cancel();
            }
        });

*/
    }


}
