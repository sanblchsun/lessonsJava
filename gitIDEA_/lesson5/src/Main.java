import java.util.Arrays;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        Main main = new Main();
        float[] arr1 = main.createArray();
        main.printTimeArray(arr1);
        float[] arr2 = main.createArray();
        main.printTimeArrayThread(arr2);
    }

    private float[] createArray() {
        float[] arr = new float[size];
        for (int i=0;i<arr.length;i++) arr[i] = 1.0f;
        return arr;
    }

    private void printTimeArray(float[] arrMethod) {
        long a = System.currentTimeMillis();
        calculator(arrMethod);
        System.out.println("Время вычисления с одним потоком: " +
                (System.currentTimeMillis() - a));
    }

    private void printTimeArrayThread(float[] arrMethod) {
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        long a = System.currentTimeMillis();

        System.arraycopy(arrMethod, 0, a1, 0, h);
        System.arraycopy(arrMethod, h, a2, 0, h);

        Thread thread = new Thread(()-> calculator(a1));
        thread.start();

        calculator(a2);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, arrMethod, 0, h);
        System.arraycopy(a2, 0, arrMethod, h, h);
        
        System.out.println("Двухпоточный метод прошел за: " +
                (System.currentTimeMillis() - a));
    }

    private void calculator(float[] arrcalc) {
        for (int i=0;i<arrcalc.length;i++) {
            arrcalc[i] = (float) (arrcalc[i] * Math.sin(0.2f + i / 5)
                    * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
