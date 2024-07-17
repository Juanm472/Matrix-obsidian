package archivos.Binarios;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class BinarioEscriibirAnimalesMain {
	public static void main(String[] args) throws IOException{
                Path path = Paths.get("");
                Scanner sc = new Scanner(System.in);
                String directoryName = path.toAbsolutePath().toString();
                File carpeta = new File(directoryName+File.separator+"src/datos");
                
                if (!carpeta.exists())
                    carpeta.mkdirs();
                
                File archivoDatos = new File(carpeta.getAbsolutePath()+File.separator+"Animales.bin");
                archivoDatos.createNewFile();
                System.out.println(archivoDatos.getAbsolutePath());
                boolean archivoExiste=false;
                if (archivoDatos.exists() && archivoDatos.length()>0){//Tener esto en cuenta para el uso de AppObjectOutputStream
                    System.out.println ("tam:"+archivoDatos.length());
                    archivoExiste=true;
                }
                try{
                    FileOutputStream  archivo1 = new FileOutputStream(carpeta.getAbsolutePath()+File.separator+"Animales1.bin",true);
                    
                    FileOutputStream  archivo = new FileOutputStream(carpeta.getAbsolutePath()+File.separator+"Animales.bin",true);
                    ArrayList<Animales> animales = new ArrayList<Animales>();
                    Animales an = new Animales ("insecto","saltamontes",false,0.5f,0.3f);
                    animales.add(an);
                    animales.add(new Animales ("mamifero","perro",false,20,15));
                    animales.add(new Animales ("reptil","cocodrilo",false,140,15));
                    ObjectOutputStream obj1=null;
                    //Validacion importante para manejo de archivos binarios
                    if (!archivoExiste )
                        obj1=new ObjectOutputStream(archivo);
                    else
                        obj1=new AppObjectOutputStream(archivo);
                    
                    
                    Animales a =null;
                    Iterator it = animales.iterator();
                    
                    while(it.hasNext()){
                        a=(Animales)it.next();
                        obj1.writeObject(a);                    
                    }
                    
                    //for (int i=0;i<animales.size();i++){
                    //    a=(Animales)animales.get(i);
                    //    obj1.writeObject(a);                    
                    //}
                    
                    obj1.close();
                    archivo.close();
                } catch (FileNotFoundException e) {
                    System.out.println("¡El archivo no existe!");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                };
                
                
                
                
         
	}
}