import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		// 개수 세줄 변수
		int cnt = 0;
		
		// n 넓이의 사각형을 만들 수 있는 조합
		for (int i = 1; i <= n; i++) {
			// 제곱근이 딱 반이니까 거기까지만 본다.
			// 근데 딱 떨어지는 경우도 있으니 포함해서 <=
			for (int j = 1; j <= Math.sqrt(i); j++) {
				// 제곱근 전까지의 숫자 중
				// i의 약수면 세어줌
				// i 약수면 순서쌍 곱했을 때 i가 나오니까
				if (i % j == 0) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
