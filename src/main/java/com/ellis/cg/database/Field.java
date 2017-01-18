package com.ellis.cg.database;

/**
 * Created by fudw on 16-12-3.
 */
public class Field {

    private String name;
    private String property;
    private DataType dateType;
    private Integer length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getDateType() {
        return dateType;
    }

    public void setDateType(DataType dateType) {
        this.dateType = dateType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getProperty() {
        return property;
    }

    public Field() {
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public Field(String name, DataType dateType, Integer length) {
        this.name = name;
        this.dateType = dateType;
        this.length = length;
    }

    public Field(String name, String property, DataType dateType, Integer length) {
        this.name = name;
        this.property = property;
        this.dateType = dateType;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Field{" +
                "name='" + name + '\'' +
                ", property='" + property + '\'' +
                ", dateType=" + dateType +
                ", length=" + length +
                '}';
    }
}
