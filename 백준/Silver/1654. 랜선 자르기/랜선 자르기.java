import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 갖고 있는 랜선 개수
		int k = sc.nextInt();
		
		// 만들려는 랜선 개수
		int n = sc.nextInt();
		
		// 갖고 있는 랜선 중 가장 긴 값
		long max = 0;
		
		// 갖고 있는 랜선 길이
		int[] arr = new int[k];
		for (int i = 0; i < k; i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		// 0 ~ max + 1 만큼 탐색
		max++;
		
		// 이분탐색 시작
		long min = 0; // 탐색 길이 최솟값
		long mid = 0; // 중간값
		
		while(min < max) {
			mid = (max + min) / 2; // 범위 안에서 중간 길이 구하기
			long cnt = 0; // 만들어진 랜선 개수
			// 갖고 있는 랜선들 mid값으로 다 잘라보고 몇 개인지 세어보기
			for(int i = 0; i < arr.length; i++) {
				cnt += (arr[i] / mid);
			}
			// 이 중간값으로 잘랐을 때 개수가 N보다 작으면 최대 길이를 mid로 바꿔줌
			if(cnt < n) {
				max = mid;
			}
			// n보다 많으면 최소 길이를 늘린다.
			else {
				min = mid + 1;
			}
		}
		System.out.println(max - 1);
	}
}