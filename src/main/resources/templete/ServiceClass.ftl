package ${service.sPackage.value};


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

${service.beanImport.importInstance}
${service.daoImport.importInstance}

import java.util.ArrayList;
import java.util.List;

/**
*  Created by fudw.
*/
@Component
public class ${service.serviceName} {

  @Autowired
  private ${service.daoName} ${service.daoParameter};

  /**
   * Add  ${service.beanName}
   * @param ${service.beanParameter} obj to update
   */
  public void add(${service.beanName} ${service.beanParameter}) {
    this.${service.daoParameter}.add(${service.beanParameter});
  }

  /**
   * Update ${service.beanName}
   * @param ${service.beanParameter} obj to update
   */
  public void update(${service.beanName} ${service.beanParameter}) {
    this.${service.daoParameter}.update(${service.beanParameter});
  }

  /**
   *  Update ${service.beanName}
   * @param ${service.beanParameter} obj to update
   */
  public void updatePropertys(${service.beanName} ${service.beanParameter}) {
    this.${service.daoParameter}.updatePropertys(${service.beanParameter});
  }

  /**
   * Delete by pk
   * @param ${service.primaryKey.name} pk
   */
  public void del(Long ${service.primaryKey.name}) {
    this.${service.daoParameter}.del(${service.primaryKey.name});
  }

  /**
   *  Get by pk
   * @param ${service.primaryKey.name} pk
   * @return ${service.beanName} obj
   */
  public ${service.beanName} get(Long ${service.primaryKey.name}) {
    return this.${service.daoParameter}.get(${service.primaryKey.name});
  }

  /**
   * Get data by page
   * @return obj list
   */
  public List<${service.beanName}> getByPage(int skip, int size) {
    return this.${service.daoParameter}.getByPage(skip, size);
}

  /**
   *  Get data count
   * @return long
   */
  public long getTotal() {
    return this.${service.daoParameter}.getTotal();
  }
}
