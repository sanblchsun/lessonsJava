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
class C1 extends Thread {

NotifyAllExample notifyAllExample;

    C1(NotifyAllExample notifyAllExample){
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try{
            synchronized (notifyAllExample) {

                for (int i = 0; i < 5; i++) {

                    while (notifyAllExample.status != 3){
    notifyAllExample.wait();
}

                    System.out.print("C ");
                    notifyAllExample.status = 1;
                    notifyAllExample.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 3 :"+e.getMessage());
        }

    }
}
