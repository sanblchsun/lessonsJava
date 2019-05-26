package lessons;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {
		
		int i[] = {-1,0,1};
		
		System.out.println("Введите число: ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int a = sc.nextInt();
			
			i[a] = 4/a;
			
			System.out.println(i[a]);
			
		}catch (ArithmeticException e) {
			
			System.out.println("Проихошла недопустима арифметическая операция");
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("Обращение по недопустимому индексу массива");
		
		}catch (InputMismatchException e) {
			
			System.out.println("несоответствие типа вводимого значения");
			
		}finally {
			System.out.println("ПРограмма закончилу свою работу");
		}
		

	}
}
