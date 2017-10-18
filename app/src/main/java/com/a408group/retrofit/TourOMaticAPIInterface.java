package com.a408group.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anupamchugh on 09/01/17.
 */

public interface TourOMaticAPIInterface {



    @GET("/tourbuilder/service/touritems")
// category=Museums+and+Cultural+Institutions
// &searchdomain=category
// &lng=-73.98886820000001
// &lat=40.6817734
// &distance=3.0&duration=10000
// &stops=8
// &srchType=GEOBOUNDS
// &bounds=33.249128%25%2C-85.810157%2C47.369608%2C-62.167579
// &transitmode=pedestrian

    Call<ResponseBody> doGetTourItems(@Query("category") String category,
                                      @Query("searchdomain") String searchdomain,
                                      @Query("lat") String lat,
                                      @Query("lng") String lng,
                                      @Query("distance") String distance,
                                      @Query("duration") String duration,
                                      @Query("srchType") String srchType,
                                      @Query("stops") String stops,
                                      @Query("bounds") String bounds,
                                      @Query("transitmode") String transitmode);


}
