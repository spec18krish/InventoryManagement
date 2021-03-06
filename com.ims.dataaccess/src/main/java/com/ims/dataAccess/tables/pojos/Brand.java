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
public class Brand implements Serializable {

    private static final long serialVersionUID = 804597407;

    private Integer brandid;
    private String  brandname;
    private String  branddescription;

    public Brand() {}

    public Brand(Brand value) {
        this.brandid = value.brandid;
        this.brandname = value.brandname;
        this.branddescription = value.branddescription;
    }

    public Brand(
        Integer brandid,
        String  brandname,
        String  branddescription
    ) {
        this.brandid = brandid;
        this.brandname = brandname;
        this.branddescription = branddescription;
    }

    public Integer getBrandid() {
        return this.brandid;
    }

    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    public String getBrandname() {
        return this.brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getBranddescription() {
        return this.branddescription;
    }

    public void setBranddescription(String branddescription) {
        this.branddescription = branddescription;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Brand (");

        sb.append(brandid);
        sb.append(", ").append(brandname);
        sb.append(", ").append(branddescription);

        sb.append(")");
        return sb.toString();
    }
}
