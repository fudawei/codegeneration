package com.ellis.cg.templete.model;

import com.ellis.cg.code.Import;
import com.ellis.cg.code.Package;
import com.ellis.cg.database.PrimaryKey;
import com.ellis.cg.generate.GenerateProerty;
import com.ellis.cg.templete.BuiltInTemplate;
import com.ellis.tools.Config;
import com.ellis.tools.StringUtils;

import java.io.File;

/**
 * Created by fudw on 16-12-8.
 */
public class ServiceClass extends Template {

    private static final String PACKAGE_TAIL = ".service";

    private String daoName;
    private String daoParameter;
    private String serviceName;
    private String beanName;
    private String beanParameter;
    private Import beanImport;
    private Import daoImport;
    private Package sPackage;
    private PrimaryKey primaryKey;
    private Config config;

    public ServiceClass(Config config) {
        this.config = config;
    }

    @Override
    public Template transform() {

        String modelClass = StringUtils.firstLetterUpper(StringUtils.toCamelCase(super.getTable().getName(), config.getConnector()),config.getConnector());
        this.setDaoName(modelClass + "Dao");
        this.setDaoParameter(StringUtils.firstLetterLower(modelClass) + "Dao");
        this.setServiceName(modelClass + "Service");
        this.setBeanName(modelClass);
        this.setBeanParameter(StringUtils.firstLetterLower(modelClass));
        this.setBeanImport(new Import(config.getSrcPackage() + ".model." + modelClass));
        this.setDaoImport(new Import(config.getSrcPackage() + ".dao." + this.getDaoName()));
        this.setsPackage(new Package(config.getSrcPackage() + ".service"));
        this.setPrimaryKey(super.getPrimaryKeys() != null && super.getPrimaryKeys().size() > 0 ? super.getPrimaryKeys().get(0): null);
        String path = config.getSrcPath() + File.separator + this.sPackage.getPath();
        super.setGenerateProerty(new GenerateProerty(path, StringUtils.firstLetterUpper(this.getServiceName()) + ".java", BuiltInTemplate.SERVICE_CLASS));
        return this;
    }

    public String getDaoName() {
        return daoName;
    }

    public void setDaoName(String daoName) {
        this.daoName = daoName;
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Package getsPackage() {
        return sPackage;
    }

    public Import getDaoImport() {
        return daoImport;
    }

    public void setDaoImport(Import daoImport) {
        this.daoImport = daoImport;
    }

    public void setsPackage(Package sPackage) {
        this.sPackage = sPackage;
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

    public String getDaoParameter() {
        return daoParameter;
    }

    public void setDaoParameter(String daoParameter) {
        this.daoParameter = daoParameter;
    }
}
