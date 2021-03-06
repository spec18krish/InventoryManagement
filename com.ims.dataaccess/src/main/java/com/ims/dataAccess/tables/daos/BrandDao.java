/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Brand;
import com.ims.dataAccess.tables.records.BrandRecord;

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
public class BrandDao extends DAOImpl<BrandRecord, com.ims.dataAccess.tables.pojos.Brand, Integer> {

    /**
     * Create a new BrandDao without any configuration
     */
    public BrandDao() {
        super(Brand.BRAND, com.ims.dataAccess.tables.pojos.Brand.class);
    }

    /**
     * Create a new BrandDao with an attached configuration
     */
    public BrandDao(Configuration configuration) {
        super(Brand.BRAND, com.ims.dataAccess.tables.pojos.Brand.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Brand object) {
        return object.getBrandid();
    }

    /**
     * Fetch records that have <code>brandId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchRangeOfBrandid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Brand.BRAND.BRANDID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>brandId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchByBrandid(Integer... values) {
        return fetch(Brand.BRAND.BRANDID, values);
    }

    /**
     * Fetch a unique record that has <code>brandId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Brand fetchOneByBrandid(Integer value) {
        return fetchOne(Brand.BRAND.BRANDID, value);
    }

    /**
     * Fetch records that have <code>brandName BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchRangeOfBrandname(String lowerInclusive, String upperInclusive) {
        return fetchRange(Brand.BRAND.BRANDNAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>brandName IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchByBrandname(String... values) {
        return fetch(Brand.BRAND.BRANDNAME, values);
    }

    /**
     * Fetch a unique record that has <code>brandName = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Brand fetchOneByBrandname(String value) {
        return fetchOne(Brand.BRAND.BRANDNAME, value);
    }

    /**
     * Fetch records that have <code>brandDescription BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchRangeOfBranddescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Brand.BRAND.BRANDDESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>brandDescription IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Brand> fetchByBranddescription(String... values) {
        return fetch(Brand.BRAND.BRANDDESCRIPTION, values);
    }
}
