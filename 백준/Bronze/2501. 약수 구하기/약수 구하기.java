import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// n, k입력값 받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 약수의 개수 세보기
		int[] arr = new int[n];
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				cnt++;
			}
		}
		// 약수 개수 만큼 배열 만들기
		int[] nArr = new int[cnt];
		int idx = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				nArr[idx] = i;
				idx++;
			}
		}
		// 약수의 개수가 k보다 작으면 0 출력
		if (nArr.length < k)
			System.out.println(0);
		// k번째 약수 출력하기
		else
			System.out.println(nArr[k - 1]);

	}
}