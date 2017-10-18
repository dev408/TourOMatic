package com.a408group.model;

/**
 * Created by michael on 9/21/17.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.a408group.model.routing.Leg;

public class GoogleRouteLegWrapper implements RouteLegWrapperInterface{
    @SerializedName("tourItem")
    @Expose
    TourItem tourItem;
    @SerializedName("leg")
    @Expose
    Leg leg;
    public GoogleRouteLegWrapper()
    {

    }
    public Leg getLeg() {
        return leg;
    }

    public void setLeg( Leg leg) {
        this.leg = leg;
    }

    public TourItem getTourItem() {
        return tourItem;
    }

    public void setTourItem( TourItem tourItem) {
        this.tourItem = tourItem;
    }
}
