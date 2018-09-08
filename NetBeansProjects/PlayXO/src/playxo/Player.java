package playxo;

public class Player {
    private String name = null;
    private Figure fig = null;
    private static int swich = 1;
    private static Player player;

    private static Player player1 = new Player("Sasha", Figure.X);
    private static Player player2 = new Player("Olia", Figure.O);
    
    private Player(String name, Figure fig) {
        this.name = name;
        this.fig = fig;
    }

    public static Player getNextInstance() {
        if(swich==1) {
            swich=2;
            player=player1;
            return player;
        }else {
            swich=1;
            player=player2;
            return player;
        }
    }
    
     public static Player getCurrentInstance() {
        return player;
    }
     
    public Figure getFig() {
        return fig;
    }
    
    public void printNamePlayer() {
        System.out.println(this.name);
    }
}
