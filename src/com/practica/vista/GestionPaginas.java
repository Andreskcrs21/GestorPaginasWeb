
package com.practica.vista;

import com.practica.modelo.Pagina;
import com.practica.utilidades.Utilidades;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author IdeaPad - S340
 */
public class GestionPaginas {
    private JTextField txtnombrepagina;
    private JTextField txtlinkpagina;
    private JTextField txtguardadopor;
    private JTextArea  txtrecordatorio;
    private JComboBox   comboboxtipopagina;
    private Utilidades utilidades;
    private JFrame frameRegistroPaginas;

    public GestionPaginas(JTextField txtnombrepagina, JTextField txtlinkpagina, JTextField txtguardadopor, JTextArea txtrecordatorio, JComboBox comboboxtipopagina, Utilidades utilidades, JFrame frameRegistroPaginas) {
        this.txtnombrepagina = txtnombrepagina;
        this.txtlinkpagina = txtlinkpagina;
        this.txtguardadopor = txtguardadopor;
        this.txtrecordatorio = txtrecordatorio;
        this.comboboxtipopagina = comboboxtipopagina;
        this.utilidades = utilidades;
        this.frameRegistroPaginas = frameRegistroPaginas;
    }

   

    public JTextField getTxtnombrepagina() {
        return txtnombrepagina;
    }

    public void setTxtnombrepagina(JTextField txtnombrepagina) {
        this.txtnombrepagina = txtnombrepagina;
    }

    public JTextField getTxtlinkpagina() {
        return txtlinkpagina;
    }

    public void setTxtlinkpagina(JTextField txtlinkpagina) {
        this.txtlinkpagina = txtlinkpagina;
    }

    public JTextField getTxtguardadopor() {
        return txtguardadopor;
    }

    public void setTxtguardadopor(JTextField txtguardadopor) {
        this.txtguardadopor = txtguardadopor;
    }

    public JTextArea getTxtrecordatorio() {
        return txtrecordatorio;
    }

    public void setTxtrecordatorio(JTextArea txtrecordatorio) {
        this.txtrecordatorio = txtrecordatorio;
    }

    public JComboBox getComboboxtipopagina() {
        return comboboxtipopagina;
    }

    public void setComboboxtipopagina(JComboBox comboboxtipopagina) {
        this.comboboxtipopagina = comboboxtipopagina;
    }

    public Utilidades getUtilidades() {
        return utilidades;
    }

    public void setUtilidades(Utilidades utilidades) {
        this.utilidades = utilidades;
    }

    public JFrame getFrameRegistroPaginas() {
        return frameRegistroPaginas;
    }

    public void setFrameRegistroPaginas(JFrame frameRegistroPaginas) {
        this.frameRegistroPaginas = frameRegistroPaginas;
    }

    

    void limpiarcampos(){
       txtnombrepagina.setText("");
       txtlinkpagina.setText("");
       txtguardadopor.setText("");
       txtrecordatorio.setText("");
       comboboxtipopagina.setSelectedIndex(0);
   
    }
    public Pagina guardarEditar(boolean isEditar){
        if (txtnombrepagina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameRegistroPaginas, "El campo Nombre de Pagina no tiene datos","ERROR",JOptionPane.ERROR_MESSAGE);
            txtnombrepagina.requestFocus();
            return null;
        }if (txtlinkpagina.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameRegistroPaginas, "El campo Link de Pagina no tiene datos","ERROR",JOptionPane.ERROR_MESSAGE);
            txtnombrepagina.requestFocus();
            return null;
        }if (comboboxtipopagina.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(frameRegistroPaginas, "Seleccione un tipo de pagina","ERROR",JOptionPane.ERROR_MESSAGE);
            comboboxtipopagina.requestFocus();
            return null;
        }if (txtguardadopor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frameRegistroPaginas, "El campo guardado por no contiene datos","ERROR",JOptionPane.ERROR_MESSAGE);
            txtguardadopor.requestFocus();
            return null;
        }        
        Pagina pagina = new Pagina();
        pagina.setNombre_pagina(txtnombrepagina.getText());
        pagina.setLink_pagina(txtlinkpagina.getText());
        pagina.setTipo_pagina(comboboxtipopagina.getSelectedItem().toString());
        pagina.setGuardado_por(txtguardadopor.getText());
        pagina.setRecordatorio(txtrecordatorio.getText());
        if (isEditar) {
            pagina.setFecha_actualizacion(new Date());
        }else{
            pagina.setFecha_registro(new Date());
        }
        
        return pagina;
       
       
       
    }
    
    
    
}
