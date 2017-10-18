
package com.a408group.model.routing;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Distance implements Serializable, Parcelable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private Integer value;
    public final static Parcelable.Creator<Distance> CREATOR = new Creator<Distance>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Distance createFromParcel(Parcel in) {
            Distance instance = new Distance();
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Distance[] newArray(int size) {
            return (new Distance[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3864077451709011425L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(text);
        dest.writeValue(value);
    }

    public int describeContents() {
        return  0;
    }

}
