package ${model.bPackage.value!""};

import java.io.Serializable;
<#list model.imports as imp>
${imp.importInstance}
</#list>

/**
 * Created by fudw.
 */
public class ${model.name} implements Serializable {

  private static final long serialVersionUID = -5051983450804074074L;

<#list model.properties as pro>
  ${pro.authority.value} ${pro.type.name_()} ${pro.name};
</#list>
<#list model.getters as getter>

  ${getter.authority.value} ${getter.property.type.name_()} ${getter.name}() {
    return this.${getter.property.name};
  }
</#list>
<#list model.setters as setter>

  ${setter.authority.value} void ${setter.name}(${setter.paramterString}) {
    this.${setter.property.name} = ${setter.property.name};
  }
</#list>
}
