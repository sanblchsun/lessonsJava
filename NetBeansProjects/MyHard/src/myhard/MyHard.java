
package myhard;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyHard {

    public static void main(String[] args) throws IOException {
//        double[] d = {1.3,-11.2,34.1,44.2};
//        write(d,"data.txt");
//        read("data.txt");
            File dir = new File("C:\\Users\\JavaCode\\Documents\\NetBeansProjects\\MyHard");
            File[] filelist = dir.listFiles();
            for(File f: filelist) if(!f.isDirectory()) System.out.println(f.getName());
       
//            String enc = "UTF-16";
//            //String enc = "Cp1251";
//            FileInputStream str = new FileInputStream("unicode.txt");
//            BufferedReader br = new BufferedReader(new InputStreamReader(str,enc));
//            System.out.println(br.readLine());
//            System.out.println(br.readLine());
    }
    

    static void write(double[] d, String fname) {
        try(DataOutputStream dos =
            new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(fname,true)))) {
            dos.writeInt(d.length);
            for(double di:d) dos.writeDouble(di);
        }catch(IOException e){e.printStackTrace();}
    }

    static void read(String datatxt) {
        try(DataInputStream dis = 
            new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream(datatxt)))){ 
            int size = dis.readInt();
            System.out.println(size);
            for(int i=0;i<size;i++) System.out.println(dis.readDouble());
        }catch(IOException e) {e.printStackTrace();}
    }
    
}
