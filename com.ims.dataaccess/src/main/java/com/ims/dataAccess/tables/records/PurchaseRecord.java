/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.records;


import com.ims.dataAccess.tables.Purchase;

import java.sql.Date;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class PurchaseRecord extends UpdatableRecordImpl<PurchaseRecord> implements Record6<Integer, String, String, Date, Date, String> {

    private static final long serialVersionUID = -1456032398;

    /**
     * Setter for <code>inventorymanagement.purchase.purchaseId</code>.
     */
    public void setPurchaseid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.purchaseId</code>.
     */
    public Integer getPurchaseid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>inventorymanagement.purchase.purchaseName</code>.
     */
    public void setPurchasename(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.purchaseName</code>.
     */
    public String getPurchasename() {
        return (String) get(1);
    }

    /**
     * Setter for <code>inventorymanagement.purchase.purchaseDescription</code>.
     */
    public void setPurchasedescription(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.purchaseDescription</code>.
     */
    public String getPurchasedescription() {
        return (String) get(2);
    }

    /**
     * Setter for <code>inventorymanagement.purchase.purchaseDate</code>.
     */
    public void setPurchasedate(Date value) {
        set(3, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.purchaseDate</code>.
     */
    public Date getPurchasedate() {
        return (Date) get(3);
    }

    /**
     * Setter for <code>inventorymanagement.purchase.deliveryDate</code>.
     */
    public void setDeliverydate(Date value) {
        set(4, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.deliveryDate</code>.
     */
    public Date getDeliverydate() {
        return (Date) get(4);
    }

    /**
     * Setter for <code>inventorymanagement.purchase.shipmentType</code>.
     */
    public void setShipmenttype(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>inventorymanagement.purchase.shipmentType</code>.
     */
    public String getShipmenttype() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, Date, Date, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, Date, Date, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Purchase.PURCHASE.PURCHASEID;
    }

    @Override
    public Field<String> field2() {
        return Purchase.PURCHASE.PURCHASENAME;
    }

    @Override
    public Field<String> field3() {
        return Purchase.PURCHASE.PURCHASEDESCRIPTION;
    }

    @Override
    public Field<Date> field4() {
        return Purchase.PURCHASE.PURCHASEDATE;
    }

    @Override
    public Field<Date> field5() {
        return Purchase.PURCHASE.DELIVERYDATE;
    }

    @Override
    public Field<String> field6() {
        return Purchase.PURCHASE.SHIPMENTTYPE;
    }

    @Override
    public Integer component1() {
        return getPurchaseid();
    }

    @Override
    public String component2() {
        return getPurchasename();
    }

    @Override
    public String component3() {
        return getPurchasedescription();
    }

    @Override
    public Date component4() {
        return getPurchasedate();
    }

    @Override
    public Date component5() {
        return getDeliverydate();
    }

    @Override
    public String component6() {
        return getShipmenttype();
    }

    @Override
    public Integer value1() {
        return getPurchaseid();
    }

    @Override
    public String value2() {
        return getPurchasename();
    }

    @Override
    public String value3() {
        return getPurchasedescription();
    }

    @Override
    public Date value4() {
        return getPurchasedate();
    }

    @Override
    public Date value5() {
        return getDeliverydate();
    }

    @Override
    public String value6() {
        return getShipmenttype();
    }

    @Override
    public PurchaseRecord value1(Integer value) {
        setPurchaseid(value);
        return this;
    }

    @Override
    public PurchaseRecord value2(String value) {
        setPurchasename(value);
        return this;
    }

    @Override
    public PurchaseRecord value3(String value) {
        setPurchasedescription(value);
        return this;
    }

    @Override
    public PurchaseRecord value4(Date value) {
        setPurchasedate(value);
        return this;
    }

    @Override
    public PurchaseRecord value5(Date value) {
        setDeliverydate(value);
        return this;
    }

    @Override
    public PurchaseRecord value6(String value) {
        setShipmenttype(value);
        return this;
    }

    @Override
    public PurchaseRecord values(Integer value1, String value2, String value3, Date value4, Date value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PurchaseRecord
     */
    public PurchaseRecord() {
        super(Purchase.PURCHASE);
    }

    /**
     * Create a detached, initialised PurchaseRecord
     */
    public PurchaseRecord(Integer purchaseid, String purchasename, String purchasedescription, Date purchasedate, Date deliverydate, String shipmenttype) {
        super(Purchase.PURCHASE);

        set(0, purchaseid);
        set(1, purchasename);
        set(2, purchasedescription);
        set(3, purchasedate);
        set(4, deliverydate);
        set(5, shipmenttype);
    }
}