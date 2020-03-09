/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables;


import com.ims.dataAccess.Indexes;
import com.ims.dataAccess.Inventorymanagement;
import com.ims.dataAccess.Keys;
import com.ims.dataAccess.tables.records.BrandRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class Brand extends TableImpl<BrandRecord> {

    private static final long serialVersionUID = -1480887669;

    /**
     * The reference instance of <code>inventorymanagement.brand</code>
     */
    public static final Brand BRAND = new Brand();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BrandRecord> getRecordType() {
        return BrandRecord.class;
    }

    /**
     * The column <code>inventorymanagement.brand.brandId</code>.
     */
    public final TableField<BrandRecord, Integer> BRANDID = createField(DSL.name("brandId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>inventorymanagement.brand.brandName</code>.
     */
    public final TableField<BrandRecord, String> BRANDNAME = createField(DSL.name("brandName"), org.jooq.impl.SQLDataType.VARCHAR(25).nullable(false), this, "");

    /**
     * The column <code>inventorymanagement.brand.brandDescription</code>.
     */
    public final TableField<BrandRecord, String> BRANDDESCRIPTION = createField(DSL.name("brandDescription"), org.jooq.impl.SQLDataType.VARCHAR(150), this, "");

    /**
     * Create a <code>inventorymanagement.brand</code> table reference
     */
    public Brand() {
        this(DSL.name("brand"), null);
    }

    /**
     * Create an aliased <code>inventorymanagement.brand</code> table reference
     */
    public Brand(String alias) {
        this(DSL.name(alias), BRAND);
    }

    /**
     * Create an aliased <code>inventorymanagement.brand</code> table reference
     */
    public Brand(Name alias) {
        this(alias, BRAND);
    }

    private Brand(Name alias, Table<BrandRecord> aliased) {
        this(alias, aliased, null);
    }

    private Brand(Name alias, Table<BrandRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Brand(Table<O> child, ForeignKey<O, BrandRecord> key) {
        super(child, key, BRAND);
    }

    @Override
    public Schema getSchema() {
        return Inventorymanagement.INVENTORYMANAGEMENT;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.BRAND_BRAND_NAME_UNIQUE, Indexes.BRAND_PRIMARY);
    }

    @Override
    public Identity<BrandRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BRAND;
    }

    @Override
    public UniqueKey<BrandRecord> getPrimaryKey() {
        return Keys.KEY_BRAND_PRIMARY;
    }

    @Override
    public List<UniqueKey<BrandRecord>> getKeys() {
        return Arrays.<UniqueKey<BrandRecord>>asList(Keys.KEY_BRAND_PRIMARY, Keys.KEY_BRAND_BRAND_NAME_UNIQUE);
    }

    @Override
    public Brand as(String alias) {
        return new Brand(DSL.name(alias), this);
    }

    @Override
    public Brand as(Name alias) {
        return new Brand(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Brand rename(String name) {
        return new Brand(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Brand rename(Name name) {
        return new Brand(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
