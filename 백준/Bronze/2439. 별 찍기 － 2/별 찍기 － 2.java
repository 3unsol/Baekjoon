import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int num = 1;
		int blank = 0;
		for (int i = 0; i < input; i++) {
			for (int j = 0; j < input - num; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < num; j++) {
				System.out.print("*");
			}
			num++;
			System.out.println();
		}
	}

}