
package com.a408group.model.mapquest.optimizedroute;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Maneuver {

    @SerializedName("signs")
    @Expose
    private List<Object> signs = new ArrayList<Object>();
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("maneuverNotes")
    @Expose
    private List<Object> maneuverNotes = new ArrayList<Object>();
    @SerializedName("direction")
    @Expose
    private Integer direction;
    @SerializedName("narrative")
    @Expose
    private String narrative;
    @SerializedName("iconUrl")
    @Expose
    private String iconUrl;
    @SerializedName("distance")
    @Expose
    private Double distance;
    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("linkIds")
    @Expose
    private List<Object> linkIds = new ArrayList<Object>();
    @SerializedName("streets")
    @Expose
    private List<String> streets = new ArrayList<String>();
    @SerializedName("attributes")
    @Expose
    private Integer attributes;
    @SerializedName("transportMode")
    @Expose
    private String transportMode;
    @SerializedName("formattedTime")
    @Expose
    private String formattedTime;
    @SerializedName("directionName")
    @Expose
    private String directionName;
    @SerializedName("mapUrl")
    @Expose
    private String mapUrl;
    @SerializedName("startPoint")
    @Expose
    private StartPoint startPoint;
    @SerializedName("turnType")
    @Expose
    private Integer turnType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Maneuver() {
    }

    /**
     * 
     * @param signs
     * @param index
     * @param maneuverNotes
     * @param direction
     * @param narrative
     * @param iconUrl
     * @param distance
     * @param time
     * @param linkIds
     * @param streets
     * @param attributes
     * @param transportMode
     * @param formattedTime
     * @param directionName
     * @param turnType
     * @param startPoint
     * @param mapUrl
     */
    public Maneuver(List<Object> signs, Integer index, List<Object> maneuverNotes, Integer direction, String narrative, String iconUrl, Double distance, Integer time, List<Object> linkIds, List<String> streets, Integer attributes, String transportMode, String formattedTime, String directionName, String mapUrl, StartPoint startPoint, Integer turnType) {
        super();
        this.signs = signs;
        this.index = index;
        this.maneuverNotes = maneuverNotes;
        this.direction = direction;
        this.narrative = narrative;
        this.iconUrl = iconUrl;
        this.distance = distance;
        this.time = time;
        this.linkIds = linkIds;
        this.streets = streets;
        this.attributes = attributes;
        this.transportMode = transportMode;
        this.formattedTime = formattedTime;
        this.directionName = directionName;
        this.mapUrl = mapUrl;
        this.startPoint = startPoint;
        this.turnType = turnType;
    }

    public List<Object> getSigns() {
        return signs;
    }

    public void setSigns(List<Object> signs) {
        this.signs = signs;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Object> getManeuverNotes() {
        return maneuverNotes;
    }

    public void setManeuverNotes(List<Object> maneuverNotes) {
        this.maneuverNotes = maneuverNotes;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
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

    public List<Object> getLinkIds() {
        return linkIds;
    }

    public void setLinkIds(List<Object> linkIds) {
        this.linkIds = linkIds;
    }

    public List<String> getStreets() {
        return streets;
    }

    public void setStreets(List<String> streets) {
        this.streets = streets;
    }

    public Integer getAttributes() {
        return attributes;
    }

    public void setAttributes(Integer attributes) {
        this.attributes = attributes;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }

    public StartPoint getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(StartPoint startPoint) {
        this.startPoint = startPoint;
    }

    public Integer getTurnType() {
        return turnType;
    }

    public void setTurnType(Integer turnType) {
        this.turnType = turnType;
    }

}
