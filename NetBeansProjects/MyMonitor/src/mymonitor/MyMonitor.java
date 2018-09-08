package mymonitor;

public class MyMonitor {

    public static void main(String[] args) throws Exception {
        Monitor mon = new Monitor(".");
        mon.addSub((x)->System.out.println(x));
        mon.start();
    }
    
}
