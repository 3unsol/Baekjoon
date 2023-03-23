import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] arr;
	static int n;
	static int m;
	static int[] result;
	static boolean[] isUsed;

	static void perm(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		int before = 0; // 이전 값을 저장할 것
		for (int i = 0; i < n; i++) {
			if (isUsed[i])
				continue;
			if (before != arr[i]) { // 이전 값과 다르면 실행
				result[k] = arr[i];
				isUsed[i] = true;
				before = arr[i]; // 이전 값에 넣어주기
				perm(k + 1);
				isUsed[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		result = new int[n];
		isUsed = new boolean[n];
		perm(0);
	}
}