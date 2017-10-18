package com.a408group.retrofit;


import com.a408group.model.nearestroads.NearestRoads;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface GoogleNearestRoadsAPIInterface {

    //    https://maps.googleapis.com

    @GET("/v1/nearestRoads")


    // origin=Boston,MA&destination=Concord,MA&waypoints=Charlestown,MA|Lexington,MA&key=AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM

    Call<NearestRoads> doGoogleNearestRoads(@Query("points") String origin,
                                            @Query("key") String key);



}
