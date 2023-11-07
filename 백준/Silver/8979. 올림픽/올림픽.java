import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		/**
		 * 0 : 국가 번호
		 * 1 : 금메달 개수
		 * 2 : 은메달 개수
		 * 3 : 동메달 개수
		 */
		int[][] map = new int[N][4];
		for(int r = 0; r < N; r++){
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < 4; c++){
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		// 금은동 순으로 정렬
		Arrays.sort(map, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					if(o1[2] == o2[2]){
						return o2[3] - o1[3];
					}
					return o2[2] - o1[2];
				}
				return o2[1] - o1[1];
			}
		});

		// K의 현재 위치 찾기
		int idx = 0;
		for(int i = 0; i < N; i++){
			if(map[i][0] == K){
				idx = i;
			}
		}

		// K랑 동점인 애들 개수
		int cnt = 0;
		for(int i = 0; i < idx; i++){
			if(map[i][1] == map[idx][1] &&
				map[i][2] == map[idx][2] &&
				map[i][3] == map[idx][3]){
				cnt++;
			}
		}

		System.out.println(idx - cnt + 1);
	}
}