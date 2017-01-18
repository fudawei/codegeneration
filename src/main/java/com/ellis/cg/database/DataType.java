package com.ellis.cg.database;

/**
 * Created by fudw on 16-12-3.
 */
public enum DataType {
    INT,
    BIGINT,
    SMALLINT,
    TINYINT,
    FLOAT,
    DOUBLE,
    DECIMAL,
    CHAR,
    VARCHAR,
    VARBINARY,
    BIT,
    DATE,
    TIME,
    TIMESTAMP,
    TEXT,
    BLOB;

    private static final String INT_INDEX = "INT";
    private static final String BIGINT_INDEX = "BIGINT";
    private static final String SMALLINT_INDEX = "SMALLINT";
    private static final String TINYINT_INDEX = "TINYINT";
    private static final String FLOAT_INDEX = "FLOAT";
    private static final String DOUBLE_INDEX = "DOUBLE";
    private static final String DECIMAL_INDEX = "DECIMAL";
    private static final String CHAR_INDEX = "CHAR";
    private static final String VARCHAR_INDEX = "VARCHAR";
    private static final String VARBINARY_INDEX = "VARBINARY";
    private static final String BIT_INDEX = "BIT";
    private static final String DATE_INDEX = "DATE";
    private static final String TIME_INDEX = "TIME";
    private static final String TIMESTAMP_INDEX = "TIMESTAMP";
    private static final String TEXT_INDEX = "TEXT";
    private static final String BLOB_INDEX = "BLOB";

  public static DataType getDataType(String dataType) {
    if (dataType == null) {
      return null;
    }

    dataType = dataType.toUpperCase();
    DataType resoult = null;
    switch (dataType) {
      case INT_INDEX : resoult = INT;
        break;
      case BIGINT_INDEX : resoult = BIGINT;
        break;
      case SMALLINT_INDEX : resoult = SMALLINT;
        break;
      case TINYINT_INDEX : resoult = TINYINT;
        break;
      case FLOAT_INDEX : resoult = FLOAT;
        break;
      case DOUBLE_INDEX : resoult = DOUBLE;
        break;
      case DECIMAL_INDEX : resoult = DECIMAL;
        break;
      case CHAR_INDEX : resoult = CHAR;
        break;
      case VARCHAR_INDEX : resoult = VARCHAR;
        break;
      case VARBINARY_INDEX : resoult = VARBINARY;
        break;
      case BIT_INDEX : resoult = BIT;
        break;
      case DATE_INDEX : resoult = DATE;
        break;
      case TIME_INDEX : resoult = TIME;
        break;
      case TIMESTAMP_INDEX : resoult = TIMESTAMP;
        break;
      case TEXT_INDEX : resoult = TEXT;
        break;
      case BLOB_INDEX : resoult = BLOB;
        break;
      default:
    }
    return resoult;
  }
}
