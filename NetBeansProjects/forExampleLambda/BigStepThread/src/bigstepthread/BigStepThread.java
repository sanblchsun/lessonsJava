
package bigstepthread;

public class BigStepThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Старый вариант");
            }
        }).start();
    
        new Thread(()->System.out.println("Новый выриант")).start();
    }
    
}
