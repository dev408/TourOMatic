
package com.a408group.model.routing;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OverviewPolyline implements Serializable, Parcelable
{

    @SerializedName("points")
    @Expose
    private String points;
    public final static Parcelable.Creator<OverviewPolyline> CREATOR = new Creator<OverviewPolyline>() {


        @SuppressWarnings({
            "unchecked"
        })
        public OverviewPolyline createFromParcel(Parcel in) {
            OverviewPolyline instance = new OverviewPolyline();
            instance.points = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public OverviewPolyline[] newArray(int size) {
            return (new OverviewPolyline[size]);
        }

    }
    ;
    private final static long serialVersionUID = -8133703556408141029L;

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(points);
    }

    public int describeContents() {
        return  0;
    }

}
