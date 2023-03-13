import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 롤케이크 크기
		int l = sc.nextInt();
		// 인원수
		int n = sc.nextInt();

		// 롤케이크 배열
		int[] cake = new int[l + 1];

		int[][] arr = new int[n][2];
		int exp = 0;
		int maxIdx = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			arr[i][0] = start;
			arr[i][1] = end;
			if (arr[exp][1] - arr[exp][0] < end - start) {
				exp = i;
			}
			int cnt = 0;
			for (int j = 0; j < end - start + 1; j++) {
				if (cake[start + j] == 0) {
					cake[start + j] = i + 1;
					cnt++;
				}
			}
			if (cnt > max) {
				max = cnt;
				maxIdx = i;
			}
		}
		System.out.println(exp + 1);
		System.out.println(maxIdx + 1);
	}
}
