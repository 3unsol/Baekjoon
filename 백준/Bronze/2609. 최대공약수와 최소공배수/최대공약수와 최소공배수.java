import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int gdc = gdc(a, b);
		System.out.println(gdc);
		int lcm = (a * b) / gdc;
		System.out.println(lcm);
	}

	/*
	 * 유클리드 호제법
	 * a > b 일 떄,
	 * n = a % b를 0이 될 때까지
	 * b 와 n을 계속 나눠준다.
	 * 
	 * 최소공배수 = 두 수의 곱 / gdc
	 */
	static int gdc(int a, int b) {
		int tmp = 0;
		while (b != 0) {
			tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
