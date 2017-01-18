package com.ellis.cg.templete.model;

import com.ellis.cg.templete.BuiltInTemplate;
import com.ellis.tools.Config;
import com.ellis.cg.code.Import;
import com.ellis.cg.code.Package;
import com.ellis.cg.database.PrimaryKey;
import com.ellis.cg.generate.GenerateProerty;
import com.ellis.tools.StringUtils;

import java.io.File;

/**
 * Created by fudw on 16-12-8.
 */
public class DaoClass extends Template {

    private static final String PACKAGE_TAIL = ".dao";

    private String DaoName;
    private String beanName;
    private String beanParameter;
    private Import beanImport;
    private Package dPackage;
    private String nameSpace;
    private PrimaryKey primaryKey;
    private Config config;

    public DaoClass(Config config) {
        this.config = config;
    }

    @Override
    public Template transform() {

        String modelClass = StringUtils.firstLetterUpper(StringUtils.toCamelCase(super.getTable().getName(), config.getConnector()),config.getConnector());
        this.setDaoName(modelClass + "Dao");
        this.setBeanName(modelClass);
        this.setBeanParameter(StringUtils.firstLetterLower(modelClass));
        this.setBeanImport(new Import(config.getSrcPackage() + ".model." + modelClass));
        this.setdPackage(new Package(config.getSrcPackage() + ".dao"));
        this.setNameSpace(super.getTable().getName());
        this.setPrimaryKey(super.getPrimaryKeys() != null && super.getPrimaryKeys().size() > 0 ? super.getPrimaryKeys().get(0): null);
        String path = config.getSrcPath() + File.separator + this.dPackage.getPath();
        super.setGenerateProerty(new GenerateProerty(path, StringUtils.firstLetterUpper(this.getDaoName()) + ".java", BuiltInTemplate.DAO_CALSS));
        return this;
    }

    public String getDaoName() {
        return DaoName;
    }

    public void setDaoName(String daoName) {
        DaoName = daoName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanParameter() {
        return beanParameter;
    }

    public void setBeanParameter(String beanParameter) {
        this.beanParameter = beanParameter;
    }

    public Import getBeanImport() {
        return beanImport;
    }

    public void setBeanImport(Import beanImport) {
        this.beanImport = beanImport;
    }

    public Package getdPackage() {
        return dPackage;
    }

    public void setdPackage(Package dPackage) {
        this.dPackage = dPackage;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
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
}
