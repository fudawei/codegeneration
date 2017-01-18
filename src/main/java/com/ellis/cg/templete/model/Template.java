package com.ellis.cg.templete.model;

import com.ellis.cg.database.Field;
import com.ellis.cg.database.PrimaryKey;
import com.ellis.cg.database.Table;
import com.ellis.cg.generate.GenerateProerty;

import java.util.List;

/**
 * Created by fudw on 16-12-8.
 */
public abstract class Template {

    private Table table;
    private List<PrimaryKey> primaryKeys;
    private List<Field> fields;

    private GenerateProerty generateProerty;

    public abstract Template transform();

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<PrimaryKey> getPrimaryKeys() {
        return primaryKeys;
    }

    public void setPrimaryKeys(List<PrimaryKey> primaryKeys) {
        this.primaryKeys = primaryKeys;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public GenerateProerty getGenerateProerty() {
        return generateProerty;
    }

    public void setGenerateProerty(GenerateProerty generateProerty) {
        this.generateProerty = generateProerty;
    }
}
