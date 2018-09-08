
package convert10to01;

public class Convert10to01 {

    public static void main(String[] args) {
        System.out.println(getBinary(112));
    }
    
       static String getBinary(int num) {
           StringBuilder sb = new StringBuilder();
           
           for(int i=0; i<32;i++) {
               sb.append(((num&1)==1)?1:0);
               num>>=1;
               if(i==7 || i==15 || i==23) sb.append(' ');
           }
           sb.reverse();
           return sb.toString();
    } 
    
}
