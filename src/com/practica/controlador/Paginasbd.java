
package com.practica.controlador;

import com.practica.conexionbd.Conexionbd;
import com.practica.modelo.Pagina;
import com.practica.utilidades.Utilidades;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IdeaPad - S340
 */
public class Paginasbd {
    public Utilidades utilidades;

    public Paginasbd() {
        utilidades = new Utilidades();
    }
    public boolean registrarPagina(Pagina pagina){
    
        boolean registrar = false;
        
        Statement stm = null;
        
        Connection con = null;
        String sql;
          
        
        sql = "INSERT INTO `paginas`.`pagina` (`nombre_pagina`,`Link_pagina`, `tipo_pagina`, `guardado_por`, `Recordatorio`, `fecha_registro`) VALUES ('"
                +pagina.getNombre_pagina()+"','"
                +pagina.getLink_pagina()+"','"
                +pagina.getTipo_pagina()+"','"
                +pagina.getGuardado_por()+"','"
                +pagina.getRecordatorio()+"','"
                +utilidades.formatoFecha(pagina.getFecha_registro())+"');";       
        
        try {
            Conexionbd  conexion = new Conexionbd();
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            registrar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
        return registrar;
    
        
    }
    public boolean editarPagina(Pagina pagina){
        boolean editar = false; // variable que retorna luego de realziar la accion
    
        Statement stm = null;  // interfaz de acceso a la base de datos
        
        Connection con = null; //coenxion con la base de datos
        
        String sql = "update paginas.pagina set nombre_pagina = '"+pagina.getNombre_pagina()+"', "
                + "Link_pagina = '"+pagina.getLink_pagina()+"', "
                + "tipo_pagina = '"+pagina.getTipo_pagina()+"', "
                + "guardado_por = '"+pagina.getGuardado_por()+"',"
                + "Recordatorio = '"+pagina.getRecordatorio()+"', "
                + "fecha_actualizacion = '"+utilidades.formatoFecha(pagina.getFecha_actualizacion())+"' where idpagina = '"+pagina.getIdpagina()+"';";
        try {
            Conexionbd  conexion = new Conexionbd();
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            editar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
    
    return editar;
    }
    public boolean eliminarpagina(Pagina pagina){
        boolean eliminar = false;
    
        Statement stm = null;
        
        Connection con = null;
        
         String sql = "delete from paginas.pagina where idpagina = '"+pagina.getIdpagina()+"'";
        try {
            Conexionbd  conexion = new Conexionbd();
            con = conexion.getConexion();
            stm = (Statement) con.createStatement();
            stm.execute(sql);
            eliminar = true;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: "+ e);
        }
    return eliminar;
    }
    public Pagina buscarpagina(String nombre_pagina){
        Connection co = null; //Sirve para conectar con a base de datos
        Statement stm = null; //Sirve para preparar los datos
        ResultSet rs = null;//Sentencia de JDBC para obtener valores de la base de datos.
        Pagina p = null;
        String sql = "SELECT * FROM paginas.pagina where nombre_pagina = "+nombre_pagina+";";
        
        try {
            co = new Conexionbd().getConexion();
            stm = (Statement) co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                p = new Pagina();
                p.setIdpagina(rs.getInt(1));
                p.setNombre_pagina(rs.getString(2));
                p.setLink_pagina(rs.getString(3));
                p.setTipo_pagina(rs.getString(4));
                p.setGuardado_por(rs.getString(5));
                p.setRecordatorio(rs.getString(6));
                p.setFecha_registro(rs.getDate(7));
                p.setFecha_actualizacion(rs.getDate(8));
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            //System.out.println("Error:"+ e.getMessage());
        }

        return p;
           
    }
    public List<Pagina> obtenerPaginas() {
        Connection co = null;
        Statement stm = null;
        //Sentencia de JDBC para obtener valores de la base de datos.
        ResultSet rs = null;
        String sql = "SELECT * FROM paginas.pagina;";
        List<Pagina> listaPaginas = new ArrayList<Pagina>();
        try {
            co = new Conexionbd().getConexion();
            stm = (Statement) co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Pagina p = new Pagina();
                p.setIdpagina(rs.getInt(1));
                p.setNombre_pagina(rs.getString(2));
                p.setLink_pagina(rs.getString(3));
                p.setTipo_pagina(rs.getString(4));
                p.setGuardado_por(rs.getString(5));
                p.setRecordatorio(rs.getString(6));
                p.setFecha_registro(rs.getDate(7));
                p.setFecha_actualizacion(rs.getDate(8));                
                listaPaginas.add(p);
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }
        return listaPaginas;
    }
    public List<Pagina> buscarNombre(String nombre_pagina){
    Connection co = null; //Sirve para conectar con a base de datos
        Statement stm = null; //Sirve para preparar los datos
        ResultSet rs = null;//Sentencia de JDBC para obtener valores de la base de datos.
        Pagina p = null;
        List<Pagina> paginasEncontradas = new ArrayList<>();
        
        String sql = "SELECT * FROM paginas.pagina where nombre_pagina like \"%"+nombre_pagina+"%\"";
        
        try {
            co = new Conexionbd().getConexion();
            stm = (Statement) co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                p = new Pagina();
                p.setIdpagina(rs.getInt(1));
                p.setNombre_pagina(rs.getString(2));
                p.setLink_pagina(rs.getString(3));
                p.setTipo_pagina(rs.getString(4));
                p.setGuardado_por(rs.getString(5));
                p.setRecordatorio(rs.getString(6));
                p.setFecha_registro(rs.getDate(7));
                p.setFecha_actualizacion(rs.getDate(8));
                
                paginasEncontradas.add(p);
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return  paginasEncontradas; 
    
    
    }
    public List<Pagina> buscarTipoPagina(String tipo_pagina){
    Connection co = null; //Sirve para conectar con a base de datos
        Statement stm = null; //Sirve para preparar los datos
        ResultSet rs = null;//Sentencia de JDBC para obtener valores de la base de datos.
        Pagina p = null;
        List<Pagina> paginasEncontradas = new ArrayList<>();
        
        String sql = "SELECT * FROM paginas.pagina where tipo_pagina like \"%"+tipo_pagina+"%\"";
        
        try {
            co = new Conexionbd().getConexion();
            stm = (Statement) co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                p = new Pagina();
                p.setIdpagina(rs.getInt(1));
                p.setNombre_pagina(rs.getString(2));
                p.setLink_pagina(rs.getString(3));
                p.setTipo_pagina(rs.getString(4));
                p.setGuardado_por(rs.getString(5));
                p.setRecordatorio(rs.getString(6));
                p.setFecha_registro(rs.getDate(7));
                p.setFecha_actualizacion(rs.getDate(8));
                
                paginasEncontradas.add(p);
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return  paginasEncontradas; 
    
    
    }
    public List<Pagina> buscarGuardadoPor(String guardado_por){
    Connection co = null; //Sirve para conectar con a base de datos
        Statement stm = null; //Sirve para preparar los datos
        ResultSet rs = null;//Sentencia de JDBC para obtener valores de la base de datos.
        Pagina p = null;
        List<Pagina> paginasEncontradas = new ArrayList<>();
        
        String sql = "SELECT * FROM paginas.pagina where guardado_por like \"%"+guardado_por+"%\"";
        
        try {
            co = new Conexionbd().getConexion();
            stm = (Statement) co.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                p = new Pagina();
                p.setIdpagina(rs.getInt(1));
                p.setNombre_pagina(rs.getString(2));
                p.setLink_pagina(rs.getString(3));
                p.setTipo_pagina(rs.getString(4));
                p.setGuardado_por(rs.getString(5));
                p.setRecordatorio(rs.getString(6));
                p.setFecha_registro(rs.getDate(7));
                p.setFecha_actualizacion(rs.getDate(8));
                
                paginasEncontradas.add(p);
                
            }
            stm.close();
            rs.close();
            co.close();
        } catch (SQLException e) {
            System.out.println("Error:"+ e.getMessage());
        }

        return  paginasEncontradas; 
    
    
    }
    
}
