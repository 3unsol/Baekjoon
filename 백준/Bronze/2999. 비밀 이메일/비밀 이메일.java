import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 문자열
		String str = sc.next();
		// 문자열의 길이
		int n = str.length();

		// 행렬
		int r = 1;
		int c = 1;

		for (int i = 1; i < n; i++) {
			if (n % i == 0 && i <= n / i) {
				r = i;
				c = n / i;
			}
		}

		// 문자열을 새로 넣어줄 배열
		char[][] map = new char[r][c];
		// 배열 인덱스
		int idx = 0;
		// 새로운 배열에 행렬을 바꾸어 문자열을 넣어준다.
		for (int i = 0; i < c; i++) {
			for (int j = 0; j < r; j++) {
				map[j][i] = str.charAt(idx++);
			}
		}
		// 새로운 배열을 출력한다.
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(map[i][j]);
			}
		}
	}
}
