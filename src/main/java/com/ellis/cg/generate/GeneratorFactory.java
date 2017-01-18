package com.ellis.cg.generate;

import com.ellis.tools.Config;
import com.ellis.cg.database.DataBaseReader;
import com.ellis.cg.templete.TemplateFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by fudw on 16-12-6.
 */
public class GeneratorFactory {

    private static final Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    public static CodeGenerator create() {
        Config config  = new Config();
        DataBaseReader reader = new DataBaseReader();

        try {
            reader.setConfig(config).init();
        } catch (Exception e) {
            logger.error("init DataBaseReader error", e);
        }

        TemplateFactory builder = new TemplateFactory(reader, config);
        return new CodeGenerator(reader, builder, config);
    }
}
