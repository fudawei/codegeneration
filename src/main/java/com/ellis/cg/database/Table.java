package com.ellis.cg.database;

import java.util.List;

/**
 * Created by fudw on 16-12-3.
 */
public class Table {

    private String name;
    private List<Field> fields;

    public Table(String name) {
        this.name = name;
    }

    public Table(String name, List<Field> fields) {
        this.name = name;
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
