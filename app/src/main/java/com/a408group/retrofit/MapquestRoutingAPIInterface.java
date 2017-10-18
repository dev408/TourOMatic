package com.a408group.retrofit;


import com.a408group.model.mapquest.optimizedroute.Route;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface MapquestRoutingAPIInterface {

    //    https://maps.googleapis.com/maps/api/directions/json

    @GET("/directions/v2/optimizedroute")
        // origin=Boston,MA&destination=Concord,MA&waypoints=Charlestown,MA|Lexington,MA&key=AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM

    Call<Route> doMapquestRoute(@Query("json") String waypoints,
                                            @Query("key") String key);

// key = GQBzawlKPiSflQ5wn0ky3X7WQHyzMwAV
}
