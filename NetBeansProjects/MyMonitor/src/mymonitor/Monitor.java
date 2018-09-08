package mymonitor;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class Monitor {
    String dir;
    ArrayList<IMonitor> list = new ArrayList<>();
    
    public Monitor(String dir) {
        this.dir = dir;
    }
    
    public void start() throws Exception {
        WatchService watch=
        FileSystems.getDefault().newWatchService();
        Path base = Paths.get(dir);
        base.register(watch,StandardWatchEventKinds.ENTRY_CREATE);   
    
        for(int i=1;i<=3;++i){
          WatchKey key = watch.take();
          for(WatchEvent ev : key.pollEvents())
//              System.out.println(ev.context()); 
              fireAdd(ev.context().toString());
          key.reset();
        }
        watch.close();
    }
    
    public void addSub(IMonitor client) {
        list.add(client);
    }

    protected void fireAdd(String file) {
        for(IMonitor client:list)
            client.add(file);
    }
}
