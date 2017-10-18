
package com.a408group.model.mapquest.optimizedroute;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BoundingBox {

    @SerializedName("ul")
    @Expose
    private Ul ul;
    @SerializedName("lr")
    @Expose
    private Lr lr;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BoundingBox() {
    }

    /**
     * 
     * @param ul
     * @param lr
     */
    public BoundingBox(Ul ul, Lr lr) {
        super();
        this.ul = ul;
        this.lr = lr;
    }

    public Ul getUl() {
        return ul;
    }

    public void setUl(Ul ul) {
        this.ul = ul;
    }

    public Lr getLr() {
        return lr;
    }

    public void setLr(Lr lr) {
        this.lr = lr;
    }

}
