import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 참외 개수
		int cnt = sc.nextInt();
		int[][] arr = new int[6][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 제일 큰 가로 세로 길이와 인덱스 찾기
		int maxW = 0;
		int maxH = 0;
		int wIdx = 0;
		int hIdx = 0;

		for (int i = 0; i < 6; i++) {
			if (arr[i][0] == 1 || arr[i][0] == 2) {
				if (arr[i][1] > maxW) {
					maxW = arr[i][1];
					wIdx = i;
				}
			} else if (arr[i][0] == 3 || arr[i][0] == 4) {
				if (arr[i][1] > maxH) {
					maxH = arr[i][1];
					hIdx = i;
				}
			}
		}

		// 빈 공간 크기 가로 세로
		int w = 0;
		int h = 0;

		// 인덱스가 0이면 1이랑 5
		if (wIdx == 0) {
			w = Math.abs(arr[5][1] - arr[1][1]);
			// 인덱스가 5면 4랑 0
		} else if (wIdx == 5) {
			w = Math.abs(arr[4][1] - arr[0][1]);
			// 둘다 아니면 앞뒤 차이 구하기
		} else {
			w = Math.abs(arr[wIdx - 1][1] - arr[wIdx + 1][1]);
		}

		// 세로도 똑같이
		if (hIdx == 0) {
			h = Math.abs(arr[5][1] - arr[1][1]);
		} else if (hIdx == 5) {
			h = Math.abs(arr[4][1] - arr[0][1]);
		} else {
			h = Math.abs(arr[hIdx - 1][1] - arr[hIdx + 1][1]);
		}

		// 맵 크기 구하기
		int map = (maxW * maxH) - (w * h);
		// 참외 개수
		System.out.println(map * cnt);
	}
}
