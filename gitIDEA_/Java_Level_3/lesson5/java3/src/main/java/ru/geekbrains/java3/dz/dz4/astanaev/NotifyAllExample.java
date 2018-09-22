/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Level3.HomeWork1.Thread;

/**
 *
 * @author 1
 */
public class NotifyAllExample {

    int status=1;
    public static void main(String[] args) {

        NotifyAllExample notifyAllExample = new NotifyAllExample();

        A1 a=new A1(notifyAllExample);
        B1 b=new B1(notifyAllExample);
        C1 c=new C1(notifyAllExample);

        a.start();
        b.start();
        c.start();
    }
}
