/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables;


import com.ims.dataAccess.Indexes;
import com.ims.dataAccess.Inventorymanagement;
import com.ims.dataAccess.Keys;
import com.ims.dataAccess.tables.records.DealerRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class Dealer extends TableImpl<DealerRecord> {

    private static final long serialVersionUID = 1291613147;

    /**
     * The reference instance of <code>inventorymanagement.dealer</code>
     */
    public static final Dealer DEALER = new Dealer();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DealerRecord> getRecordType() {
        return DealerRecord.class;
    }

    /**
     * The column <code>inventorymanagement.dealer.dealerId</code>.
     */
    public final TableField<DealerRecord, Integer> DEALERID = createField(DSL.name("dealerId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>inventorymanagement.dealer.userId</code>.
     */
    public final TableField<DealerRecord, Integer> USERID = createField(DSL.name("userId"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>inventorymanagement.dealer.companyName</code>.
     */
    public final TableField<DealerRecord, String> COMPANYNAME = createField(DSL.name("companyName"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>inventorymanagement.dealer.dealerDescription</code>.
     */
    public final TableField<DealerRecord, String> DEALERDESCRIPTION = createField(DSL.name("dealerDescription"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * Create a <code>inventorymanagement.dealer</code> table reference
     */
    public Dealer() {
        this(DSL.name("dealer"), null);
    }

    /**
     * Create an aliased <code>inventorymanagement.dealer</code> table reference
     */
    public Dealer(String alias) {
        this(DSL.name(alias), DEALER);
    }

    /**
     * Create an aliased <code>inventorymanagement.dealer</code> table reference
     */
    public Dealer(Name alias) {
        this(alias, DEALER);
    }

    private Dealer(Name alias, Table<DealerRecord> aliased) {
        this(alias, aliased, null);
    }

    private Dealer(Name alias, Table<DealerRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Dealer(Table<O> child, ForeignKey<O, DealerRecord> key) {
        super(child, key, DEALER);
    }

    @Override
    public Schema getSchema() {
        return Inventorymanagement.INVENTORYMANAGEMENT;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DEALER_DEALER_USERID_FK, Indexes.DEALER_PRIMARY);
    }

    @Override
    public Identity<DealerRecord, Integer> getIdentity() {
        return Keys.IDENTITY_DEALER;
    }

    @Override
    public UniqueKey<DealerRecord> getPrimaryKey() {
        return Keys.KEY_DEALER_PRIMARY;
    }

    @Override
    public List<UniqueKey<DealerRecord>> getKeys() {
        return Arrays.<UniqueKey<DealerRecord>>asList(Keys.KEY_DEALER_PRIMARY);
    }

    @Override
    public List<ForeignKey<DealerRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<DealerRecord, ?>>asList(Keys.DEALER_USERID_FK);
    }

    public User user() {
        return new User(this, Keys.DEALER_USERID_FK);
    }

    @Override
    public Dealer as(String alias) {
        return new Dealer(DSL.name(alias), this);
    }

    @Override
    public Dealer as(Name alias) {
        return new Dealer(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Dealer rename(String name) {
        return new Dealer(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Dealer rename(Name name) {
        return new Dealer(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, String, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}