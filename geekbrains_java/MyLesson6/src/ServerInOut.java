import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerInOut {
    public static void main(String[] args) {
        ServerSocket serv = null ;
        Socket sock = null ;
        try {
            serv = new ServerSocket ( 8189 );
            System . out . println ( "Сервер запущен, ожидаем подключения..." );
            sock = serv . accept ();
            System . out . println ( "Клиент подключился" );


            Scanner sc = new Scanner ( sock . getInputStream ());
            PrintWriter pw = new PrintWriter ( sock . getOutputStream ());
            while ( true ) {
                String str = sc . nextLine ();
                if ( str . equals ( "end" )) break ;
                System.out.println("Клиент написал: " + str);

                pw . println ( "Сервер: я увидел - " + str );
                pw . flush ();
            }
        } catch ( IOException e ) {
            System . out . println ( "Ошибка инициализации сервера" );
        } finally {
            try {
                serv . close ();
                System.out.println("Server closed");
                sock.close();
            } catch ( IOException e ) {
                e . printStackTrace ();
            }
        }
    }
}
