import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		int[] arr = new int[testCase];
		int ans = 0;
		for (int i = 0; i < testCase; i++) {
			arr[i] = sc.nextInt(); // 숫자
			boolean flag = true;
			for (int j = 2; j < arr[i]; j++) { // 2부터 n까지
				while (arr[i] % j == 0) { // n이 i로 나누어 떨어지면
					flag = false; // 출력한다
					arr[i] /= j; // n을 i로 나누어준다.
				}
			}
			if (arr[i] != 1 && flag) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
