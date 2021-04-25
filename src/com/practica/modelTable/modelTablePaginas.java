
package com.practica.modelTable;

import com.practica.modelo.Pagina;
import com.practica.vista.RegistroPaginas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author IdeaPad - S340
 */
public class modelTablePaginas extends AbstractTableModel{
    private String[] m_colNames = {"Nombre de la pagina", "Link", "Tipo de Pagina", "Guardado por", "Recordatorio"};
    private List<Pagina>paginas;
    private RegistroPaginas rPaginas;

    public modelTablePaginas(List<Pagina> paginas, RegistroPaginas rPaginas) {
        this.paginas = paginas;
        this.rPaginas = rPaginas;
    }
    @Override
    public int getRowCount() {
        return paginas.size();
    }

    @Override
    public int getColumnCount() {
        return m_colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pagina pagina = paginas.get(rowIndex);
        switch(columnIndex){
            case 0:
                return pagina.getNombre_pagina();
            case 1:
                return pagina.getLink_pagina();
            case 2:
                return pagina.getTipo_pagina();
            case 3:
                return pagina.getGuardado_por();
            case 4:
                return pagina.getRecordatorio();       
        
        
        }
        return new String();
    }

    @Override
    public String getColumnName(int column) {
        return m_colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        rPaginas.clickPaginas(paginas.get(rowIndex));
        return super.isCellEditable(rowIndex, columnIndex); 
    }
    public List<Pagina>getPaginas(){
        return paginas;
    
    }
    public void setPaginas(List<Pagina>paginas){
        this.paginas = paginas;
    
    }
    
    
    
    
}
