package com.ellis.cg.templete.model;

import com.ellis.cg.templete.BuiltInTemplate;
import com.ellis.tools.Config;
import com.ellis.cg.code.Package;
import com.ellis.cg.database.Field;
import com.ellis.cg.database.PrimaryKey;
import com.ellis.cg.generate.GenerateProerty;
import com.ellis.tools.StringUtils;

import java.io.File;
import java.util.Iterator;

/**
 * Created by fudw on 16-12-8.
 */
public class SqlBeanXml extends Template {

    private String beanMap;
    private String beanType;
    private String tableName;
    private String xmlName;
    private Boolean singlePk;
    private PrimaryKey primaryKey;
    private Package xpackage;



    private Config config;

    public SqlBeanXml(Config config) {
        this.config = config;
    }

    @Override
    public Template transform() {
        this.tableName = super.getTable().getName();
        String beanMapStr = StringUtils.toCamelCase(this.tableName, config.getConnector());
        this.beanMap = beanMapStr + "Map";
        this.beanType = StringUtils.firstLetterUpper(beanMapStr);
        this.xmlName = StringUtils.firstLetterUpper(this.tableName, config.getConnector());
        this.xpackage = new Package(config.getSrcPackage() + ".model.mapper");

        this.primaryKey = super.getPrimaryKeys() != null && super.getPrimaryKeys().size() > 0 ? super.getPrimaryKeys().get(0) : null;

        if (super.getFields() != null && super.getPrimaryKeys() != null) {
            Iterator<Field> iterator = super.getFields().iterator();
            while(iterator.hasNext()){
                Field field = iterator.next();
                for (PrimaryKey pk : super.getPrimaryKeys()) {
                    if(field.getName().equals(pk.getName())){
                        pk.setName(field.getName());
                        pk.setDateType(field.getDateType());
                        pk.setLength(field.getLength());
                        pk.setProperty(field.getProperty());
                        iterator.remove();
                    }
                }
            }
        }

        String path = config.getSrcPath() + File.separator + this.xpackage.getPath() ;
        super.setGenerateProerty(new GenerateProerty(path, "SqlMap_" +StringUtils.firstLetterUpper(this.xmlName) + ".xml", BuiltInTemplate.SQL_MAP_BEAN_XML_CLASS));
        return this;
    }

    public String getBeanMap() {
        return beanMap;
    }

    public void setBeanMap(String beanMap) {
        this.beanMap = beanMap;
    }

    public String getBeanType() {
        return beanType;
    }

    public void setBeanType(String beanType) {
        this.beanType = beanType;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public Boolean getSinglePk() {
        return singlePk;
    }

    public void setSinglePk(Boolean singlePk) {
        this.singlePk = singlePk;
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Package getXpackage() {
        return xpackage;
    }

    public void setXpackage(Package xpackage) {
        this.xpackage = xpackage;
    }
}
