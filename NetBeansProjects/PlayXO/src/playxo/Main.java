
package playxo;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        View.viewBoard();
        while (true) {
            System.out.print("Играет: ");
            Player.getNextInstance().printNamePlayer();
            Game.gameStep(Player.getCurrentInstance().getFig());
            View.viewBoard();
            if(Victory.status((t) -> t==Player.getCurrentInstance().getFig())) break;
        }
        System.out.print("Выиграл!!!!!!!!!!!!!!!! ");
        Player.getCurrentInstance().printNamePlayer();
    }
 }
