import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 숫자
		for (int i = 2; i <= n; i++) { // 2부터 n까지
			while (n % i == 0) { // n이 i로 나누어 떨어지면
				System.out.println(i); // 출력한다
				n /= i; // n을 i로 나누어준다.
			}
		}
	}
}
