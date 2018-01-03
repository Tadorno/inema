/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tadorno.loja.virtual.lazy;

import com.tadorno.loja.virtual.server.api.GenericEJB;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author tulio
 */
public abstract class GenericLazy<T> extends LazyDataModel<T> implements Serializable{
    
    abstract GenericEJB getEJB();
    
    @Override
    public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List<T> data = new ArrayList<>();
        try {
            String order = "ASC";
            if (sortOrder.equals(SortOrder.DESCENDING)) {
                order = "DESC";
            }
            data = getEJB().select(first, pageSize, sortField, order, filters);
            this.setRowCount(getEJB().getRow(filters));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }
    
    @Override
    public void setRowIndex(int rowIndex) {
        /*
    * The following is in ancestor (LazyDataModel): this.rowIndex =
    * rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
         */
        if (rowIndex == -1 || getPageSize() == 0) {
            super.setRowIndex(-1);
        } else {
            super.setRowIndex(rowIndex % getPageSize());
        }
    }
}
