package com.ellis.cg.templete;

import com.ellis.cg.templete.model.Template;
import com.ellis.tools.Config;
import com.ellis.cg.database.DataBaseReader;
import com.ellis.cg.database.Field;
import com.ellis.cg.database.PrimaryKey;
import com.ellis.cg.database.Table;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by fudw on 16-12-8.
 */
public class TemplateFactory {

    private DataBaseReader dataBaseReader;

    private Config config;

    public TemplateFactory(DataBaseReader dataBaseReader, Config config) {
        this.dataBaseReader = dataBaseReader;
        this.config = config;
    }

    public Template create(String table, Class<? extends Template> cls) {
        List<Field> fields = dataBaseReader.fetchTableFields(table);
        List<PrimaryKey> primaryKeys = dataBaseReader.fetchTablePKs(table);
        Template template = null;
        try {
            template = cls.getConstructor(Config.class).newInstance(config);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        template.setFields(fields);
        template.setPrimaryKeys(primaryKeys);
        template.setTable(new Table(table));
        return template;
    }
}
