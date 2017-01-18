package com.ellis.cg.database;

/**
 * Created by fudw on 16-12-3.
 */
public class PrimaryKey extends Field {
    private Short keySeql;
    private String pkName;
    private String fuPkName;

    public static PrimaryKey create(String name, String property, DataType dateType, Integer length, String pkName, Short keySeql, String fuPkName) {
        return new PrimaryKey(name, property, dateType, length, pkName, keySeql, fuPkName);
    }

    private PrimaryKey(String name, String property, DataType dateType, Integer length, String pkName, Short keySeql, String fuPkName) {
        super(name, property, dateType, length);
        this.pkName = pkName;
        this.keySeql = keySeql;
        this.fuPkName = fuPkName;
    }

}
