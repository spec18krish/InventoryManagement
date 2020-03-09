/*
 * This file is generated by jOOQ.
 */
package com.ims.dataAccess.tables.records;


import com.ims.dataAccess.tables.User;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
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
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record14<Integer, Integer, String, String, Integer, String, String, String, String, String, Integer, String, String, String> {

    private static final long serialVersionUID = 2134036729;

    /**
     * Setter for <code>inventorymanagement.user.userId</code>.
     */
    public void setUserid(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.userId</code>.
     */
    public Integer getUserid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>inventorymanagement.user.userTypeId</code>.
     */
    public void setUsertypeid(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.userTypeId</code>.
     */
    public Integer getUsertypeid() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>inventorymanagement.user.firstName</code>.
     */
    public void setFirstname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.firstName</code>.
     */
    public String getFirstname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>inventorymanagement.user.lastName</code>.
     */
    public void setLastname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.lastName</code>.
     */
    public String getLastname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>inventorymanagement.user.age</code>.
     */
    public void setAge(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.age</code>.
     */
    public Integer getAge() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>inventorymanagement.user.gender</code>.
     */
    public void setGender(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.gender</code>.
     */
    public String getGender() {
        return (String) get(5);
    }

    /**
     * Setter for <code>inventorymanagement.user.email</code>.
     */
    public void setEmail(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.email</code>.
     */
    public String getEmail() {
        return (String) get(6);
    }

    /**
     * Setter for <code>inventorymanagement.user.mobileNumber</code>.
     */
    public void setMobilenumber(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.mobileNumber</code>.
     */
    public String getMobilenumber() {
        return (String) get(7);
    }

    /**
     * Setter for <code>inventorymanagement.user.userName</code>.
     */
    public void setUsername(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.userName</code>.
     */
    public String getUsername() {
        return (String) get(8);
    }

    /**
     * Setter for <code>inventorymanagement.user.password</code>.
     */
    public void setPassword(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.password</code>.
     */
    public String getPassword() {
        return (String) get(9);
    }

    /**
     * Setter for <code>inventorymanagement.user.houseNo</code>.
     */
    public void setHouseno(Integer value) {
        set(10, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.houseNo</code>.
     */
    public Integer getHouseno() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>inventorymanagement.user.streetName</code>.
     */
    public void setStreetname(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.streetName</code>.
     */
    public String getStreetname() {
        return (String) get(11);
    }

    /**
     * Setter for <code>inventorymanagement.user.suburb</code>.
     */
    public void setSuburb(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.suburb</code>.
     */
    public String getSuburb() {
        return (String) get(12);
    }

    /**
     * Setter for <code>inventorymanagement.user.city</code>.
     */
    public void setCity(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>inventorymanagement.user.city</code>.
     */
    public String getCity() {
        return (String) get(13);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record14 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row14<Integer, Integer, String, String, Integer, String, String, String, String, String, Integer, String, String, String> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    @Override
    public Row14<Integer, Integer, String, String, Integer, String, String, String, String, String, Integer, String, String, String> valuesRow() {
        return (Row14) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return User.USER.USERID;
    }

    @Override
    public Field<Integer> field2() {
        return User.USER.USERTYPEID;
    }

    @Override
    public Field<String> field3() {
        return User.USER.FIRSTNAME;
    }

    @Override
    public Field<String> field4() {
        return User.USER.LASTNAME;
    }

    @Override
    public Field<Integer> field5() {
        return User.USER.AGE;
    }

    @Override
    public Field<String> field6() {
        return User.USER.GENDER;
    }

    @Override
    public Field<String> field7() {
        return User.USER.EMAIL;
    }

    @Override
    public Field<String> field8() {
        return User.USER.MOBILENUMBER;
    }

    @Override
    public Field<String> field9() {
        return User.USER.USERNAME;
    }

    @Override
    public Field<String> field10() {
        return User.USER.PASSWORD;
    }

    @Override
    public Field<Integer> field11() {
        return User.USER.HOUSENO;
    }

    @Override
    public Field<String> field12() {
        return User.USER.STREETNAME;
    }

    @Override
    public Field<String> field13() {
        return User.USER.SUBURB;
    }

    @Override
    public Field<String> field14() {
        return User.USER.CITY;
    }

    @Override
    public Integer component1() {
        return getUserid();
    }

    @Override
    public Integer component2() {
        return getUsertypeid();
    }

    @Override
    public String component3() {
        return getFirstname();
    }

    @Override
    public String component4() {
        return getLastname();
    }

    @Override
    public Integer component5() {
        return getAge();
    }

    @Override
    public String component6() {
        return getGender();
    }

    @Override
    public String component7() {
        return getEmail();
    }

    @Override
    public String component8() {
        return getMobilenumber();
    }

    @Override
    public String component9() {
        return getUsername();
    }

    @Override
    public String component10() {
        return getPassword();
    }

    @Override
    public Integer component11() {
        return getHouseno();
    }

    @Override
    public String component12() {
        return getStreetname();
    }

    @Override
    public String component13() {
        return getSuburb();
    }

    @Override
    public String component14() {
        return getCity();
    }

    @Override
    public Integer value1() {
        return getUserid();
    }

    @Override
    public Integer value2() {
        return getUsertypeid();
    }

    @Override
    public String value3() {
        return getFirstname();
    }

    @Override
    public String value4() {
        return getLastname();
    }

    @Override
    public Integer value5() {
        return getAge();
    }

    @Override
    public String value6() {
        return getGender();
    }

    @Override
    public String value7() {
        return getEmail();
    }

    @Override
    public String value8() {
        return getMobilenumber();
    }

    @Override
    public String value9() {
        return getUsername();
    }

    @Override
    public String value10() {
        return getPassword();
    }

    @Override
    public Integer value11() {
        return getHouseno();
    }

    @Override
    public String value12() {
        return getStreetname();
    }

    @Override
    public String value13() {
        return getSuburb();
    }

    @Override
    public String value14() {
        return getCity();
    }

    @Override
    public UserRecord value1(Integer value) {
        setUserid(value);
        return this;
    }

    @Override
    public UserRecord value2(Integer value) {
        setUsertypeid(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public UserRecord value5(Integer value) {
        setAge(value);
        return this;
    }

    @Override
    public UserRecord value6(String value) {
        setGender(value);
        return this;
    }

    @Override
    public UserRecord value7(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value8(String value) {
        setMobilenumber(value);
        return this;
    }

    @Override
    public UserRecord value9(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value10(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value11(Integer value) {
        setHouseno(value);
        return this;
    }

    @Override
    public UserRecord value12(String value) {
        setStreetname(value);
        return this;
    }

    @Override
    public UserRecord value13(String value) {
        setSuburb(value);
        return this;
    }

    @Override
    public UserRecord value14(String value) {
        setCity(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, Integer value2, String value3, String value4, Integer value5, String value6, String value7, String value8, String value9, String value10, Integer value11, String value12, String value13, String value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(User.USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer userid, Integer usertypeid, String firstname, String lastname, Integer age, String gender, String email, String mobilenumber, String username, String password, Integer houseno, String streetname, String suburb, String city) {
        super(User.USER);

        set(0, userid);
        set(1, usertypeid);
        set(2, firstname);
        set(3, lastname);
        set(4, age);
        set(5, gender);
        set(6, email);
        set(7, mobilenumber);
        set(8, username);
        set(9, password);
        set(10, houseno);
        set(11, streetname);
        set(12, suburb);
        set(13, city);
    }
}
