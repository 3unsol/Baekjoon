import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 학생 수
		int n = sc.nextInt();
		// 방에 들어갈 수 있는 최대 학생 수
		int k = sc.nextInt();

		// 1학년부터 6학년까지 남녀 배열
		int[][] arr = new int[7][2];

		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			// 성별마다 각 학년에 인원수 추가
			if (s == 0) {
				arr[sc.nextInt()][0]++;
			} else {
				arr[sc.nextInt()][1]++;
			}
		}

		// 방 개수
		int cnt = 0;

		for (int i = 0; i < 7; i++) {
			// 해당 학년에 학생이 없으면 걍 패스
			if (arr[i][0] == 0) {
				continue;
				// 학생 수가 k보다 작으면 1개 추가
			} else if (arr[i][0] <= k) {
				cnt++;
				// k로 똑 떨어지면 몫만큼 방 추가
			} else if (arr[i][0] % k == 0) {
				cnt += arr[i][0] / k;
				// k로 똑 안 떨어지면 몫에다가 방 하나 더 추가
			} else if (arr[i][0] % k != 0) {
				cnt += (arr[i][0] / k) + 1;
			}
		}

		// 남학생 이하동일
		for (int i = 0; i < 7; i++) {
			if (arr[i][1] == 0) {
				continue;
			} else if (arr[i][1] <= k) {
				cnt++;
			} else if (arr[i][1] % k == 0) {
				cnt += arr[i][1] / k;
			} else if (arr[i][1] % k != 0) {
				cnt += (arr[i][1] / k) + 1;
			}
		}
		System.out.println(cnt);
	}
}
