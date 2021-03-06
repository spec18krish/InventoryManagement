/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Customer;
import com.ims.dataAccess.tables.records.CustomerRecord;

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
public class CustomerDao extends DAOImpl<CustomerRecord, com.ims.dataAccess.tables.pojos.Customer, Integer> {

    /**
     * Create a new CustomerDao without any configuration
     */
    public CustomerDao() {
        super(Customer.CUSTOMER, com.ims.dataAccess.tables.pojos.Customer.class);
    }

    /**
     * Create a new CustomerDao with an attached configuration
     */
    public CustomerDao(Configuration configuration) {
        super(Customer.CUSTOMER, com.ims.dataAccess.tables.pojos.Customer.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Customer object) {
        return object.getCustomerid();
    }

    /**
     * Fetch records that have <code>customerId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Customer> fetchRangeOfCustomerid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Customer.CUSTOMER.CUSTOMERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>customerId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Customer> fetchByCustomerid(Integer... values) {
        return fetch(Customer.CUSTOMER.CUSTOMERID, values);
    }

    /**
     * Fetch a unique record that has <code>customerId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Customer fetchOneByCustomerid(Integer value) {
        return fetchOne(Customer.CUSTOMER.CUSTOMERID, value);
    }

    /**
     * Fetch records that have <code>userId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Customer> fetchRangeOfUserid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Customer.CUSTOMER.USERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Customer> fetchByUserid(Integer... values) {
        return fetch(Customer.CUSTOMER.USERID, values);
    }
}
