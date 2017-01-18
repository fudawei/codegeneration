package com.ellis.cg.code;

import java.util.List;

/**
 * Created by fudw on 16-12-3.
 */
public class Class {
    private String name;
    private Package package_;
    private List<Import> impors;
    private Class extendClass;
    private List<Interface> implementsInterfaces;
    private List<Property> properties;
    private List<Method> methods;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Import> getImpors() {
        return impors;
    }

    public void setImpors(List<Import> impors) {
        this.impors = impors;
    }

    public Class getExtendClass() {
        return extendClass;
    }

    public void setExtendClass(Class extendClass) {
        this.extendClass = extendClass;
    }

    public Package getPackage_() {
        return package_;
    }

    public void setPackage_(Package package_) {
        this.package_ = package_;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void setMethods(List<Method> methods) {
        this.methods = methods;
    }

    public List<Interface> getImplementsInterfaces() {
        return implementsInterfaces;
    }

    public void setImplementsInterfaces(List<Interface> implementsInterfaces) {
        this.implementsInterfaces = implementsInterfaces;
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + name + '\'' +
                ", package_=" + package_ +
                ", impors=" + impors +
                ", extendClass=" + extendClass +
                ", implementsInterfaces=" + implementsInterfaces +
                ", properties=" + properties +
                ", methods=" + methods +
                '}';
    }
}
