
package com.a408group.model.mapquest.optimizedroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StartPoint {

    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("lat")
    @Expose
    private Double lat;

    /**
     * No args constructor for use in serialization
     * 
     */
    public StartPoint() {
    }

    /**
     * 
     * @param lng
     * @param lat
     */
    public StartPoint(Double lng, Double lat) {
        super();
        this.lng = lng;
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

}
