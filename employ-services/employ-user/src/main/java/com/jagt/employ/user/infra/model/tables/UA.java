/*
 * This file is generated by jOOQ.
 */
package com.jagt.employ.user.infra.model.tables;


import com.jagt.employ.user.infra.model.EmployBiz;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UA extends TableImpl<Record> {

    private static final long serialVersionUID = -1395986340;

    /**
     * The reference instance of <code>employ-biz.u_a</code>
     */
    public static final UA U_A = new UA();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>employ-biz.u_a.test</code>.
     */
    public final TableField<Record, String> TEST = createField("test", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>employ-biz.u_a</code> table reference
     */
    public UA() {
        this(DSL.name("u_a"), null);
    }

    /**
     * Create an aliased <code>employ-biz.u_a</code> table reference
     */
    public UA(String alias) {
        this(DSL.name(alias), U_A);
    }

    /**
     * Create an aliased <code>employ-biz.u_a</code> table reference
     */
    public UA(Name alias) {
        this(alias, U_A);
    }

    private UA(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private UA(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> UA(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, U_A);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return EmployBiz.EMPLOY_BIZ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UA as(String alias) {
        return new UA(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UA as(Name alias) {
        return new UA(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UA rename(String name) {
        return new UA(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UA rename(Name name) {
        return new UA(name, null);
    }
}
