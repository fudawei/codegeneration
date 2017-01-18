package com.ellis.cg.generate;

import com.ellis.cg.templete.model.Template;
import com.ellis.tools.Config;
import com.ellis.cg.database.DataBaseReader;
import com.ellis.cg.templete.*;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.Class;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fudw on 16-12-3.
 */
public class CodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    private Configuration cfg;

    private Config config;

    private DataBaseReader dataBaseReader;

    private TemplateFactory templateBuilder;

    public CodeGenerator(DataBaseReader dataBaseReader, TemplateFactory templateBuilder, Config config) {
        try {
            init();
        } catch (Exception e) {
            logger.error("TempleteProcesser init error!", e);
        }
        this.config = config;
        this.dataBaseReader = dataBaseReader;
        this.templateBuilder = templateBuilder;
    }

    public CodeGenerator init() throws Exception {
        cfg = new Configuration(Configuration.VERSION_2_3_0);
        String templetePath = Thread.currentThread().getContextClassLoader().getResource("templete").getPath();
        cfg.setDirectoryForTemplateLoading(new File(templetePath));
        return this;
    }

    private void generate(Template template) {

        if (template == null) return;

        GenerateProerty property = template.getGenerateProerty();
        File dir = new File(property.getPath());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(property.getPath() + File.separator + property.getFileName());
        if (file.exists()) {
            file.delete();
        }

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(property.getTemplate().valueModleName(), template);
            cfg.getTemplate(property.getTemplate().templeteFile()).process(map, new FileWriter(file));
            logger.info("generation code : " + file.getAbsolutePath());
        } catch (TemplateException e) {
            logger.error("templete process error", e);
        } catch (IOException e) {
            logger.error("create or write data error", e);
        }
    }

    public void generate(Class<? extends Template> cls){
        List<String> tables = config.getTables();

        if (tables == null || tables.size() == 0) {
            tables = this.dataBaseReader.fatchTables();
        }

        for (String table : tables) {
            Template template = templateBuilder.create(table, cls);
            template = template.transform();
            this.generate(template);
        }
    }
}
