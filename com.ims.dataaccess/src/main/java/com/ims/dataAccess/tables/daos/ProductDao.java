/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.daos;


import com.ims.dataAccess.tables.Product;
import com.ims.dataAccess.tables.records.ProductRecord;

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
public class ProductDao extends DAOImpl<ProductRecord, com.ims.dataAccess.tables.pojos.Product, Integer> {

    /**
     * Create a new ProductDao without any configuration
     */
    public ProductDao() {
        super(Product.PRODUCT, com.ims.dataAccess.tables.pojos.Product.class);
    }

    /**
     * Create a new ProductDao with an attached configuration
     */
    public ProductDao(Configuration configuration) {
        super(Product.PRODUCT, com.ims.dataAccess.tables.pojos.Product.class, configuration);
    }

    @Override
    public Integer getId(com.ims.dataAccess.tables.pojos.Product object) {
        return object.getProductid();
    }

    /**
     * Fetch records that have <code>productId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfProductid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Product.PRODUCT.PRODUCTID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>productId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByProductid(Integer... values) {
        return fetch(Product.PRODUCT.PRODUCTID, values);
    }

    /**
     * Fetch a unique record that has <code>productId = value</code>
     */
    public com.ims.dataAccess.tables.pojos.Product fetchOneByProductid(Integer value) {
        return fetchOne(Product.PRODUCT.PRODUCTID, value);
    }

    /**
     * Fetch records that have <code>name BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfName(String lowerInclusive, String upperInclusive) {
        return fetchRange(Product.PRODUCT.NAME, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>name IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByName(String... values) {
        return fetch(Product.PRODUCT.NAME, values);
    }

    /**
     * Fetch records that have <code>availableStock BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfAvailablestock(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Product.PRODUCT.AVAILABLESTOCK, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>availableStock IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByAvailablestock(Integer... values) {
        return fetch(Product.PRODUCT.AVAILABLESTOCK, values);
    }

    /**
     * Fetch records that have <code>productDescription BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfProductdescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Product.PRODUCT.PRODUCTDESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>productDescription IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByProductdescription(String... values) {
        return fetch(Product.PRODUCT.PRODUCTDESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>price BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfPrice(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Product.PRODUCT.PRICE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>price IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByPrice(Long... values) {
        return fetch(Product.PRODUCT.PRICE, values);
    }

    /**
     * Fetch records that have <code>image BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfImage(byte[] lowerInclusive, byte[] upperInclusive) {
        return fetchRange(Product.PRODUCT.IMAGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>image IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByImage(byte[]... values) {
        return fetch(Product.PRODUCT.IMAGE, values);
    }

    /**
     * Fetch records that have <code>categoryId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfCategoryid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Product.PRODUCT.CATEGORYID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>categoryId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByCategoryid(Integer... values) {
        return fetch(Product.PRODUCT.CATEGORYID, values);
    }

    /**
     * Fetch records that have <code>brandId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfBrandid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Product.PRODUCT.BRANDID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>brandId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByBrandid(Integer... values) {
        return fetch(Product.PRODUCT.BRANDID, values);
    }

    /**
     * Fetch records that have <code>dealerId BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchRangeOfDealerid(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Product.PRODUCT.DEALERID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>dealerId IN (values)</code>
     */
    public List<com.ims.dataAccess.tables.pojos.Product> fetchByDealerid(Integer... values) {
        return fetch(Product.PRODUCT.DEALERID, values);
    }
}
