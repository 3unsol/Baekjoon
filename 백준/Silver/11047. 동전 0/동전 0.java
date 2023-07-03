import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 동전 종류
		int k = sc.nextInt(); // 가치 합
		int[] arr = new int[n]; // 동전 배열
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int cnt = 0; // 동전 개수
		for (int i = n - 1; i >= 0; i--) { // 뒤에서부터
			if (arr[i] <= k) { // k보다 같거나 작을 때만 (크면 안 봄)
				cnt += k / arr[i]; // 나눈 몫 cnt에 더해주고
				k = k % arr[i]; // 나눈 나머지로 k 갱신
			}
		}
		System.out.println(cnt);
	}
}