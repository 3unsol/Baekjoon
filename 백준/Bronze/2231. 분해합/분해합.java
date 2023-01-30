import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 1부터 다 더하고
		// 가장 먼저 n이 된 애들 구하기

		// n값을 받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// 자릿수 빼내기
		for (int i = 1; i < n; i++) {
			int num = i;
			int sum = num;
			while (num > 0) {
				sum += num % 10;
				num = num / 10;
			}
			// 먼저 sum이 나오면 출력
			if (sum == n) {
				System.out.println(i);
				return;
			}
			sc.close();
		}
		System.out.println(0);
	}

}