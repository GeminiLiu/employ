/*
 * This file is generated by jOOQ.
 */
package com.jagt.employ.user.infra.model.tables;


import com.jagt.employ.user.infra.model.EmployBiz;
import com.jagt.employ.user.infra.model.Indexes;
import com.jagt.employ.user.infra.model.Keys;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
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
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Hello extends TableImpl<Record> {

    private static final long serialVersionUID = 1209673361;

    /**
     * The reference instance of <code>employ-biz.hello</code>
     */
    public static final Hello HELLO = new Hello();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>employ-biz.hello.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).identity(true), this, "");

    /**
     * The column <code>employ-biz.hello.version</code>.
     */
    public final TableField<Record, Long> VERSION = createField("version", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>employ-biz.hello.field</code>.
     */
    public final TableField<Record, String> FIELD = createField("field", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>employ-biz.hello.msg</code>.
     */
    public final TableField<Record, String> MSG = createField("msg", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>employ-biz.hello.name</code>.
     */
    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>employ-biz.hello</code> table reference
     */
    public Hello() {
        this(DSL.name("hello"), null);
    }

    /**
     * Create an aliased <code>employ-biz.hello</code> table reference
     */
    public Hello(String alias) {
        this(DSL.name(alias), HELLO);
    }

    /**
     * Create an aliased <code>employ-biz.hello</code> table reference
     */
    public Hello(Name alias) {
        this(alias, HELLO);
    }

    private Hello(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Hello(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Hello(Table<O> child, ForeignKey<O, Record> key) {
        super(child, key, HELLO);
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.HELLO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Record, Long> getIdentity() {
        return Keys.IDENTITY_HELLO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_HELLO_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_HELLO_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hello as(String alias) {
        return new Hello(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hello as(Name alias) {
        return new Hello(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Hello rename(String name) {
        return new Hello(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Hello rename(Name name) {
        return new Hello(name, null);
    }
}
