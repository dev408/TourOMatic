
package com.a408group.model.nearestroads;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SnappedPoint implements Serializable, Parcelable
{

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("originalIndex")
    @Expose
    private Integer originalIndex;
    @SerializedName("placeId")
    @Expose
    private String placeId;
    public final static Parcelable.Creator<SnappedPoint> CREATOR = new Creator<SnappedPoint>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SnappedPoint createFromParcel(Parcel in) {
            SnappedPoint instance = new SnappedPoint();
            instance.location = ((Location) in.readValue((Location.class.getClassLoader())));
            instance.originalIndex = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.placeId = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public SnappedPoint[] newArray(int size) {
            return (new SnappedPoint[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2410977632077316528L;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getOriginalIndex() {
        return originalIndex;
    }

    public void setOriginalIndex(Integer originalIndex) {
        this.originalIndex = originalIndex;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(location);
        dest.writeValue(originalIndex);
        dest.writeValue(placeId);
    }

    public int describeContents() {
        return  0;
    }

}
