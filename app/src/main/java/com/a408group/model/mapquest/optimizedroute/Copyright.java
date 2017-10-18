
package com.a408group.model.mapquest.optimizedroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Copyright {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("imageAltText")
    @Expose
    private String imageAltText;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Copyright() {
    }

    /**
     * 
     * @param text
     * @param imageUrl
     * @param imageAltText
     */
    public Copyright(String text, String imageUrl, String imageAltText) {
        super();
        this.text = text;
        this.imageUrl = imageUrl;
        this.imageAltText = imageAltText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageAltText() {
        return imageAltText;
    }

    public void setImageAltText(String imageAltText) {
        this.imageAltText = imageAltText;
    }

}