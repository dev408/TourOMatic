
package com.a408group.model.routing;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Routes implements Serializable, Parcelable
{

    @SerializedName("geocoded_waypoints")
    @Expose
    private List<GeocodedWaypoint> geocodedWaypoints = null;
    @SerializedName("routes")
    @Expose
    private List<Route> routes = null;
    @SerializedName("status")
    @Expose
    private String status;
    public final static Parcelable.Creator<Routes> CREATOR = new Creator<Routes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Routes createFromParcel(Parcel in) {
            Routes instance = new Routes();
            in.readList(instance.geocodedWaypoints, (com.a408group.model.routing.GeocodedWaypoint.class.getClassLoader()));
            in.readList(instance.routes, (com.a408group.model.routing.Route.class.getClassLoader()));
            instance.status = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Routes[] newArray(int size) {
            return (new Routes[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4224664660374373958L;

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return geocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        this.geocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(geocodedWaypoints);
        dest.writeList(routes);
        dest.writeValue(status);
    }

    public int describeContents() {
        return  0;
    }

}
