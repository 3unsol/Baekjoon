import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 1부터 시작
		int sum = 1;
		// 범위도 1부터 시작
		int range = 1;

		while (true) {
			// 누적합이 n보다 크거나 같아지면
			if (sum >= n) {
				// 범위 출력
				System.out.println(range);
				break;
			} else {
				// 6의 배수 + 1까지는 범위가 같다.
				// 1 7 19 37 61 ...
				// 그거 넘어가면 범위 늘려줘야 함.
				sum = sum + (range * 6);
				range++;
			}
		}
	}
}
