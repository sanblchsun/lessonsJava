package myfile;
import java.io.*;



public class MyFIle {

    public static void main(String[] args) {
        File file = new File(".");
        
        //String[] listFile = file.list(new FilterOne());
        
//        String[] listFilter = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return name.endsWith("xml");
//            }});

        String[] listFilter = file.list((dir,name) -> name.endsWith("xml"));
        for(String stt:listFilter) System.out.println(stt);
        
        System.out.println("------------------");
        
        String[] listFilter1 = file.list(MyFIle::f1245);
        for(String stt:listFilter1) System.out.println(stt);
        
    }
    private static boolean f1245(File f,String s) {
        File file = new File(s);       
        return file.isDirectory();
    }
    
    
}
