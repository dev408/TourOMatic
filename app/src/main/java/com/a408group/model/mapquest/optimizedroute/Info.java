
package com.a408group.model.mapquest.optimizedroute;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

    @SerializedName("copyright")
    @Expose
    private Copyright copyright;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("messages")
    @Expose
    private List<Object> messages = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Info() {
    }

    /**
     * 
     * @param copyright
     * @param statuscode
     * @param messages
     */
    public Info(Copyright copyright, Integer statuscode, List<Object> messages) {
        super();
        this.copyright = copyright;
        this.statuscode = statuscode;
        this.messages = messages;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public List<Object> getMessages() {
        return messages;
    }

    public void setMessages(List<Object> messages) {
        this.messages = messages;
    }

}
