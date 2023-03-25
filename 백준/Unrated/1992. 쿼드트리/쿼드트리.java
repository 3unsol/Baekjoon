import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author sweetandsourkiss
 * @category boj 1992
 *
 */
public class Main {
	// 표준 입력
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// 영상의 크기
	static int N;
	// 영상의 정보
	static boolean[][] map;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];
		// sb로 합치기
		sb = new StringBuilder();
		// 쪼개진 정도를 가져가기 위한 변수
		int depth = N;
		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split("");
			for (int c = 0; c < N; c++) {
				// 1은 true(boolean 초기값이 false이므로 0은 생략 가능)
				if (str[c].equals("1")) {
					map[r][c] = true;
				}
			}
		}
		// 쪼개기
		split(0, 0, depth);
		// sb출력
		System.out.println(sb.toString());
	}

	// r, c = 현재 위치
	// depth = 현재 쪼개진 정도
	private static void split(int r, int c, int depth) {
		// 기준이 될 가장 왼쪽 위 좌표 값
		boolean standard = map[r][c];
		// 현재 쪼개진 정도만큼 확인해서 모든 좌표가 동일한가?
		for (int i = r; i < r + depth; i++) {
			for (int j = c; j < c + depth; j++) {
				// standard와 다르면 쪼개기
				if (map[i][j] != standard) {
					// 4분의 1로 쪼개기
					sb.append('(');
					// 왼쪽위 오른쪽위 왼쪽아래 오른쪽아래
					split(r, c, depth / 2);
					split(r, c + depth / 2, depth / 2);
					split(r + depth / 2, c, depth / 2);
					split(r + depth / 2, c + depth / 2, depth / 2);
					sb.append(')');
					return;
				}
			}
		}
		// 여기 온거면 모든 좌표가 같은 것!
		// standard에 따라 sb에 붙여주자
		if (standard)
			sb.append('1');
		else
			sb.append('0');
	}

}
