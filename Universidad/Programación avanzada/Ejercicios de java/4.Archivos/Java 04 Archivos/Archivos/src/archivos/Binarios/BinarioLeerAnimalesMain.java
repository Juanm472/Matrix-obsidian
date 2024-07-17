package archivos.Binarios;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class BinarioLeerAnimalesMain {
	public static void main(String[] args) throws IOException{
                Path path = Paths.get("");
                Scanner sc = new Scanner(System.in);
                Animales a=null;
                ArrayList<Animales> animales = new ArrayList<Animales>();
                String directoryName = path.toAbsolutePath().toString();
                File carpeta = new File(directoryName+File.separator+"src/datos");
                
                System.out.println(carpeta.getAbsolutePath());
               
                try{
                    
                   //FileInputStream  archivo1 = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"algo.bin");
                    
                    FileInputStream  archivo = new FileInputStream(carpeta.getAbsolutePath()+File.separator+"Animales.bin");
                    
                    
                    ObjectInputStream obj1=new ObjectInputStream(archivo);
                    try{
                       a=(Animales)obj1.readObject();  //Aqui se lee el primer objeto                         
                    }
                    catch (EOFException e){
                       a=null;                        
                    }
                    while (a!=null){
                        animales.add(a);
                        //System.out.println (a.toString());
                        try{
                            a=(Animales)obj1.readObject();   //Aqui se lee desde el segundo objeto  en adelante                    
                        }
                        catch (EOFException e){
                            a=null;                        
                        }
                    }
                    
                    a =null;
                    Iterator it = animales.iterator();
                    
                    while(it.hasNext()){
                        a=(Animales)it.next();
                        System.out.println (a.toString());
                    }
                    
                    /*for (int i=0;i<animales.size();i++){
                        a=(Animales)animales.get(i);
                        obj1.writeObject(a);                    
                    }
                    */
                    obj1.close();
                    archivo.close();
                } catch (FileNotFoundException e) {
                    System.out.println("¡El archivo no existe!");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                };
         
	}
}
