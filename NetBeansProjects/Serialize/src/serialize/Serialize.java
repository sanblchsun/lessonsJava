
package serialize;


import java.io.*;
import java.util.*;

class Goods implements Serializable {
    private double price;
    private String title;
    private Date   data;
    private double dim[];

    public Date getData() {
        return data;
    }

    public Goods() {
    }

    public Goods(double price, String title, double[] dim) {
        this.price = price;
        this.title = title;
        this.data = new Date();
        this.dim = dim;
    }
}

class Box implements Comparable<Box>{
    int a,b;

    public Box(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return a+" "+ b;
    }

    @Override
    public int compareTo(Box box) {        
        return a*b-box.a*box.b;
    }
    
    
}

class Box3D extends Box {
    
    public Box3D(int a, int b) {
        super(a, b);
    }
    
}

public class Serialize {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
       // Goods g = new Goods(87, "tea", new double[]{30,15,22});
        //System.out.println(g.getData().toString());
//        FileOutputStream f = new FileOutputStream("data.txt");
//        ObjectOutputStream os = new ObjectOutputStream(f);
//        os.writeObject(g);
//          os.close();

          FileInputStream in = new FileInputStream("data.txt");
          ObjectInputStream inf = new ObjectInputStream(in);
          Goods gg = (Goods) inf.readObject();
          //System.out.println(gg.getData());
          inf.close();
          
          Formatter fmt = new Formatter();
          
          Calendar cl = Calendar.getInstance();
          
          fmt.format(Locale.FRANCE,"%tA %tB\n", cl,cl);
          fmt.format(new Locale("ar"),"%tA %tB\n", cl,cl);
          System.out.println(fmt);
          
          ArrayList<Double> list = new ArrayList<>();
          list.add(13.3);
//          System.out.println(list.get(0));
//          
//          System.out.println(max2("jjks","jjk"));

          Box b1 = new Box(3,1);
          Box b2 = new Box(5,2);
//          System.out.println(max2(b1,b2));

          Box3D d1= new Box3D(6, 7);
          Box3D d2= new Box3D(11, 4);
          System.out.println(max2(d1,d2));
    }
    //для java 8
//    public static<T extends Comparable<T>> T max2(T a, T b) {
//        T max = a;        
//        if(b.compareTo(a)>0) max = b;
//        return max;
//    }
    //для java 7
        public static<T extends Comparable<? super T>> T max2(T a, T b) {
        T max = a;        
        if(b.compareTo(a)>0) max = b;
        return max;
    }
    
}
