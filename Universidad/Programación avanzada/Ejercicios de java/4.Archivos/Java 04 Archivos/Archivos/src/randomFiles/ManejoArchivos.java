/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomFiles;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author user
 */
public class ManejoArchivos {
         
    
    static void adicionarEstudiante(Estudiante estudiante) {
        try{
            byte[] array=null;
            ByteArrayOutputStream estByte=null;
            ObjectOutputStream estOS=null;
            RandomAccessFile archivo = new RandomAccessFile("src/Estudiantes.dat", "rw");
            archivo.seek(archivo.length());
            estByte= new ByteArrayOutputStream();
            estOS = new ObjectOutputStream(estByte);
            estOS.writeObject(estudiante.toString());    
            estOS.close();
            array=estByte.toByteArray();
            archivo.write(array);
            archivo.close();
            
        }catch(FileNotFoundException ex){
            System.out.println ("No se pudo abrir el archivo:" + ex.getMessage());            
        }catch(IOException ex){
            System.out.println ("No se ubicar al final del archivo:" + ex.getMessage());            
        }
        
    }

    
    static void listarEstudiantes() {

        ByteArrayInputStream leer=null;
        ObjectInputStream entrada = null;        
        
        ByteArrayOutputStream estByte=null;
        ObjectOutputStream estOS=null;
        Estudiante e =  new Estudiante();
        byte[] array=null;
        try {
            RandomAccessFile archivo = new RandomAccessFile("src/Estudiantes.dat", "rw");
            array= new byte[ObjectSizeFetcher.getObjectSize(new Estudiante()) ];
            leer = new ByteArrayInputStream(array);
            entrada = new ObjectInputStream(leer);
            e=(Estudiante) entrada.readObject();
            System.out.println("Estuduante: "+ e.toString());
            
        } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    
    
}
