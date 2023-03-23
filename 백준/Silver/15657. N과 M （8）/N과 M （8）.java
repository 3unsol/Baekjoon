import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n;
	static int[] arr;
	static int m;
	static int[] result;

	static void perm(int start, int k) { // 스타트를 파라미터로 넣어주는 게 편하네..
		if (k == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < n; i++) {
			result[k] = arr[i];
			perm(i, k + 1); // 본인도 포함
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		result = new int[m];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr); // 얘를 해줘야 오름차순으로 나옴
		perm(0, 0);
	}
}