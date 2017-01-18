package com.ellis.cg.code;

/**
 * Created by fudw on 16-12-3.
 */
public enum Authority {
    PUBLIC("public") ,PRIVATE("private"), PROTECT ("protect");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Authority(String value) {
        this.value = value;
    }
}
