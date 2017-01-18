package com.ellis.cg.templete;

/**
 * Created by fudw on 16-12-6.
 */
public enum BuiltInTemplate {

    MODEL_CLASS {
        @Override
        public String templeteFile() {
            return "ModelClass.ftl";
        }

        @Override
        public String valueModleName() {
            return "model";
        }
    },
    DAO_CALSS {
        @Override
        public String templeteFile() {
            return "DaoClass.ftl";
        }

        @Override
        public String valueModleName() {
            return "dao";
        }
    },
    SERVICE_CLASS {
        @Override
        public String templeteFile() {
            return "ServiceClass.ftl";
        }

        @Override
        public String valueModleName() {
            return "service";
        }
    },
    SQL_MAP_BEAN_XML_CLASS {
        @Override
        public String templeteFile() {
            return "SqlMapBeanXml.ftl";
        }

        @Override
        public String valueModleName() {
            return "xml";
        }
    };

    public abstract String templeteFile();
    public abstract String valueModleName();

    private static final String MODEL_CLASS_FTL = "ModelClass.ftl";
    private static final String DAO_CALSS_FTL = "DaoClass.ftl";
    private static final String SERVICE_CLASS_FTL = "ServiceClass.ftl";
    private static final String SQL_MAP_BEAN_XML_CLASS_FTL = "SqlMapBeanXml.ftl";


    public static BuiltInTemplate get(String templeteStr) {
        if (templeteStr == null) {
            return null;
        }

        BuiltInTemplate builtInTemplete = null;
        switch (templeteStr) {
            case MODEL_CLASS_FTL : builtInTemplete = MODEL_CLASS;
                break;
            case DAO_CALSS_FTL : builtInTemplete = DAO_CALSS;
                break;
            case SERVICE_CLASS_FTL : builtInTemplete = SERVICE_CLASS;
                break;
            case SQL_MAP_BEAN_XML_CLASS_FTL : builtInTemplete = SQL_MAP_BEAN_XML_CLASS;
                break;
            default:
        }

        return builtInTemplete;
    }
}
