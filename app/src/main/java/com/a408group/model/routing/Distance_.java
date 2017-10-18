
package com.a408group.model.routing;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Distance_ implements Serializable, Parcelable
{

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("value")
    @Expose
    private Integer value;
    public final static Parcelable.Creator<Distance_> CREATOR = new Creator<Distance_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Distance_ createFromParcel(Parcel in) {
            Distance_ instance = new Distance_();
            instance.text = ((String) in.readValue((String.class.getClassLoader())));
            instance.value = ((Integer) in.readValue((Integer.class.getClassLoader())));
            return instance;
        }

        public Distance_[] newArray(int size) {
            return (new Distance_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5989897621897321006L;

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
