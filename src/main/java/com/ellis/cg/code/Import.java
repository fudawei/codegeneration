package com.ellis.cg.code;

/**
 * Created by fudw on 16-12-3.
 */
public class Import {

    private String importInstance;


    public Import(String classFullName) {
        this.importInstance = "import " + classFullName + ";";
    }

    public String getImportInstance() {
        return importInstance;
    }

    public void setImportInstance(String importInstance) {
        this.importInstance = importInstance;
    }
}
