package com.a408group.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by michael on 9/21/17.
 */

public class TourRoute {
    @SerializedName("start")
    @Expose
    String start="";
    // lat,lng string
    @SerializedName("startLocation")
    @Expose
    String startLocation="";
    @SerializedName("end")
    // lat,lng string
    @Expose
    String endLocation="";
    @SerializedName("endLocation")
    @Expose
    String end="";
    @SerializedName("distance")
    @Expose
    int distance=0;
    @SerializedName("seconds")
    @Expose
    int seconds=0;
    @SerializedName("numStops")
    @Expose
    int numStops;
    @SerializedName("overyviewPolylinePoints")
    @Expose
    String overyviewPolylinePoints="";
 //   @SerializedName("mapquestlegs")
 //   @Expose
 //   ArrayList<MapquestRouteLegWrapper> mapquestlegs=null;

    @SerializedName("legs")
    @Expose
    ArrayList<GoogleRouteLegWrapper> legs=null;

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getNumStops() {
        return numStops;
    }

    public void setNumStops(int numStops) {
        this.numStops = numStops;
    }
    public String getOveryviewPolylinePoints()
    {
        return overyviewPolylinePoints;
    }
    public void setOveryviewPolylinePoints(String overyviewPolylinePoints)
    {
        this.overyviewPolylinePoints=overyviewPolylinePoints;
    }
  //  public ArrayList<MapquestRouteLegWrapper> getMapquestLegs() {
    //    return mapquestlegs;
   // }

 //   public void setMapquestLegs( ArrayList<MapquestRouteLegWrapper> mapquestlegs) {
 //       this.mapquestlegs = mapquestlegs;
 //   }

 //   public ArrayList getGoogleLegs() {
  //      return googlelegs;
  //  }
  //  public void setGoogleLegs( ArrayList<GoogleRouteLegWrapper> legs) {
  //      this.googlelegs = legs;
  //  }

    public void setLegs( ArrayList<GoogleRouteLegWrapper> legs) {
        this.legs = legs;
    }
    public ArrayList getLegs() {
             return legs;
          }
}
