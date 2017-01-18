package com.ellis.tools;

import com.ellis.cg.code.JavaType;
import com.ellis.cg.database.DataMapping;
import com.ellis.cg.database.DataType;

/**
 * Created by fudaw on 2016/12/6.
 */
public class TransformUtil {

  private static final String MYSQL_UNSIGNED = "UNSIGNED";
  public static JavaType dataTypeToJavaType(DataType dataType) {
    return DataMapping.getJavaTypeFromDataTypeString(dataType.name());
  }

  public static DataType stringToDataType(String dataType) {

    if (dataType != null && dataType.contains(MYSQL_UNSIGNED)) {
      dataType = dataType.replace(MYSQL_UNSIGNED, "").trim();
    }
    return DataType.getDataType(dataType);
  }
}
