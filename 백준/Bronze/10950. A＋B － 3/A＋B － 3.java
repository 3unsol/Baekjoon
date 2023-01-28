import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int num = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println(num+num2);
		}
		sc.close();
	}
}