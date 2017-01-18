package com.ellis.cg.code;

/**
 * Created by fudw on 16-12-3.
 */
public class Package {

    private String value;

    private String path;

    public Package(String value) {
        this.value = value;
        this.path = value.replaceAll("\\.","/");
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
