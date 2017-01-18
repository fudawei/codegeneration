package com.ellis.cg.database;

import com.ellis.cg.code.JavaType;

import java.util.HashMap;
import java.util.Map;
/**
 * 数据库类型与Java类型对饮关系
 * Created by fudw on 16-12-5.
 */
public class DataMapping {

    private static Map<String, JavaType> dataTypeMap = new HashMap<String, JavaType>();

    static {
        dataTypeMap.put(DataType.INT.name(),JavaType.INTEGER);
        dataTypeMap.put(DataType.BIGINT.name(),JavaType.LONG);
        dataTypeMap.put(DataType.SMALLINT.name(),JavaType.SHORT);
        dataTypeMap.put(DataType.TINYINT.name(),JavaType.BYTE);
        dataTypeMap.put(DataType.FLOAT.name(),JavaType.FLOAT);
        dataTypeMap.put(DataType.DOUBLE.name(),JavaType.DOUBLE);
        dataTypeMap.put(DataType.DECIMAL.name(),JavaType.BIGDECIMAL);
        dataTypeMap.put(DataType.CHAR.name(),JavaType.CHARACTER);
        dataTypeMap.put(DataType.VARCHAR.name(), JavaType.STRING);
        dataTypeMap.put(DataType.VARBINARY.name(),JavaType.STRING);
        dataTypeMap.put(DataType.BIT.name(),JavaType.BOOLEAN);
        dataTypeMap.put(DataType.DATE.name(),JavaType.DATE);
        dataTypeMap.put(DataType.TIME.name(), JavaType.TIME);
        dataTypeMap.put(DataType.TIMESTAMP.name(),JavaType.TIMESTAMP);
        dataTypeMap.put(DataType.TEXT.name(),JavaType.STRING);
        dataTypeMap.put(DataType.BLOB.name(),JavaType.BLOB);
    }

    public static JavaType getJavaTypeFromDataTypeString(String dataType) {
        return dataTypeMap.get(dataType);
    }
}
