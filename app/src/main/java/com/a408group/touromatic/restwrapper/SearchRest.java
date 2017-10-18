package com.a408group.touromatic.restwrapper;

import android.content.Intent;
import android.widget.TextView;
import android.content.Context;

import com.a408group.retrofit.TourOMaticAPIClient;
import com.a408group.retrofit.TourOMaticAPIInterface;
import com.a408group.touromatic.SearchResultListActivity;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public   class SearchRest {

    TextView responseText;
    static TourOMaticAPIInterface apiInterface;
    static Context activity;

    public static void init(Context activity) {
        apiInterface = TourOMaticAPIClient.getClient().create(TourOMaticAPIInterface.class);
        SearchRest.activity = activity;
    }


    public static void doSearch() {

        // category=Museums+and+Cultural+Institutions
// &searchdomain=category
// &lng=-73.98886820000001
// &lat=40.6817734
// &distance=3.0&duration=10000
// &stops=8
// &srchType=GEOBOUNDS
// &bounds=33.249128%25%2C-85.810157%2C47.369608%2C-62.167579
// &transitmode=pedestrian

        Call<ResponseBody> tourItemsRestCall = apiInterface.doGetTourItems("Museums and Cultural Institutions",
                "category", "40.685723","-73.984534",
                "10.0", "10000", "GEOBOUNDS", "21",
                "33.249128%25%2C-85.810157%2C47.369608%2C-62.167579",
                "pedestrian");
        tourItemsRestCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String tourItemsJSON=response.body().string();

                    Intent i = new Intent(activity, SearchResultListActivity.class);
                    i.putExtra("TourItems",tourItemsJSON);
                    activity.startActivity(i);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

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
