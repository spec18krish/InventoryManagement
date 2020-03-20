/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Usertype;
import com.ims.dataAccess.tables.records.UsertypeRecord;

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
public class UsertypeDao extends DAOImpl<UsertypeRecord, com.ims.dataAccess.tables.pojos.Usertype, Integer> {

    /**
     * Create a new UsertypeDao without any configuration
     */
    public UsertypeDao() {
        super(Usertype.USERTYPE, com.ims.dataAccess.tables.pojos.Usertype.class);
    }

    /**
     * Create a new UsertypeDao with an attached configuration
     */
    public UsertypeDao(Configuration configuration) {
        super(Usertype.USERTYPE, com.ims.dataAccess.tables.pojos.Usertype.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Usertype object) {
        return object.getUsertypeid();
    }

    /**
     * Fetch records that have <code>userTypeId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchRangeOfUsertypeid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Usertype.USERTYPE.USERTYPEID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userTypeId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchByUsertypeid(Integer... values) {
        return fetch(Usertype.USERTYPE.USERTYPEID, values);
    }

    /**
     * Fetch a unique record that has <code>userTypeId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Usertype fetchOneByUsertypeid(Integer value) {
        return fetchOne(Usertype.USERTYPE.USERTYPEID, value);
    }

    /**
     * Fetch records that have <code>userTypeName BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchRangeOfUsertypename(String lowerInclusive, String upperInclusive) {
        return fetchRange(Usertype.USERTYPE.USERTYPENAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userTypeName IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchByUsertypename(String... values) {
        return fetch(Usertype.USERTYPE.USERTYPENAME, values);
    }

    /**
     * Fetch a unique record that has <code>userTypeName = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Usertype fetchOneByUsertypename(String value) {
        return fetchOne(Usertype.USERTYPE.USERTYPENAME, value);
    }

    /**
     * Fetch records that have <code>userTypeDescription BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchRangeOfUsertypedescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Usertype.USERTYPE.USERTYPEDESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>userTypeDescription IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Usertype> fetchByUsertypedescription(String... values) {
        return fetch(Usertype.USERTYPE.USERTYPEDESCRIPTION, values);
    }
}
