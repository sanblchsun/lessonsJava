
package javaapplication32;


public class JavaApplication32 {

    private static void testIMyLambda(IMyLambda iml) {
        iml.iMetod();
    }
    public static void main(String[] args) {
        testIMyLambda(new IMyLambda() {
            @Override
            public void iMetod() {
                System.out.println("Hello");
            }
        });
        
        testIMyLambda(() -> System.out.println("Hello Lambda"));
    }    
}
