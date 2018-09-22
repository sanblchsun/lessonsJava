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

class B1 extends Thread {

     NotifyAllExample notifyAllExample;

    B1(NotifyAllExample notifyAllExample){
        this.notifyAllExample = notifyAllExample;
    }

    @Override
    public void run() {

        try{
            synchronized (notifyAllExample) {

                for (int i = 0; i < 5; i++) {

                    while (notifyAllExample.status != 2){
    notifyAllExample.wait();
}

                    System.out.print("B ");
                    notifyAllExample.status = 3;
                    notifyAllExample.notifyAll();
                }

            }
        }catch (Exception e) {
            System.out.println("Exception 2 :"+e.getMessage());
        }

    }
}
