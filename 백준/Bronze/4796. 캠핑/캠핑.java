import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// l p v가 0이면 입력 종료
		// 휴가일수 / 캠핑장일수
		// 나눈 만큼 이용할 일수 더해
		// 나머지가 l보다 크면 l 더해
		// 나머지가 l보다 작으면 나머지 더하기

		// while문에 쓸 불린 만들기
		boolean a = true;
		// 케이스 넘버
		int caseNum = 0;
		// 조건을 만날 때까지만 반복해야 함
		while (a) {
			int l = sc.nextInt();
			int p = sc.nextInt();
			int v = sc.nextInt();

			if (l == 0 && p == 0 && v == 0) {
				break;
			}

			// 정답 출력을 위한 변수 생성
			int daySum = 0;

			if (p != 0) {
				// 타임마다 갈 수 있는 최대 일
				daySum = (v / p) * l;

				// 남은 날이 l보다 크거나 같으면 l출력
				if ((v % p) >= l) {
					daySum += l;
					// 남은 날이 l보다 작으면 남은 날 출력
				} else {
					daySum += (v % p);
				}
			}
			// 케이스번호 더해주기
			caseNum++;

			System.out.println("Case " + caseNum + ": " + daySum);
		}

	}
}
