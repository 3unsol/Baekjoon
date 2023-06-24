import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int n, m, b, max;
	static int[][] map;
	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		max = 0;
		// 입력값 받으면서 최댓값 찾기
		for (int r = 0; r < n; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < m; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (max < map[r][c]) {
					max = map[r][c];
				}
			}
		}
		// 최소시간, 최대높이
		int minTime = Integer.MAX_VALUE;
		int maxHeight = 0;
		// 0부터 max까지 공사해보기
		for (int i = 0; i <= max; i++) {
			result = mine(i);
			if (minTime > result[0]) {
				minTime = result[0];
				maxHeight = result[1];
			} else if (minTime == result[0] && maxHeight < result[1]) {
				minTime = result[0];
				maxHeight = result[1];
			}
		}
		for (int i = 0; i <= max; i++) {

		}
		System.out.println(minTime + " " + maxHeight);
	}

	public static int[] mine(int height) {
		int tmpTime = 0;
		int tmpBox = b;
		// 모든 블럭 돌면서 지금 만들려는 높이랑 비교해서 깎고 쌓기
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				// 지금 만들려는 높이와 같다면 넘기기
				if (height == map[r][c]) {
					continue;
				}
				// 지금 만들려는 높이보다 높으면 깎기
				else if (height < map[r][c]) {
					tmpTime += (map[r][c] - height) * 2;
					tmpBox += (map[r][c] - height);
				}
				// 지금 만들려는 높이보다 낮으면 쌓기
				else if (height > map[r][c]) {
					tmpTime += (height - map[r][c]);
					tmpBox -= (height - map[r][c]);
				}
			}
		}
		// 인벤토리가 음수라면 제외할 생각으로 시간을 최댓값으로 지정
		// result[0] : 걸린 시간
		// result[1] : 만들려는 높이
		if (tmpBox < 0) {
			result[0] = Integer.MAX_VALUE;
		} else {
			result[0] = tmpTime;
			result[1] = height;
		}
		return result;
	}
}