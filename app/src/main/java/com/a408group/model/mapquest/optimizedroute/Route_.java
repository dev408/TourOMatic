
package com.a408group.model.mapquest.optimizedroute;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Route_ {

    @SerializedName("hasTollRoad")
    @Expose
    private Boolean hasTollRoad;
    @SerializedName("hasBridge")
    @Expose
    private Boolean hasBridge;
    @SerializedName("computedWaypoints")
    @Expose
    private List<Object> computedWaypoints = new ArrayList<Object>();
    @SerializedName("fuelUsed")
    @Expose
    private Double fuelUsed;
    @SerializedName("hasTunnel")
    @Expose
    private Boolean hasTunnel;
    @SerializedName("hasUnpaved")
    @Expose
    private Boolean hasUnpaved;
    @SerializedName("hasHighway")
    @Expose
    private Boolean hasHighway;
    @SerializedName("realTime")
    @Expose
    private Integer realTime;
    @SerializedName("boundingBox")
    @Expose
    private BoundingBox boundingBox;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("locationSequence")
    @Expose
    private List<Integer> locationSequence = new ArrayList<Integer>();
    @SerializedName("hasSeasonalClosure")
    @Expose
    private Boolean hasSeasonalClosure;
    @SerializedName("sessionId")
    @Expose
    private String sessionId;
    @SerializedName("locations")
    @Expose
    private List<Location> locations = new ArrayList<Location>();
    @SerializedName("hasCountryCross")
    @Expose
    private Boolean hasCountryCross;
    @SerializedName("legs")
    @Expose
    private List<Leg> legs = new ArrayList<Leg>();
    @SerializedName("formattedTime")
    @Expose
    private String formattedTime;
    @SerializedName("routeError")
    @Expose
    private RouteError routeError;
    @SerializedName("options")
    @Expose
    private Options options;
    @SerializedName("hasFerry")
    @Expose
    private Boolean hasFerry;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Route_() {
    }

    /**
     * 
     * @param hasTollRoad
     * @param hasBridge
     * @param computedWaypoints
     * @param fuelUsed
     * @param hasTunnel
     * @param hasUnpaved
     * @param hasHighway
     * @param realTime
     * @param boundingBox
     * @param distance
     * @param time
     * @param locationSequence
     * @param locations
     * @param sessionId
     * @param hasSeasonalClosure
     * @param legs
     * @param hasCountryCross
     * @param formattedTime
     * @param hasFerry
     * @param options
     * @param routeError
     */
    public Route_(Boolean hasTollRoad, Boolean hasBridge, List<Object> computedWaypoints, Double fuelUsed, Boolean hasTunnel, Boolean hasUnpaved, Boolean hasHighway, Integer realTime, BoundingBox boundingBox, Double distance, Integer time, List<Integer> locationSequence, Boolean hasSeasonalClosure, String sessionId, List<Location> locations, Boolean hasCountryCross, List<Leg> legs, String formattedTime, RouteError routeError, Options options, Boolean hasFerry) {
        super();
        this.hasTollRoad = hasTollRoad;
        this.hasBridge = hasBridge;
        this.computedWaypoints = computedWaypoints;
        this.fuelUsed = fuelUsed;
        this.hasTunnel = hasTunnel;
        this.hasUnpaved = hasUnpaved;
        this.hasHighway = hasHighway;
        this.realTime = realTime;
        this.boundingBox = boundingBox;
        this.distance = distance;
        this.time = time;
        this.locationSequence = locationSequence;
        this.hasSeasonalClosure = hasSeasonalClosure;
        this.sessionId = sessionId;
        this.locations = locations;
        this.hasCountryCross = hasCountryCross;
        this.legs = legs;
        this.formattedTime = formattedTime;
        this.routeError = routeError;
        this.options = options;
        this.hasFerry = hasFerry;
    }

    public Boolean getHasTollRoad() {
        return hasTollRoad;
    }

    public void setHasTollRoad(Boolean hasTollRoad) {
        this.hasTollRoad = hasTollRoad;
    }

    public Boolean getHasBridge() {
        return hasBridge;
    }

    public void setHasBridge(Boolean hasBridge) {
        this.hasBridge = hasBridge;
    }

    public List<Object> getComputedWaypoints() {
        return computedWaypoints;
    }

    public void setComputedWaypoints(List<Object> computedWaypoints) {
        this.computedWaypoints = computedWaypoints;
    }

    public Double getFuelUsed() {
        return fuelUsed;
    }

    public void setFuelUsed(Double fuelUsed) {
        this.fuelUsed = fuelUsed;
    }

    public Boolean getHasTunnel() {
        return hasTunnel;
    }

    public void setHasTunnel(Boolean hasTunnel) {
        this.hasTunnel = hasTunnel;
    }

    public Boolean getHasUnpaved() {
        return hasUnpaved;
    }

    public void setHasUnpaved(Boolean hasUnpaved) {
        this.hasUnpaved = hasUnpaved;
    }

    public Boolean getHasHighway() {
        return hasHighway;
    }

    public void setHasHighway(Boolean hasHighway) {
        this.hasHighway = hasHighway;
    }

    public Integer getRealTime() {
        return realTime;
    }

    public void setRealTime(Integer realTime) {
        this.realTime = realTime;
    }

    public BoundingBox getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(BoundingBox boundingBox) {
        this.boundingBox = boundingBox;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public List<Integer> getLocationSequence() {
        return locationSequence;
    }

    public void setLocationSequence(List<Integer> locationSequence) {
        this.locationSequence = locationSequence;
    }

    public Boolean getHasSeasonalClosure() {
        return hasSeasonalClosure;
    }

    public void setHasSeasonalClosure(Boolean hasSeasonalClosure) {
        this.hasSeasonalClosure = hasSeasonalClosure;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Boolean getHasCountryCross() {
        return hasCountryCross;
    }

    public void setHasCountryCross(Boolean hasCountryCross) {
        this.hasCountryCross = hasCountryCross;
    }

    public List<Leg> getLegs() {
        return legs;
    }

    public void setLegs(List<Leg> legs) {
        this.legs = legs;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

    public RouteError getRouteError() {
        return routeError;
    }

    public void setRouteError(RouteError routeError) {
        this.routeError = routeError;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    public Boolean getHasFerry() {
        return hasFerry;
    }

    public void setHasFerry(Boolean hasFerry) {
        this.hasFerry = hasFerry;
    }

}
