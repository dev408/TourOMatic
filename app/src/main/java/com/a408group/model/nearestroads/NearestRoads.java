
package com.a408group.model.nearestroads;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NearestRoads implements Serializable, Parcelable
{

    @SerializedName("snappedPoints")
    @Expose
    private List<SnappedPoint> snappedPoints = null;
    public final static Parcelable.Creator<NearestRoads> CREATOR = new Creator<NearestRoads>() {


        @SuppressWarnings({
            "unchecked"
        })
        public NearestRoads createFromParcel(Parcel in) {
            NearestRoads instance = new NearestRoads();
            in.readList(instance.snappedPoints, (com.a408group.model.nearestroads.SnappedPoint.class.getClassLoader()));
            return instance;
        }

        public NearestRoads[] newArray(int size) {
            return (new NearestRoads[size]);
        }

    }
    ;
    private final static long serialVersionUID = -2468476187490525186L;

    public List<SnappedPoint> getSnappedPoints() {
        return snappedPoints;
    }

    public void setSnappedPoints(List<SnappedPoint> snappedPoints) {
        this.snappedPoints = snappedPoints;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(snappedPoints);
    }

    public int describeContents() {
        return  0;
    }

}
