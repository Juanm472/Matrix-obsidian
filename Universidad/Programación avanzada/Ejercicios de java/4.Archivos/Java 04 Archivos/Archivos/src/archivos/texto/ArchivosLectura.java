package archivos.texto;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class ArchivosLectura {
	public static void main(String[] args) throws IOException{
                Path path = Paths.get("");
                Scanner sc = new Scanner(System.in);
                String directoryName = path.toAbsolutePath().toString();
                File carpeta = new File(directoryName+File.separator+"datos");
                try{
                    FileReader freader = new FileReader(carpeta.getAbsolutePath()+File.separator+"Data1.txt");
                    BufferedReader br = new BufferedReader(freader);
                    String s;
                    System.out.println("Contenido del archivo Data1.txt" );
                    System.out.println("\n\nLectura linea a linea\n");
                    while((s = br.readLine()) != null) {
                        System.out.println(s);
                    }
                   
                    /*s = br.readLine();
                    while(s!= null) {
                        System.out.println(s);
                        s = br.readLine();
                    }
                    */
                    br.close();
                    freader.close();
                    
                    /*Lectura caracter a caracter*/
                    System.out.println("\n\nLectura caracter a caracter\n");
                    freader = new FileReader(carpeta.getAbsolutePath()+File.separator+"Data1.txt");                    
                    br = new BufferedReader(freader);
                    int c=0;
                    
                   while ((c = br.read()) != -1) {
                        System.out.print((char)c);
                    }
                    
                   /* c=br.read();
                    while(c!=-1) {
                        System.out.print((char)c);
                        c = br.read();
                    }*/
                    
                    
                    
                    
                    
                    
                    
                }
                catch (FileNotFoundException ex){
                    System.out.println("Error de archivo: "+ex.getMessage());
                }
	}
}