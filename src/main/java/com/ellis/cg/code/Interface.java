package com.ellis.cg.code;

import java.util.List;

/**
 * Created by fudw on 16-12-3.
 */
public class Interface {

    private String name;
    private List<Property> propertyList;
    private List<Method> methodList;

    public Interface(List<Property> propertyList, List<Method> methodList) {
        this.propertyList = propertyList;
        this.methodList = methodList;
    }
}
