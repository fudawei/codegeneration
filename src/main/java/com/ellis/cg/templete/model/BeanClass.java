package com.ellis.cg.templete.model;

import com.ellis.cg.templete.BuiltInTemplate;
import com.ellis.tools.Config;
import com.ellis.cg.code.*;
import com.ellis.cg.code.Package;
import com.ellis.cg.database.Field;
import com.ellis.cg.generate.GenerateProerty;
import com.ellis.tools.StringUtils;
import com.ellis.tools.TransformUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fudw on 16-12-8.
 */
public class BeanClass extends Template {

    private static final String PACKAGE_TAIL = ".model";

    private String name;
    private Package bPackage;
    private List<Import> imports = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();
    private List<Getter> getters = new ArrayList<>();
    private List<Setter> setters = new ArrayList<>();
    private Config config;

    public BeanClass(Config config) {
        this.config = config;
    }

    @Override
    public Template transform() {
        this.name = StringUtils.firstLetterUpper(StringUtils.toCamelCase(super.getTable().getName(), config.getConnector()));
        this.bPackage = new Package(config.getSrcPackage() + PACKAGE_TAIL);

        for (Field field : super.getFields()) {
                JavaType javaType = TransformUtil.dataTypeToJavaType(field.getDateType());
                properties.add(new Property(StringUtils.toCamelCase(field.getName(), config.
                        getConnector()), Authority.PRIVATE, javaType));
                if(javaType.needImport()) {
                    imports.add(new Import(javaType.fullName()));
                }
        }

        for (Property property : properties) {
            getters.add(new Getter(property));
            setters.add(new Setter(property));
        }

        String path = config.getSrcPath() + File.separator + this.bPackage.getPath();
        super.setGenerateProerty(new GenerateProerty(path, StringUtils.firstLetterUpper(this.name) + ".java", BuiltInTemplate.MODEL_CLASS));
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Package getbPackage() {
        return bPackage;
    }

    public void setbPackage(Package bPackage) {
        this.bPackage = bPackage;
    }

    public List<Import> getImports() {
        return imports;
    }

    public void setImports(List<Import> imports) {
        this.imports = imports;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Getter> getGetters() {
        return getters;
    }

    public void setGetters(List<Getter> getters) {
        this.getters = getters;
    }

    public List<Setter> getSetters() {
        return setters;
    }

    public void setSetters(List<Setter> setters) {
        this.setters = setters;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
