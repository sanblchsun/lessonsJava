package playxo;

public class View {
    
    private View() {}
    
    public static void viewBoard() {
        System.out.println("(X1)(X2)(X3)");
        for (int i=0;i<Board.boardXO.length;++i) {
            if(i>0)System.out.println("-----------");
            for (int ii=0;ii<Board.boardXO[i].length;++ii) {
                if(ii>0) System.out.print("|");
                if(Board.boardXO[i][ii]!=null) System.out.print(" " + Board.boardXO[i][ii] + " ");
                else System.out.print("   ");
            }
            System.out.println("(Y" + (i+1) + ")");
        }        
        System.out.println("");
    }
}
