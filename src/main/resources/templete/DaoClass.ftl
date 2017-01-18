package ${dao.dPackage.value};

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

${dao.beanImport.importInstance}

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Created by fudw.
 */
@Component
public class ${dao.daoName} {

  private static final String NAME_SPACE = "${dao.nameSpace}.";

  @Resource(name = "communitySessionTemplate")
  private SqlSessionTemplate sqlSessionTemplate;

  /**
   * Add  ${dao.beanName}
   * @param ${dao.beanParameter} obj to update
   */
  public void add(${dao.beanName} ${dao.beanParameter}) {
    this.sqlSessionTemplate.insert(NAME_SPACE + "add", ${dao.beanParameter});
  }

  /**
   * Update ${dao.beanName}
   * @param ${dao.beanParameter} obj to update
   */
  public void update(${dao.beanName} ${dao.beanParameter}) {
    sqlSessionTemplate.update(NAME_SPACE + "update", ${dao.beanParameter});
  }

  /**
   *  Update ${dao.beanName}
   * @param ${dao.beanParameter} obj to update
   */
  public void updatePropertys(${dao.beanName} ${dao.beanParameter}) {
    sqlSessionTemplate.update(NAME_SPACE + "update", ${dao.beanParameter});
  }


  /**
   * Delete by pk
   * @param ${dao.primaryKey.name} pk
   */
  public void del(Long ${dao.primaryKey.name}) {
    sqlSessionTemplate.update(NAME_SPACE + "del", ${dao.primaryKey.name});
  }

  /**
   *  Get by pk
   * @param ${dao.primaryKey.name} pk
   * @return ${dao.beanName} obj
   */
  public ${dao.beanName} get(Long ${dao.primaryKey.name}) {
    return sqlSessionTemplate.selectOne(NAME_SPACE + "get", ${dao.primaryKey.name});
  }

  /**
   * Get data by page
   * @return obj list
   */
  public List<${dao.beanName}> getByPage(int skip, int size) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("skip", skip);
    map.put("size", size);
    return sqlSessionTemplate.selectList(NAME_SPACE + "getByPage", map);
  }

  /**
   *  Get data count
   * @return long
   */
  public long getTotal() {
    return sqlSessionTemplate.selectOne(NAME_SPACE + "getTotal");
  }
}
