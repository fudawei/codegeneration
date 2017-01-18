package com.ellis.cg.code;

/**
 * Created by fudw on 16-12-3.
 */
public class Property {

    private String name;
    private Authority authority;
    private JavaType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public JavaType getType() {
        return type;
    }

    public void setType(JavaType type) {
        this.type = type;
    }

    public Property(String name, Authority authority, JavaType type) {
        this.name = name;
        this.authority = authority;
        this.type = type;
    }

}
