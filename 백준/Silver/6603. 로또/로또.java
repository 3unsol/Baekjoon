import java.util.Scanner;

public class Main {
	
	static int n;
	static int[] arr;
	static boolean[] isUsed;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력값이 0이면 종료
		while(true) {
		n = sc.nextInt();
		if(n == 0) break;
		// 주어진 배열
		arr = new int[n];
		// 방문처리
		isUsed = new boolean[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// 조합
		comb(0, 0);
		System.out.println();
		}
	}
	
	// 조합 메서드
	// idx : 원래 배열에서 확인할 인덱스
	// k : 내가 앞으로 조합에 넣을 인덱스
	public static void comb(int idx, int k) {
		// 조합이 완성되면
		if(k == 6) {
			// 하나씩 프린트
			for(int i = 0; i < n; i++) {
				if(isUsed[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
			return;
		}
		
		// 배열 다 확인했으면 리턴
		if(idx == n) return;
		
		// 조합 만들기
		isUsed[idx] = true;
		comb(idx + 1, k + 1);
		isUsed[idx] = false;
		comb(idx + 1, k);
	}
}
