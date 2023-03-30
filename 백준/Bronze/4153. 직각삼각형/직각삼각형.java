import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "wrong";
		int a, b, c = 0;
		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			if (a == 0 && b == 0 && c == 0)
				break;
			int tmp = 0;
			if (a > b && a > c) {
				tmp = c;
				c = a;
				a = tmp;
			}
			if (b > c && b > a) {
				tmp = c;
				c = b;
				b = tmp;
			}
			if ((a * a) + (b * b) == (c * c)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}
		}
	}
}
