import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// n장의 카드와 숫자 m값 받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// n개의 숫자 배열에 입력 받기
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 세 장의 카드 모든 조합의 합 구하기
		int sum = 0;
		int mmm = 0;
		for (int k = 0; k < n - 2; k++) {
			for (int j = k + 1; j < n - 1; j++) {
				for (int i = j + 1; i < n; i++) {
					sum = arr[k] + arr[j] + arr[i];
					if (sum <= m) {
						mmm = Math.max(mmm, sum);
					}
				}
			}
		}
		// m에 가까운 합 출력하기
		System.out.println(mmm);

	}
}