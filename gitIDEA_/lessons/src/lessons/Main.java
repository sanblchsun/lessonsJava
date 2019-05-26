package lessons;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] arg) {
		
		int i[] = {-1,0,1};
		
		System.out.println("������� �����: ");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int a = sc.nextInt();
			
			i[a] = 4/a;
			
			System.out.println(i[a]);
			
		}catch (ArithmeticException e) {
			
			System.out.println("��������� ����������� �������������� ��������");
			
		}catch (ArrayIndexOutOfBoundsException e) {
			
			System.out.println("��������� �� ������������� ������� �������");
		
		}catch (InputMismatchException e) {
			
			System.out.println("�������������� ���� ��������� ��������");
			
		}finally {
			System.out.println("��������� ��������� ���� ������");
		}
		

	}
}
