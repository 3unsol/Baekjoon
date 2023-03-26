import java.util.Scanner;

public class Main {

	static int n; // 숫자 개수
	static int[] number; // 숫자 배열
	static int[] oper; // 연산자 배열
	static int max; // 최대값
	static int min; // 최소값

	static void perm(int num, int k) { // 순열? 만들어보자

		if (k == n) { // 숫자를 다 쓰면
			max = Math.max(max, num); // 최대값이랑 만든 값이랑 비교
			min = Math.min(min, num); // 최소값이랑 만든 값이랑 비교
			return;
		}

		for (int i = 0; i < 4; i++) { // 연산자 4개
			if (oper[i] > 0) { // 연산자 배열 인덱스에 숫자가 있을 때만
				oper[i]--; // 하나 꺼내 쓸 거니까 줄여줌
				switch (i) { // 인덱스가
				case 0: // 0이면 지금 num에 다음 숫자 더해주고 그 값이랑 다다음 숫자랑 계산
					perm(num + number[k], k + 1);
					break;
				case 1: // 1이면 빼주고
					perm(num - number[k], k + 1);
					break;
				case 2: // 2면 곱해주고
					perm(num * number[k], k + 1);
					break;
				case 3: // 3이면 나눠줌
					perm(num / number[k], k + 1);
					break;
				}
				oper[i]++; // 계산 끝났으면 다음을 위해 연산자 다시 돌려놓기
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		number = new int[n];
		oper = new int[4];
		for (int i = 0; i < n; i++) {
			number[i] = sc.nextInt();
		}
		for (int i = 0; i < 4; i++) {
			oper[i] = sc.nextInt();
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		perm(number[0], 1); // 0번 인덱스 값이랑 1번 인덱스부터 시작
		System.out.println(max);
		System.out.println(min);
	}
}
