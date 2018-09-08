
package javaapplication31;


public class Lambda {
    
    private static int testIMyLambda(int a,int b,IMyLambda iml) {
        return iml.iMetod(a, b);
    }
    public static void main(String[] args) {
        System.out.println(testIMyLambda(1,2,new IMyLambda() {
            @Override
            public int iMetod(int a, int b) {
                return a+b;
            }
        }));
        
        System.out.println(testIMyLambda(1,2, (int a, int b) -> a+b));
    }
}
