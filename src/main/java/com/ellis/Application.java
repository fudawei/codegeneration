package com.ellis;

import com.ellis.cg.templete.model.BeanClass;
import com.ellis.cg.templete.model.DaoClass;
import com.ellis.cg.templete.model.ServiceClass;
import com.ellis.cg.templete.model.SqlBeanXml;
import com.ellis.cg.generate.GeneratorFactory;
import com.ellis.cg.generate.CodeGenerator;

import static java.lang.Class.forName;


/**
 * Created by fudw on 16-12-3.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        CodeGenerator generator = GeneratorFactory.create();
        generator.generate(BeanClass.class);
        generator.generate(SqlBeanXml.class);
        generator.generate(DaoClass.class);
        generator.generate(ServiceClass.class);
    }


}
