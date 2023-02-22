import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 테스트 케이스 번호를 입력 받는다.
		int testCase = sc.nextInt();
		// 테스트 케이스만큼 실행
		for (int tc = 1; tc <= testCase; tc++) {
			// 시간을 입력 받는다.
			int h1 = sc.nextInt();
			int m1 = sc.nextInt();
			int h2 = sc.nextInt();
			int m2 = sc.nextInt();
			// 시간을 먼저 더해준다.
			int h3 = h1 + h2;
			// 분을 더해줄 변수
			int m3 = 0;
			// 분을 더한 값이 60 이상이면
			if (m1 + m2 >= 60) {
				// 시간을 늘려주고
				h3++;
				// 남은 분을 계산한다.
				m3 = (m1 + m2) - 60;
			// 그렇지 않으면 그냥 더한다.
			} else {
				m3 = m1 + m2;
			}
			// 시가 12를 넘으면 12를 빼준다.
			if (h3 > 12) {
				h3 -= 12;
			}
			// 출력
			System.out.printf("#%d %d %d\n", tc, h3, m3);
		}
	}
}