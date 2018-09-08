
package myfile;

public class FilterOne implements java.io.FilenameFilter{
    @Override
    public boolean accept(java.io.File dir, String name) {
        return name.startsWith("b");
    }
    
}
