
package com.practica.utilidades;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.validator.UrlValidator;

/**
 *
 * @author IdeaPad - S340
 */
public class Utilidades {
     public String formatoFecha(Date fecha){
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(fecha);
    }
     public boolean validarLink(String url) {
        UrlValidator validar = new UrlValidator();

		if (validar.isValid(url)) {
			System.out.println("La URL es válida");
                        return true;
		} else {
			System.out.println("La URL no es válida");
                        return false;
		}
            
    }
        
     
    
}
