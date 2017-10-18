package com.a408group.touromatic.restwrapper;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.net.Uri;
import com.a408group.retrofit.GoogleRoutingAPIClient;
import com.a408group.retrofit.GoogleRoutingAPIInterface;
import com.google.gson.Gson;
import com.a408group.model.routing.*;
import com.a408group.model.*;
import com.a408group.touromatic.*;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GoogleRoutingRest {

    TextView responseText;
    static GoogleRoutingAPIInterface apiInterface;
    static Context activity;
    static ArrayList<TourItem> tourItems;
    static String placeOrigin="";
    static String destination="";
    public static void init(Context activity) {
        apiInterface = GoogleRoutingAPIClient.getClient().create(GoogleRoutingAPIInterface.class);
        GoogleRoutingRest.activity = activity;
    }


    public static void doGoogleRoute(String origin, String destination, String mode, ArrayList<TourItem> tourItems, String waypoints) {

        GoogleRoutingRest.tourItems=tourItems;
        // category=Museums+and+Cultural+Institutions
        //  https://maps.googleapis.com/maps/api/directions/json?
        // origin=Boston,MA
        // &destination=Concord,MA
        // &waypoints=Charlestown,MA|Lexington,MA
        // &key=AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM
        // 1st 10 in tourItems for now
        final String placeOrigin=origin;





        Call<Routes> googleRoutingRestCall = apiInterface.doGoogleRouting(
                placeOrigin,
                destination,
                waypoints,
                mode,
                "AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM");


        googleRoutingRestCall.enqueue(new Callback<Routes>() {
            @Override
            public void onResponse(Call<Routes> call, Response<Routes> response) {

                Routes routes = response.body();
                ArrayList<Leg> legs=(ArrayList<Leg>)routes.getRoutes().get(0).getLegs();
                TourRoute tourRoute= new TourRoute();
                tourRoute.setStartLocation(placeOrigin);;
                ArrayList<GoogleRouteLegWrapper> rlwLegs=new ArrayList<GoogleRouteLegWrapper>();
                /*
                for(Leg leg:legs)
                {
                    TourItem tourItem =findTourItemByLatLng(GoogleRoutingRest.tourItems,leg);

                    GoogleRouteLegWrapper legWrapper = new GoogleRouteLegWrapper();
                    legWrapper.setTourItem(tourItem);
                    legWrapper.setLeg(leg);

                    rlwLegs.add(legWrapper);
                }
                */
                tourRoute.setOveryviewPolylinePoints(routes.getRoutes().get(0).getOverviewPolyline().getPoints());
                List<Integer> waypointOrder=routes.getRoutes().get(0).getWaypointOrder();
                for (int seqIndex=0;seqIndex<legs.size()-1;seqIndex++) {

                    TourItem tourItem = GoogleRoutingRest.tourItems.get(waypointOrder.get(seqIndex));
                    GoogleRouteLegWrapper legWrapper = new GoogleRouteLegWrapper();
                    legWrapper.setTourItem(tourItem);
                    legWrapper.setLeg(legs.get(seqIndex));

                    rlwLegs.add(legWrapper);

                }

                tourRoute.setLegs(rlwLegs);
                Intent intent = new Intent(activity, RouteLegsListActivity.class);
                Gson gson = new Gson();
                String jsonRouteString = gson.toJson(tourRoute);
                intent.putExtra("TourRoute", jsonRouteString);
                intent.putExtra("Origin", placeOrigin);
                activity.startActivity(intent);
            }

            @Override
            public void onFailure(Call<Routes> call, Throwable t) {

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
    public static TourItem findTourItemByLatLng(ArrayList<TourItem> tourItems,Leg leg)
    {
        for(TourItem item:tourItems)
        {

            if(roundCoord(item.getLat())==roundCoord(leg.getStartLocation().getLat().floatValue()) &&
                    roundCoord(item.getLng())==roundCoord((leg.getStartLocation().getLng().floatValue())))
            {
                return item;
            }
        }
        return null;
    }
    public static float roundCoord(float coord)
    {
        return (float)Math.round(coord * 1000000f) / 1000000f;
    }

}
