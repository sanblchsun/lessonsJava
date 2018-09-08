package playxo;

import java.util.function.Predicate;

public class Victory {

    private Victory() {}
    
    public static boolean status(Predicate<Figure> pre) {
        for(int i=0;i<Board.boardXO.length;++i){
            if(pre.test(Board.boardXO[i][0]) && pre.test(Board.boardXO[i][1]) && pre.test(Board.boardXO[i][2])) return true;    
            else if(pre.test(Board.boardXO[0][i]) && pre.test(Board.boardXO[1][i]) && pre.test(Board.boardXO[2][i])) return true;
        }  
        if(pre.test(Board.boardXO[1][1]) && (pre.test(Board.boardXO[0][0]) && pre.test(Board.boardXO[2][2]) || 
                (pre.test(Board.boardXO[0][2]) && pre.test(Board.boardXO[2][0])))) return true;
        return false;
    }
}
