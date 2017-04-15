<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${xml.tableName}">

    <resultMap id="${xml.beanMap}" type="${xml.beanType}">
    <#list xml.fields as field>
        <result column="${field.name}" property="${field.property}" />
    </#list>
    </resultMap>


    <insert id="add"  useGeneratedKeys="true" keyProperty="${xml.primaryKey.name}" parameterType="${xml.beanType}">
       INSERT
       INTO
          ${xml.tableName}
        (
          ${xml.primaryKey.name},
    <#list xml.fields as field>
       <#if field_has_next>
          ${field.name},
       <#else>
          ${field.name}
       </#if>
    </#list>
        )
      VALUES
        (
          ${r'#{'}${xml.primaryKey.property}${r'}'},
    <#list xml.fields as field>
        <#if field_has_next>
          ${r'#{'}${field.property}${r'}'},
        <#else>
          ${r'#{'}${field.property}${r'}'}
        </#if>
    </#list>
        )
    </insert>

    <update id="update"  parameterType="${xml.beanType}">
        UPDATE
          ${xml.tableName}
        SET
    <#list xml.fields as field>
        <#if field_has_next>
          ${field.name} = ${r'#{'}${field.property}${r'}'},
        <#else>
          ${field.name} = ${r'#{'}${field.property}${r'}'}
        </#if>
    </#list>
        WHERE
          ${xml.primaryKey.name} = ${r'#{'}${xml.primaryKey.property}${r'}'}
    </update>

    <update id="updatePropertys"  parameterType="${xml.beanType}">
        UPDATE
    ${xml.tableName}
        <trim prefix="set" suffixOverrides=",">
    <#list xml.fields as field>
          <if test="${field.property}!=null">
            ${field.name} = ${r'#{'}${field.property}${r'}'},
          </if>
    </#list>
       </trim>
        WHERE
         ${xml.primaryKey.name} = ${r'#{'}${xml.primaryKey.property}${r'}'}
    </update>

    <update id="del"  parameterType="java.lang.Long">
        DELETE
        FROM
          ${xml.tableName}
        WHERE
          ${xml.primaryKey.name} = ${r'#{'}${xml.primaryKey.property}${r'}'}
    </update>

    <select id="get" parameterType="java.lang.Long" resultMap="${xml.beanMap}">
        SELECT
          ${xml.primaryKey.name},
    <#list xml.fields as field>
        <#if field_has_next>
            ${field.name},
        <#else>
            ${field.name}
        </#if>
    </#list>
        FROM
            ${xml.tableName}
        WHERE
            ${xml.primaryKey.name!""} = ${r'#{'}value${r'}'}
    </select>
    <select id="getByPage" parameterType="java.util.Map" resultMap="${xml.beanMap}">
        SELECT
           ${xml.primaryKey.name},
    <#list xml.fields as field>
        <#if field_has_next>
           ${field.name},
        <#else>
           ${field.name}
        </#if>
    </#list>
        FROM
           ${xml.tableName}
        LIMIT ${r'#{'}skip${r'}'},${r'#{'}size${r'}'}
    </select>
    <select id="getTotal" resultType="java.lang.Long" >
        SELECT
          COUNT(1)
        FROM
          ${xml.tableName}
    </select>
</mapper>
