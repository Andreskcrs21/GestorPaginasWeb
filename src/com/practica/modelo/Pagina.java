
package com.practica.modelo;

import java.util.Date;

/**
 *
 * @author IdeaPad - S340
 */
public class Pagina {
    int idpagina;
    String nombre_pagina;
    String link_pagina;
    String tipo_pagina;
    String guardado_por;
    String recordatorio;
    Date fecha_registro;
    Date fecha_actualizacion;
    

    public int getIdpagina() {
        return idpagina;
    }

    public void setIdpagina(int idpagina) {
        this.idpagina = idpagina;
    }

    public String getNombre_pagina() {
        return nombre_pagina;
    }

    public void setNombre_pagina(String nombre_pagina) {
        this.nombre_pagina = nombre_pagina;
    }

    public String getLink_pagina() {
        return link_pagina;
    }

    public void setLink_pagina(String link_pagina) {
        this.link_pagina = link_pagina;
    }

    public String getTipo_pagina() {
        return tipo_pagina;
    }

    public void setTipo_pagina(String tipo_pagina) {
        this.tipo_pagina = tipo_pagina;
    }

    public String getGuardado_por() {
        return guardado_por;
    }

    public void setGuardado_por(String guardado_por) {
        this.guardado_por = guardado_por;
    }

    public String getRecordatorio() {
        return recordatorio;
    }

    public void setRecordatorio(String recordatorio) {
        this.recordatorio = recordatorio;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    @Override
    public String toString() {
        return "Pagina{" + "idpagina=" + idpagina + ", nombre_pagina=" + nombre_pagina + ", link_pagina=" + link_pagina + ", tipo_pagina=" + tipo_pagina + ", guardado_por=" + guardado_por + ", recordatorio=" + recordatorio + ", fecha_registro=" + fecha_registro + ", fecha_actualizacion=" + fecha_actualizacion + '}';
    }
    
    
    
    
    
    
}
