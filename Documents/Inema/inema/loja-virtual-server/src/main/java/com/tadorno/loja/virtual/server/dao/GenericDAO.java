package com.tadorno.loja.virtual.server.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



/**
 *
 * @author tulio
 * @param <T>
 * @param <ID>
 * 
 * Abstração genérica do repositório das entidades
 */
public abstract class GenericDAO<T, ID extends Serializable> {

    public GenericDAO() {
    }

    public abstract Class<T> getEntityClass();

    public T persist(T entidade, EntityManager manager) throws Exception{
        return manager.merge(entidade);
    }

    public void delete(T entidade, EntityManager manager) throws Exception {
        manager.remove(entidade);
    }

    public T selectFromId(ID id, EntityManager manager) throws Exception {
        return manager.find(getEntityClass(), id);
    }

    public List<T> select(EntityManager manager) throws Exception {
        TypedQuery<T> query = manager.createQuery("FROM " + getEntityClass().getName(), getEntityClass());
        return query.getResultList();
    }

    public List<T> select(int first, int max, String sortField, String sortOrder, Map<String, Object> filterMap, EntityManager manager) throws Exception {
        String filtros = montarStrFiltroDefault(filterMap);
        sortField = (sortField != null) ? (" ORDER BY " + sortField + " " + sortOrder) : "";
        String strQuery = "FROM " + getEntityClass().getName() + filtros + sortField;
        
        //Cria e executa a query:
        Query dynaQuery = manager.createQuery(strQuery).setFirstResult(first).setMaxResults(max);
        return dynaQuery.getResultList();
    }

    public List<T> select(String sql, EntityManager manager) throws Exception {
        TypedQuery<T> query =  manager.createQuery(sql, getEntityClass());
        return query.getResultList();
    }

    public Object[] selectSingle(String sql, EntityManager manager) throws Exception {
        Query query =  manager.createQuery(sql);
        try {
            return (Object[]) query.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public int getRow(EntityManager manager) throws Exception {
        Query dynaQuery = manager.createQuery("SELECT COUNT(*) FROM " + getEntityClass().getName());
        Long count = (Long) dynaQuery.getSingleResult();
        return Integer.parseInt(count.toString());
    }
    
    public int getRow(Map<String, Object> filters, EntityManager manager) throws Exception {
        String qryCount = "SELECT COUNT(*) FROM " + getEntityClass().getName();
        String filtros = montarStrFiltroDefault(filters);
        
        Query dynaQuery = manager.createQuery(qryCount + filtros);
        Long count = (Long) dynaQuery.getSingleResult();
        return Integer.parseInt(count.toString());
    }
    
    protected String montarStrFiltroDefault(Map<String, Object> filters) {
        String strFiltros = "";
        if (!filters.isEmpty()) {
            strFiltros = " WHERE ";
            for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
                String filterProperty = it.next();
                Object filterValue = filters.get(filterProperty);
                strFiltros += filterProperty + " LIKE '" + filterValue + "%'";
                if (it.hasNext()) {
                    strFiltros += " AND ";
                }
            }
        }
        return strFiltros;
    }
    
    public void manualFlush(EntityManager manager) {
        manager.flush();
    }
    
    public boolean isManaged(T entidade, EntityManager manager) {
        return manager.contains(entidade);
    }
    
}
