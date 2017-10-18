
package com.a408group.model.mapquest.optimizedroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route {

    @SerializedName("route")
    @Expose
    private Route_ route;
    @SerializedName("info")
    @Expose
    private Info info;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Route() {
    }

    /**
     * 
     * @param route
     * @param info
     */
    public Route(Route_ route, Info info) {
        super();
        this.route = route;
        this.info = info;
    }

    public Route_ getRoute() {
        return route;
    }

    public void setRoute(Route_ route) {
        this.route = route;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

}
