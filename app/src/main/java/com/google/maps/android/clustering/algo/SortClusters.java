package com.google.maps.android.clustering.algo;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.Cluster;

import java.util.Comparator;

public class SortClusters implements Comparator<Cluster> {
    LatLng currentLoc;

    public SortClusters(LatLng current){
        currentLoc = current;
    }
    @Override
    public int compare(final Cluster cluster1, final Cluster cluster2) {
        double lat1 = cluster1.getPosition().latitude;
        double lon1 = cluster1.getPosition().longitude;
        double lat2 = cluster2.getPosition().latitude;
        double lon2 = cluster2.getPosition().longitude;

        double distanceToPlace1 = distance(currentLoc.latitude, currentLoc.longitude, lat1, lon1);
        double distanceToPlace2 = distance(currentLoc.latitude, currentLoc.longitude, lat2, lon2);
        return (int) (distanceToPlace1 - distanceToPlace2);
    }

    public double distance(double fromLat, double fromLon, double toLat, double toLon) {
        double radius = 6378137;   // approximate Earth radius, *in meters*
        double deltaLat = toLat - fromLat;
        double deltaLon = toLon - fromLon;
        double angle = 2 * Math.asin( Math.sqrt(
                Math.pow(Math.sin(deltaLat/2), 2) +
                        Math.cos(fromLat) * Math.cos(toLat) *
                                Math.pow(Math.sin(deltaLon/2), 2) ) );
        return radius * angle;
    }
}