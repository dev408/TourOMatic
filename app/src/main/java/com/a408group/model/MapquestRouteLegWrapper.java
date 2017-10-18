package com.a408group.model;

/**
 * Created by michael on 9/21/17.
 */

import com.a408group.model.mapquest.optimizedroute.Leg;
import com.a408group.model.mapquest.optimizedroute.Location;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MapquestRouteLegWrapper implements RouteLegWrapperInterface{
    @SerializedName("tourItem")
    @Expose
    TourItem tourItem;
    @SerializedName("leg")
    @Expose
    Leg leg;
    @SerializedName("location")
    @Expose
    Location location;
    public MapquestRouteLegWrapper()
    {

    }
    public Leg getLeg() {
        return leg;
    }

    public void setLeg( Leg leg) {
        this.leg = leg;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation( Location location) {
        this.location =location;
    }

    public TourItem getTourItem() {
        return tourItem;
    }

    public void setTourItem( TourItem tourItem) {
        this.tourItem = tourItem;
    }
}
