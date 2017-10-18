package com.a408group.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import com.a408group.model.routing.*;
/**
 * Created by anupamchugh on 09/01/17.
 */

public interface GoogleRoutingAPIInterface {

    //    https://maps.googleapis.com/maps/api/directions/json

    @GET("/maps/api/directions/json")
    // origin=Boston,MA&destination=Concord,MA&waypoints=Charlestown,MA|Lexington,MA&key=AIzaSyDdZOI7V3ig315QsHE1p6bf-Y1awTfDjdM

    Call<Routes> doGoogleRouting(@Query("origin") String origin,
                                      @Query("destination") String destination,
                                      @Query("waypoints") String waypoints,
                                      @Query("mode") String mode,
                                      @Query("key") String key);


}
