import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();

		// 인덱스를 사용하기 위해 n + 1 크기의 배열 생성
		int[] arr = new int[n + 1];

		// 공 던지는 횟수
		int cnt = 0;
		// 1번부터 시작
		arr[1] = 1;
		int idx = 1;

		// 공을 m번 받을 때까지
		while (arr[idx] != m) {
			// 홀수면
			if (arr[idx] % 2 == 1) {
				// l만큼 더하기
				idx = idx + l;
			} else {
				// 짝수면 l만큼 빼기
				idx = idx - l;
			}
			// idx가 n을 넘어가면
			if (idx > n) {
				// 나눈 나머지값 인덱스와 같음
				idx %= n;
				// idx가 음수면
			} else if (idx < 1) {
				// n을 더해준 값 인덱스와 같음
				idx += n;
			}
			// 공 받은 횟수 늘려주기
			arr[idx]++;
			// 공 주고받은 횟수 늘려주기
			cnt++;
		}
		System.out.println(cnt);
	}

}
