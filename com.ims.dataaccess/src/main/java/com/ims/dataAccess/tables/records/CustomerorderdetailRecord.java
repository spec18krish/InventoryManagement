/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.records;


import com.ims.dataAccess.tables.Customerorderdetail;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
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
public class CustomerorderdetailRecord extends UpdatableRecordImpl<CustomerorderdetailRecord> implements Record5<Integer, Integer, Integer, Integer, String> {

    private static final long serialVersionUID = -1321439224;

    /**
     * Setter for <code>inventorymanagement.customerorderdetail.customerOrderDetailId</code>.
     */
    public void setCustomerorderdetailid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>inventorymanagement.customerorderdetail.customerOrderDetailId</code>.
     */
    public Integer getCustomerorderdetailid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>inventorymanagement.customerorderdetail.productId</code>.
     */
    public void setProductid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>inventorymanagement.customerorderdetail.productId</code>.
     */
    public Integer getProductid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>inventorymanagement.customerorderdetail.quantity</code>.
     */
    public void setQuantity(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>inventorymanagement.customerorderdetail.quantity</code>.
     */
    public Integer getQuantity() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>inventorymanagement.customerorderdetail.customerOrderId</code>.
     */
    public void setCustomerorderid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>inventorymanagement.customerorderdetail.customerOrderId</code>.
     */
    public Integer getCustomerorderid() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>inventorymanagement.customerorderdetail.orderDetailNotes</code>.
     */
    public void setOrderdetailnotes(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>inventorymanagement.customerorderdetail.orderDetailNotes</code>.
     */
    public String getOrderdetailnotes() {
        return (String) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, Integer, Integer, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, Integer, Integer, Integer, String> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Customerorderdetail.CUSTOMERORDERDETAIL.CUSTOMERORDERDETAILID;
    }

    @Override
    public Field<Integer> field2() {
        return Customerorderdetail.CUSTOMERORDERDETAIL.PRODUCTID;
    }

    @Override
    public Field<Integer> field3() {
        return Customerorderdetail.CUSTOMERORDERDETAIL.QUANTITY;
    }

    @Override
    public Field<Integer> field4() {
        return Customerorderdetail.CUSTOMERORDERDETAIL.CUSTOMERORDERID;
    }

    @Override
    public Field<String> field5() {
        return Customerorderdetail.CUSTOMERORDERDETAIL.ORDERDETAILNOTES;
    }

    @Override
    public Integer component1() {
        return getCustomerorderdetailid();
    }

    @Override
    public Integer component2() {
        return getProductid();
    }

    @Override
    public Integer component3() {
        return getQuantity();
    }

    @Override
    public Integer component4() {
        return getCustomerorderid();
    }

    @Override
    public String component5() {
        return getOrderdetailnotes();
    }

    @Override
    public Integer value1() {
        return getCustomerorderdetailid();
    }

    @Override
    public Integer value2() {
        return getProductid();
    }

    @Override
    public Integer value3() {
        return getQuantity();
    }

    @Override
    public Integer value4() {
        return getCustomerorderid();
    }

    @Override
    public String value5() {
        return getOrderdetailnotes();
    }

    @Override
    public CustomerorderdetailRecord value1(Integer value) {
        setCustomerorderdetailid(value);
        return this;
    }

    @Override
    public CustomerorderdetailRecord value2(Integer value) {
        setProductid(value);
        return this;
    }

    @Override
    public CustomerorderdetailRecord value3(Integer value) {
        setQuantity(value);
        return this;
    }

    @Override
    public CustomerorderdetailRecord value4(Integer value) {
        setCustomerorderid(value);
        return this;
    }

    @Override
    public CustomerorderdetailRecord value5(String value) {
        setOrderdetailnotes(value);
        return this;
    }

    @Override
    public CustomerorderdetailRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CustomerorderdetailRecord
     */
    public CustomerorderdetailRecord() {
        super(Customerorderdetail.CUSTOMERORDERDETAIL);
    }

    /**
     * Create a detached, initialised CustomerorderdetailRecord
     */
    public CustomerorderdetailRecord(Integer customerorderdetailid, Integer productid, Integer quantity, Integer customerorderid, String orderdetailnotes) {
        super(Customerorderdetail.CUSTOMERORDERDETAIL);

        set(0, customerorderdetailid);
        set(1, productid);
        set(2, quantity);
        set(3, customerorderid);
        set(4, orderdetailnotes);
    }
}