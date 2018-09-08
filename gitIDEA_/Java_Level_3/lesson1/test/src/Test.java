public class Test {
    public static void main(String[] args) {

        some(0);
    }

    static  int some(int n) {
        if (n<0) return  -1;
        return  some(n+1);
    }
}
