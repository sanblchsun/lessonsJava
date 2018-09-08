package mycounter;

import java.util.*;

public class MyCounter {

    public static void main(String[] args) {
        SimpleParser sp=new SimpleParser();  
        sp.Parse(args);
        
//        WordCounter wc=new WordCounter(null,null);
        WordCounter wc=new WordCounter(sp.getInFile(), null);
        wc.countWords();
        
        Set keys = wc.getWordsByVal().keySet();
        for(Object key:keys){
           KV kv = (KV)key; 
           System.out.println(kv.n+"   "+kv.s);
        }         
        
        
        //Set keys = wc.getWords().keySet();        
//        for(Object obj:keys){
//           String w=(String)obj; 
//           int n= (int)wc.getWords().get(w);
//           System.out.println(w+"   "+n);
//        }             
    }
}
