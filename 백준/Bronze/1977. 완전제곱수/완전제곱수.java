import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// m, n을 차례대로 입력 받는다
		// 1부터 제곱해간다
		// 제곱한 수가 m 이상 n 이하
		// 제곱수들 어디 담아놓고...
		// 음...
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
        // 제곱수 숫자 세기
		int cnt = 0;
        // 제곱수 합 구하기
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if ((i * i) >= m && (i * i) <= n) {
				cnt++;
				sum += (i * i);
			}
		}
        // 제곱수 개수만큼 배열 만들기
		int[] arr = new int[cnt];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (m <= (i * i) && (i * i) <= n) {
				arr[idx] = (i * i);
				idx++;
			}
		}
        // 해당하는 제곱수가 없을 땐 -1 출력
		if (arr.length == 0) {
			System.out.println(-1);
            // 합, 최솟값 출력
		} else {
			System.out.println(sum);
			System.out.println(arr[0]);
		}
		sc.close();
	}
}