package com.ellis.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by fudaw on 2016/12/6.
 */
public class Config {

  protected static final Logger logger = LoggerFactory.getLogger(Config.class);

  private static final String configFile = "config.properties";

  private String userName;
  private String password;
  private String jdbcUrl;
  private String driverClass;

  private String srcPath;
  private String srcPackage;
  private List<String> tables;
  private char connector;



  private Config init(){
    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile);
    Properties pro = new Properties();

    try {
      pro.load(in);
      this.jdbcUrl = (String)pro.get("dataSource.generation.jdbcUrl");
      this.driverClass = (String)pro.get("dataSource.generation.driverClassName");
      this.userName = (String)pro.get("dataSource.generation.userName");
      this.password = (String)pro.get("dataSource.generation.password");
      this.srcPath = (String)pro.get("generation.srcPath");
      this.srcPackage = (String)pro.get("generation.srcPackage");
      String tablesStr = (String)pro.get("generation.tables");
      this.connector = ((String)pro.get("generation.connector")).charAt(0);

      this.tables = new ArrayList<String>();
      if (tablesStr != null &&  !"".equals(tablesStr)) {
        if (!tablesStr.equals("*")) {
          String[] tableArray = tablesStr.split(",");
          for (int i = 0; i < tableArray.length; i++) {
            tables.add(tableArray[i]);
          }
        }
      }

      logger.info("Load config info:");
      Enumeration en = pro.propertyNames();
      while(en.hasMoreElements()) {
        String key = en.nextElement().toString();
        logger.info("    [ "+key + " = " +pro.get(key)+" ]");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return this;
  }

  public Config() {
    init();
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getJdbcUrl() {
    return jdbcUrl;
  }

  public String getDriverClass() {
    return driverClass;
  }

  public String getSrcPath() {
    return srcPath;
  }

  public String getSrcPackage() {
    return srcPackage;
  }

  public List<String> getTables() {
    return tables;
  }

  public char getConnector() {
    return connector;
  }
}
