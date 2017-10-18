package com.a408group.touromatic.restwrapper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.TextView;

import com.a408group.model.MapquestRouteLegWrapper;
import com.a408group.model.RouteLegWrapperInterface;
import com.a408group.model.TourRoute;
import com.a408group.model.mapquest.optimizedroute.Leg;
import com.a408group.retrofit.MapquestRoutingAPIClient;
import com.a408group.retrofit.MapquestRoutingAPIInterface;
import com.a408group.model.TourItem;
import com.a408group.touromatic.RouteLegsListActivity;
import com.google.gson.Gson;
import com.a408group.model.mapquest.optimizedroute.Route;
import com.a408group.model.mapquest.optimizedroute.*;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapquestRoutingRest {

    TextView responseText;
    static MapquestRoutingAPIInterface apiInterface;
    static Context activity;
    static ArrayList<TourItem> tourItems;
    static String origin;
    static String mode;

    public static void init(Context activity) {
        apiInterface = MapquestRoutingAPIClient.getClient().create(MapquestRoutingAPIInterface.class);
        MapquestRoutingRest.activity = activity;
    }





    public static void doMapquestRouting(String origin, String mode, final ArrayList<TourItem> tourItems) {

        MapquestRoutingRest.tourItems=tourItems;
        final String placeOrigin=origin;
        int lastIndex=22;
        MapquestRoutingRest.mode=mode;
        MapquestRoutingRest.origin=origin;
        String waypoints="{\"locations\": [ " + "\"" + origin + "\"" + ",";
        float lastLat=0,lastLng=0;

        for(int i=0;i<Math.min(tourItems.size(),lastIndex);i++)
        {

            String waypointLatLng="\"" + tourItems.get(i).getLat() + "," + tourItems.get(i).getLng() + "\"" + ", ";
            waypoints=waypoints+waypointLatLng;


        }
        int lastComma=waypoints.lastIndexOf(",");
        waypoints=waypoints.substring(0, lastComma) + "] }";

        Call<Route> mapquestRoutingRestCall = apiInterface.doMapquestRoute(
                waypoints,
                "GQBzawlKPiSflQ5wn0ky3X7WQHyzMwAV");


        mapquestRoutingRestCall.enqueue(new Callback<Route>() {
            @Override
            public void onResponse(Call<Route> call, Response<Route> response) {
                Route root = response.body();
                Route_ route=root.getRoute();
                List<Location> locations=route.getLocations();
                List<Integer> waypointOrder=route.getLocationSequence();
                List<Leg> legs=route.getLegs();

                TourRoute tourRoute= new TourRoute();
                tourRoute.setStartLocation(placeOrigin);
                ArrayList<MapquestRouteLegWrapper> rlwLegs=new ArrayList<MapquestRouteLegWrapper>(legs.size()+1);

                for (int seqIndex=0;seqIndex<legs.size()-1;seqIndex++) {
                    TourItem tourItem = MapquestRoutingRest.tourItems.get(waypointOrder.get(seqIndex));
                    MapquestRouteLegWrapper legWrapper = new MapquestRouteLegWrapper();
                    legWrapper.setTourItem(tourItem);
                    legWrapper.setLeg(legs.get(seqIndex));
                    legWrapper.setLocation(locations.get(seqIndex));
                    rlwLegs.add(legWrapper);

                }

            //    tourRoute.setMapquestLegs(rlwLegs);
                Intent intent = new Intent(activity, RouteLegsListActivity.class);
                Gson gson = new Gson();
                String jsonRouteString = gson.toJson(tourRoute);
                intent.putExtra("TourRoute", jsonRouteString);
                activity.startActivity(intent);


            }

            @Override
            public void onFailure(Call<Route> call, Throwable t) {

            }
            public void openWebPage(String url) {
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(intent);
                }
            }
        });




    }


}
