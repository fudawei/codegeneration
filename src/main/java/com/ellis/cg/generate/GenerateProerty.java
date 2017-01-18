package com.ellis.cg.generate;

import com.ellis.cg.templete.BuiltInTemplate;

/**
 * Created by fudw on 16-12-8.
 */
public class GenerateProerty {

    private String path;
    private String fileName;
    private BuiltInTemplate template;

    public GenerateProerty(String path, String fullFileName, BuiltInTemplate template) {
        this.path = path;
        this.fileName = fullFileName;
        this.template = template;
    }

    public String getPath() {
        return path;
    }

    public String getFileName() {
        return fileName;
    }

    public BuiltInTemplate getTemplate() {
        return template;
    }
}
