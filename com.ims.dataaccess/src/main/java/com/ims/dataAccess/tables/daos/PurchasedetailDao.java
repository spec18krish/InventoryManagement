/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Purchasedetail;
import com.ims.dataAccess.tables.records.PurchasedetailRecord;

import java.util.List;

import javax.annotation.Generated;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


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
public class PurchasedetailDao extends DAOImpl<PurchasedetailRecord, com.ims.dataAccess.tables.pojos.Purchasedetail, Integer> {

    /**
     * Create a new PurchasedetailDao without any configuration
     */
    public PurchasedetailDao() {
        super(Purchasedetail.PURCHASEDETAIL, com.ims.dataAccess.tables.pojos.Purchasedetail.class);
    }

    /**
     * Create a new PurchasedetailDao with an attached configuration
     */
    public PurchasedetailDao(Configuration configuration) {
        super(Purchasedetail.PURCHASEDETAIL, com.ims.dataAccess.tables.pojos.Purchasedetail.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Purchasedetail object) {
        return object.getPurchasedetailid();
    }

    /**
     * Fetch records that have <code>purchaseDetailId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchRangeOfPurchasedetailid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Purchasedetail.PURCHASEDETAIL.PURCHASEDETAILID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>purchaseDetailId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchByPurchasedetailid(Integer... values) {
        return fetch(Purchasedetail.PURCHASEDETAIL.PURCHASEDETAILID, values);
    }

    /**
     * Fetch a unique record that has <code>purchaseDetailId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Purchasedetail fetchOneByPurchasedetailid(Integer value) {
        return fetchOne(Purchasedetail.PURCHASEDETAIL.PURCHASEDETAILID, value);
    }

    /**
     * Fetch records that have <code>purchaseId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchRangeOfPurchaseid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Purchasedetail.PURCHASEDETAIL.PURCHASEID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>purchaseId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchByPurchaseid(Integer... values) {
        return fetch(Purchasedetail.PURCHASEDETAIL.PURCHASEID, values);
    }

    /**
     * Fetch records that have <code>productId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchRangeOfProductid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Purchasedetail.PURCHASEDETAIL.PRODUCTID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>productId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchByProductid(Integer... values) {
        return fetch(Purchasedetail.PURCHASEDETAIL.PRODUCTID, values);
    }

    /**
     * Fetch records that have <code>quantity BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchRangeOfQuantity(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Purchasedetail.PURCHASEDETAIL.QUANTITY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>quantity IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchByQuantity(Integer... values) {
        return fetch(Purchasedetail.PURCHASEDETAIL.QUANTITY, values);
    }

    /**
     * Fetch records that have <code>purchaseNotes BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchRangeOfPurchasenotes(String lowerInclusive, String upperInclusive) {
        return fetchRange(Purchasedetail.PURCHASEDETAIL.PURCHASENOTES, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>purchaseNotes IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Purchasedetail> fetchByPurchasenotes(String... values) {
        return fetch(Purchasedetail.PURCHASEDETAIL.PURCHASENOTES, values);
    }
}
