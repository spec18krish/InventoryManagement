/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.records;


import com.ims.dataAccess.tables.Customer;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


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
public class CustomerRecord extends UpdatableRecordImpl<CustomerRecord> implements Record2<Integer, Integer> {

    private static final long serialVersionUID = 1854263100;

    /**
     * Setter for <code>inventorymanagement.customer.customerId</code>.
     */
    public void setCustomerid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>inventorymanagement.customer.customerId</code>.
     */
    public Integer getCustomerid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>inventorymanagement.customer.userId</code>.
     */
    public void setUserid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>inventorymanagement.customer.userId</code>.
     */
    public Integer getUserid() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Customer.CUSTOMER.CUSTOMERID;
    }

    @Override
    public Field<Integer> field2() {
        return Customer.CUSTOMER.USERID;
    }

    @Override
    public Integer component1() {
        return getCustomerid();
    }

    @Override
    public Integer component2() {
        return getUserid();
    }

    @Override
    public Integer value1() {
        return getCustomerid();
    }

    @Override
    public Integer value2() {
        return getUserid();
    }

    @Override
    public CustomerRecord value1(Integer value) {
        setCustomerid(value);
        return this;
    }

    @Override
    public CustomerRecord value2(Integer value) {
        setUserid(value);
        return this;
    }

    @Override
    public CustomerRecord values(Integer value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerRecord
     */
    public CustomerRecord() {
        super(Customer.CUSTOMER);
    }

    /**
     * Create a detached, initialised CustomerRecord
     */
    public CustomerRecord(Integer customerid, Integer userid) {
        super(Customer.CUSTOMER);

        set(0, customerid);
        set(1, userid);
    }
}
