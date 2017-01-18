package com.ellis.cg.code;


import com.ellis.tools.Tools;

/**
 * Created by fudw on 16-12-3.
 */
public class Getter extends Method {
    private Property property;

    @Override
    public String getName() {
        return Tools.getMethodName(property.getName());
    }

    public Getter(Property property) {
        this.property = property;
        this.setAuthority(Authority.PUBLIC);

        Parameter parameter = new Parameter();
        parameter.setName(property.getName());
        parameter.setType(property.getType());

        super.setParamterString(parameter.getType().name_() + " " + property.getName());
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
