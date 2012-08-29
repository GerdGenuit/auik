<#include "Copyright.ftl"/>

// Generated by Hibernate Tools ${version}

${pojo.getPackageDeclaration()}

<#assign classbody>
<#include "PojoTypeDeclaration.ftl"/> {

<#if !pojo.isInterface()>
<#include "PojoFields.ftl"/>
<#include "PojoConstructors.ftl"/>
<#include "PojoPropertyAccessors.ftl"/>
<#include "PojoToString.ftl"/>
<#include "PojoEqualsHashcode.ftl"/>
<#else>
<#include "PojoInterfacePropertyAccessors.ftl"/>
</#if>
<#include "PojoExtraClassCode.ftl"/>
<#include "DatabaseAccess.ftl"/>
    /* Custom code goes below here! */

<#include "Tipi.ftl"/>
}
</#assign>
${pojo.generateImports()}
${classbody}