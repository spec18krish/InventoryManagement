/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Dealer;
import com.ims.dataAccess.tables.records.DealerRecord;

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
public class DealerDao extends DAOImpl<DealerRecord, com.ims.dataAccess.tables.pojos.Dealer, Integer> {

    /**
     * Create a new DealerDao without any configuration
     */
    public DealerDao() {
        super(Dealer.DEALER, com.ims.dataAccess.tables.pojos.Dealer.class);
    }

    /**
     * Create a new DealerDao with an attached configuration
     */
    public DealerDao(Configuration configuration) {
        super(Dealer.DEALER, com.ims.dataAccess.tables.pojos.Dealer.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Dealer object) {
        return object.getDealerid();
    }

    /**
     * Fetch records that have <code>dealerId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchRangeOfDealerid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Dealer.DEALER.DEALERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dealerId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchByDealerid(Integer... values) {
        return fetch(Dealer.DEALER.DEALERID, values);
    }

    /**
     * Fetch a unique record that has <code>dealerId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Dealer fetchOneByDealerid(Integer value) {
        return fetchOne(Dealer.DEALER.DEALERID, value);
    }

    /**
     * Fetch records that have <code>userId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchRangeOfUserid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Dealer.DEALER.USERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchByUserid(Integer... values) {
        return fetch(Dealer.DEALER.USERID, values);
    }

    /**
     * Fetch records that have <code>companyName BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchRangeOfCompanyname(String lowerInclusive, String upperInclusive) {
        return fetchRange(Dealer.DEALER.COMPANYNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>companyName IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchByCompanyname(String... values) {
        return fetch(Dealer.DEALER.COMPANYNAME, values);
    }

    /**
     * Fetch records that have <code>dealerDescription BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchRangeOfDealerdescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Dealer.DEALER.DEALERDESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dealerDescription IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Dealer> fetchByDealerdescription(String... values) {
        return fetch(Dealer.DEALER.DEALERDESCRIPTION, values);
    }
}
