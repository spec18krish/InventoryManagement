/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.12.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Purchasedetail implements Serializable {

    private static final long serialVersionUID = -873842720;

    private Integer purchasedetailid;
    private Integer purchaseid;
    private Integer productid;
    private Integer quantity;
    private String  purchasenotes;

    public Purchasedetail() {}

    public Purchasedetail(Purchasedetail value) {
        this.purchasedetailid = value.purchasedetailid;
        this.purchaseid = value.purchaseid;
        this.productid = value.productid;
        this.quantity = value.quantity;
        this.purchasenotes = value.purchasenotes;
    }

    public Purchasedetail(
        Integer purchasedetailid,
        Integer purchaseid,
        Integer productid,
        Integer quantity,
        String  purchasenotes
    ) {
        this.purchasedetailid = purchasedetailid;
        this.purchaseid = purchaseid;
        this.productid = productid;
        this.quantity = quantity;
        this.purchasenotes = purchasenotes;
    }

    public Integer getPurchasedetailid() {
        return this.purchasedetailid;
    }

    public void setPurchasedetailid(Integer purchasedetailid) {
        this.purchasedetailid = purchasedetailid;
    }

    public Integer getPurchaseid() {
        return this.purchaseid;
    }

    public void setPurchaseid(Integer purchaseid) {
        this.purchaseid = purchaseid;
    }

    public Integer getProductid() {
        return this.productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPurchasenotes() {
        return this.purchasenotes;
    }

    public void setPurchasenotes(String purchasenotes) {
        this.purchasenotes = purchasenotes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Purchasedetail (");

        sb.append(purchasedetailid);
        sb.append(", ").append(purchaseid);
        sb.append(", ").append(productid);
        sb.append(", ").append(quantity);
        sb.append(", ").append(purchasenotes);

        sb.append(")");
        return sb.toString();
    }
}
