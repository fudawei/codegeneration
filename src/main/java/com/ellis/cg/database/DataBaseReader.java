package com.ellis.cg.database;

import com.ellis.tools.Config;
import com.ellis.tools.StringUtils;
import com.ellis.tools.TransformUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fudaw on 2016/12/6.
 */
public class DataBaseReader {

   private static final Logger logger = LoggerFactory.getLogger(DataBaseReader.class);

   private Config config;

   private Connection connection;

   public DataBaseReader setConfig(Config config) {
     this.config = config;
     return this;
   }

   public DataBaseReader init() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
     if (config == null) {
       throw new RuntimeException("please set config");
     }

     Class.forName(config.getDriverClass()).newInstance();
     this.connection = DriverManager.getConnection(
             config.getJdbcUrl(),
             config.getUserName(),
             config.getPassword());
     return this;
   }

   public List<String> fatchTables() {
    List<String> tables = new ArrayList<String>();

       try {
           String catalog = this.connection.getCatalog();
           DatabaseMetaData dbMetaData = this.connection.getMetaData();
           ResultSet tablesResultSet = dbMetaData.getTables(catalog,null,null,new String[]{"TABLE"});
           while(tablesResultSet.next()) {
               tables.add(tablesResultSet.getString("TABLE_NAME"));
           }
       } catch (SQLException e) {
          logger.error("please check your database config!" ,e);
       }
       return tables;
  }

   public List<Field> fetchTableFields(String tableName) {

    List<Field> fields = new ArrayList<Field>();
    try {
      DatabaseMetaData dbMetaData = this.connection.getMetaData();
      ResultSet colRet = dbMetaData.getColumns(null,"%", tableName,"%");

      while(colRet.next()) {
        String columu = colRet.getString("COLUMN_NAME");
        String dataType = colRet.getString("TYPE_NAME");
        int size = colRet.getInt("COLUMN_SIZE");
        fields.add(new Field(columu, StringUtils.toCamelCase(columu, config.getConnector()), TransformUtil.stringToDataType(dataType), size));
    }
    } catch (SQLException e) {
      logger.error("load table info error! please check your database config!", e);
    }
    return fields;
  }

   public List<PrimaryKey> fetchTablePKs(String tableName) {

    List<PrimaryKey> pklist = new ArrayList<PrimaryKey>();
    try {
      DatabaseMetaData dbMetaData = this.connection.getMetaData();
      ResultSet primaryKeyResultSet = dbMetaData.getPrimaryKeys(null,null,tableName);
      ResultSet colRet = dbMetaData.getColumns(null,"%", tableName,"%");
      while (primaryKeyResultSet.next()) {
        Short seq = primaryKeyResultSet.getShort("KEY_SEQ");
        String primaryKeyColumnName = primaryKeyResultSet.getString("COLUMN_NAME");
        pklist.add(PrimaryKey.create(
                primaryKeyColumnName,
                StringUtils.toCamelCase(primaryKeyColumnName, config.getConnector()),
                null,//StringUtils.stringToDataType(dataType),
                0,primaryKeyColumnName ,
                seq, null));
      }
    } catch (SQLException e) {
       logger.error("load table info error! please check your database config!", e);
    }
    return pklist;
  }
}
