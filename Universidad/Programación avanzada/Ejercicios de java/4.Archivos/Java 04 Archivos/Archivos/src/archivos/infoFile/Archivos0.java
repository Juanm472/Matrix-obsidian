package archivos.infoFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class Archivos0 {

    public static void main(String args[]) {

        System.out.println("Directorio de usuario con getProperty:" + System.getProperty("user.home"));
        System.out.println("Directorio de actual con geProperty:" + System.getProperty("user.dir"));

        Path path = Paths.get("");
        String directoryName = path.toAbsolutePath().toString();
        String relativePath = "";

        System.out.println("Directorio actual ruta absoluta= " + directoryName);
        relativePath = "." + File.separator; //El indicador .\ windows o ./ Linux o Unix dependiendo del sistema operativo, representa la carpeta o directorio actual
        System.out.println("Directorio actual ruta relativa= " + relativePath);

        File carpeta = new File(directoryName + File.separator + "datos" + File.separator + "c1" + File.separator + "c2" + File.separator + "c3");
        if (!carpeta.exists()) {
            //if (carpeta.mkdir()) {
            if (carpeta.mkdirs()) {
                System.out.println("Carpeta creada");
            } else {
                System.out.println("Error al crear archivo " + carpeta);
            }
        } else {
            System.out.println("Carpeta ya existe: " + carpeta);
        }

        File myFile = new File(carpeta, "datos.txt");
        System.out.println("Archivo existe: " + myFile.exists());
        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
            } catch (IOException e) {
                System.out.println("No se logro crear el archivo por lo siguiente:" + e.getMessage());
                // e.printStackTrace();
            }
        }

        System.out.println("hashCode           " + myFile.hashCode());
        try {
            //Adicionar texto al archivo
            PrintWriter pWriter = new PrintWriter(new FileWriter(myFile, true));
            pWriter.println("Este es un texto nuevo 2");
            pWriter.println("Que escribi en mi archivo");
            pWriter.close();
            System.out.println("Parent              " + myFile.getParent());
            System.out.println("ParentFile          " + myFile.getParentFile().getCanonicalPath());
            System.out.println("ParentFile.name     " + myFile.getParentFile().getName());
            System.out.println("getPath()           " + myFile.getPath());
            System.out.println("getAbsolutePath()   " + myFile.getAbsolutePath());
            System.out.println("getCanonicalPath()  " + myFile.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File(directoryName);
        System.out.println("Directorio  list :" + dir.getAbsolutePath());
        String list[] = dir.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println("Directorio list [" + (i + 1) + "]:" + list[i]);
        }

        System.out.println("Directorio List Files");
        File listFiles[] = dir.listFiles();
        for (int i = 0; i < list.length; i++) {
            System.out.println("Directorio Files listFiles [" + (i + 1) + "]:" + listFiles[i].getName() + " " + listFiles[i].isDirectory());
        }

        System.out.println("Es archivo? " + myFile.isFile());
        System.out.println("Esta oculto? " + myFile.isHidden());
        System.out.println("Se puede leer? " + myFile.canRead());
        System.out.println("Se puede escribir? " + myFile.canWrite());
        System.out.println("Tamaño:" + myFile.length() + " bytes");
       // recorrerDirectorios(directoryName + File.separator + "..", 1);

    }

    public static String padLeft(String s, int n) {
        return String.format("%" + n + "s", s);
    }

    public static void recorrerDirectorios(String ruta, int nivel) {
        System.out.println("Recorrido de: \n" + ruta);
        String relleno = padLeft(" ", nivel * 2);
        String tipo = "";
        File dir = new File(ruta);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                tipo = (files[i].isDirectory() == true) ? " Directorio" : " Archivo";
                System.out.println(relleno + files[i].getName() + " - " + tipo);
                if (files[i].isDirectory()) {
                    recorrerDirectorios(files[i].getAbsolutePath(), nivel + 1);
                }
            }
        }

    }
}
