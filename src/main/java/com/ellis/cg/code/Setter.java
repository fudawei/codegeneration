package com.ellis.cg.code;


import com.ellis.tools.Tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fudw on 16-12-3.
 */
public class Setter extends Method {

    private Property property;

    @Override
    public String getName() {
        return Tools.setMethodName(property.getName());
    }

    public Setter(Property property) {
        this.property = property;
        this.setAuthority(Authority.PUBLIC);
        Parameter parameter = new Parameter();
        parameter.setName(property.getName());
        parameter.setType(property.getType());

        List<Parameter> parameters = new ArrayList<Parameter>(0);
        super.setParamters(parameters);
        super.setParamterString(parameter.getType().name_() + " " + property.getName());
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
