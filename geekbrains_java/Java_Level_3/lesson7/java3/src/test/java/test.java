import static java.lang.System.*;

public class test {
    public static void main(String[] args) {

        System.out.println(max(3, 6, "s", "tr"));

    }

    private static  int max(int a, int b, String str) {
        int m = a;
        if (a>b) m = b;
        return  m;
    }

    private static  int max(int a, int b, String ... str) {
        int m = a;
        if (a>b) m = b;
        return  m;
    }
}
