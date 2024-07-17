/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos.Binarios;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 *
 * @author user
 */
public class AppObjectOutputStream extends ObjectOutputStream {

    public AppObjectOutputStream(OutputStream out) throws IOException{
            super(out);
        
    }
  protected void writeStreamHeader() throws IOException {
    // Esto evita escribir el encabezado del archivo, si el archivo ya tiene registros
  }

}
