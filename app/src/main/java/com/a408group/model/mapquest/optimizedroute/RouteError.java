
package com.a408group.model.mapquest.optimizedroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RouteError {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;

    /**
     * No args constructor for use in serialization
     * 
     */
    public RouteError() {
    }

    /**
     * 
     * @param message
     * @param errorCode
     */
    public RouteError(String message, Integer errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

}
