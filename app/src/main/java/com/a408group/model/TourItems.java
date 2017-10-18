
package com.a408group.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class TourItems implements Serializable{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("TourItem")
    @Expose
    private ArrayList<TourItem> tourItem = null;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ArrayList<TourItem> getTourItem() {
        return tourItem;
    }

    public void setTourItem(ArrayList<TourItem> tourItem) {
        this.tourItem = tourItem;
    }

}
