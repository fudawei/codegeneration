package com.ellis.cg.code;


import java.util.List;

/**
 * Created by fudw on 16-12-3.
 */
public class Method {

    private Authority authority;
    private String name;
    private String paramterString;
    private List<Parameter> paramters;

    private Return return_;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Parameter> getParamters() {
        return paramters;
    }

    public void setParamters(List<Parameter> paramters) {
        this.paramters = paramters;
    }

    public Return getReturn_() {
        return return_;
    }

    public void setReturn_(Return return_) {
        this.return_ = return_;
    }

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }

    public String getParamterString() {
        return paramterString;
    }

    public void setParamterString(String paramterString) {
        this.paramterString = paramterString;
    }
}
