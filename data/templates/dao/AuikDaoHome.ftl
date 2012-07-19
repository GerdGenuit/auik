/**
 * Copyright 2005-2011, Stadt Bielefeld
 *
 * This file is part of AUIK (Anlagen- und Indirekteinleiter-Kataster).
 *
 * AUIK is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 2 of the License, or (at your
 * option) any later version.
 *
 * AUIK is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public
 * License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with AUIK. If not, see <http://www.gnu.org/licenses/>.
 *
 * AUIK has been developed by Stadt Bielefeld and Intevation GmbH.
 */

// Generated ${date} by Hibernate Tools ${version}

${pojo.getPackageDeclaration()}

<#assign classbody>
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>/**
 * Home object for domain model class ${declarationName}.
 * @see ${pojo.getQualifiedDeclarationName()}
 * @author Hibernate Tools
 */
<#if ejb3>
@${pojo.importType("javax.ejb.Stateless")}
</#if>
public class ${declarationName} extends Abstract${declarationName} {

    /** Logging */
    private static final ${pojo.importType("de.bielefeld.umweltamt.aui.utils.AuikLogger")} log = ${pojo.importType("de.bielefeld.umweltamt.aui.utils.AuikLogger")}.getLogger();

<#if ejb3>
    @${pojo.importType("javax.persistence.PersistenceContext")} private ${pojo.importType("javax.persistence.EntityManager")} entityManager;
    
    public void persist(${declarationName} transientInstance) {
        log.debug("persisting ${declarationName} instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(${declarationName} persistentInstance) {
        log.debug("removing ${declarationName} instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public ${declarationName} merge(${declarationName} detachedInstance) {
        log.debug("merging ${declarationName} instance");
        try {
            ${declarationName} result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
<#if clazz.identifierProperty?has_content>    
    public ${declarationName} findById( ${pojo.getJavaTypeName(clazz.identifierProperty, jdk5)} id) {
        log.debug("getting ${declarationName} instance with id: " + id);
        try {
            ${declarationName} instance = entityManager.find(${pojo.getDeclarationName()}.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
</#if>
<#else>    
    public static ${declarationName} merge(${declarationName} detachedInstance) {
        return (${declarationName}) new ${pojo.importType("de.bielefeld.umweltamt.aui.utils.DatabaseAccess")}().merge(detachedInstance);
    }

    public static boolean delete(${declarationName} detachedInstance) {
        return new ${pojo.importType("de.bielefeld.umweltamt.aui.utils.DatabaseAccess")}().delete(detachedInstance);
    }
    
<#if clazz.identifierProperty?has_content>
    public ${declarationName} findById( ${c2j.getJavaTypeName(clazz.identifierProperty, jdk5)} id) {
        log.debug("getting ${declarationName} instance with id: " + id);
        ${declarationName} instance = (${declarationName})
        	new ${pojo.importType("de.bielefeld.umweltamt.aui.utils.DatabaseAccess")}().get(${declarationName}.class, id);
        if (instance == null) {
            log.debug("get successful, no instance found");
        } else {
            log.debug("get successful, instance found");
        }
        return instance;
    }
</#if>

    public static ${pojo.importType("java.util.List")}<${declarationName}> getAll() {
        String query = "FROM ${declarationName}";
        ${pojo.importType("java.util.List")}<?> objectList = new ${pojo.importType("de.bielefeld.umweltamt.aui.utils.DatabaseAccess")}().createQuery(query).list(); 
        ${pojo.importType("java.util.List")}<${declarationName}> resultList = new ${pojo.importType("java.util.ArrayList")}<${declarationName}>();
        ${declarationName} result = null;
        for (Object object : objectList) {
        	result = (${declarationName}) object;
        	resultList.add(result); 
        }
        return resultList;
    }

<#if false>
	// TODO: Fix this! This is generated - costumize!
	// TODO: Add some "_" into the return type!
    public ${declarationName} toServiceType() {
		// TODO: Add some "_" into the type!
        ${declarationName} serviceInstance = new ${declarationName}(
        	// TODO: Resort the fields to fit the service class!
        	// TODO: Change the first character of each field to upper case!
<#foreach field in pojo.getPropertiesForFullConstructor()> 
        	this.get${field.name}(),
</#foreach>
			// TODO: Remove the stupid last ","!
        );
        return serviceInstance;
	}
</#if>	    
<#foreach queryName in cfg.namedQueries.keySet()>
<#if queryName.startsWith(clazz.entityName + ".")>
<#assign methname = c2j.unqualify(queryName)>
<#assign params = cfg.namedQueries.get(queryName).parameterTypes><#assign argList = c2j.asFinderArgumentList(params, pojo)>
<#if jdk5 && methname.startsWith("find")>
    public ${pojo.importType("java.util.List")}<${declarationName}> ${methname}(${argList}) {
<#elseif methname.startsWith("count")>
    public int ${methname}(${argList}) {
<#else>
    public ${pojo.importType("java.util.List")} ${methname}(${argList}) {
</#if>
        ${pojo.importType("org.hibernate.Query")} query = sessionFactory.getCurrentSession()
                .getNamedQuery("${queryName}");
<#foreach param in params.keySet()>
<#if param.equals("maxResults")>
		query.setMaxResults(maxResults);
<#elseif param.equals("firstResult")>
        query.setFirstResult(firstResult);
<#else>
        query.setParameter("${param}", ${param});
</#if>
</#foreach>
<#if jdk5 && methname.startsWith("find")>
        return (List<${declarationName}>) query.list();
<#elseif methname.startsWith("count")>
        return ( (Integer) query.uniqueResult() ).intValue();
<#else>
        return query.list();
</#if>
    }
</#if>
</#foreach></#if>
}
</#assign>
${pojo.generateImports()}
${classbody}