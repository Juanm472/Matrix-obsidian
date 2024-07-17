package archivos.texto;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
public class ArchivosEscritura {
	public static void main(String[] args) throws IOException{
                Path path = Paths.get("");
                Scanner sc = new Scanner(System.in);
                String directoryName = path.toAbsolutePath().toString();
                File carpeta = new File(directoryName+File.separator+"datos");
                 if (!carpeta.exists()) {
                if (carpeta.mkdirs()) {
                    System.out.println("Carpeta creada");
                } else {
                    System.out.println("Error al crear carpeta " + carpeta);
                }
                }else{
                    System.out.println("Carpeta ya existe: "+carpeta);
                } 
                 
 
                 
                
		String s = "";
		System.out.println("Escriba las lineas y finalice con la palabra fin:");
		try {
                    FileWriter outFile = new FileWriter(carpeta.getAbsolutePath()+File.separator+"Data1.txt",true);
                    BufferedWriter bWriter = new BufferedWriter(outFile);
                    do{
                        s= sc.nextLine();
                        if (!s.toLowerCase().equals("fin"))
                            bWriter.write(s+"\n");
                    }while (!s.toLowerCase().equals("fin"));
                    bWriter.close();
                    outFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
              
	}
}