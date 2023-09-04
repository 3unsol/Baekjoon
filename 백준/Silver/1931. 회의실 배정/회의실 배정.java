import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static int n, cnt, min;
	static int[][] times;

	public static void main(String[] args) throws IOException {
		input();
		sort();
		cnt++;
		assign(times[0][1], 0);
		System.out.println(cnt);
	}
	
	static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		times = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());			
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
	}
	
	static void sort() {
		Arrays.sort(times, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}else {
					return o1[1] - o2[1];
				}
			}
		});
	}
	
	static void assign(int endTime, int tmp) {
//		if(endTime > times[n - 1][0]) {
//			return;
//		}
		if(tmp == n-1) {
			return;
		}
		for(int i = tmp + 1; i < n; i++) {
			if(times[i][0] >= endTime) {
				min = times[i][1];
				tmp = i;
				cnt++;
				assign(min, tmp);
				break;
			}
		}
//			cnt++;
//			assign(min, tmp);
//		if(flag) {
//			cnt++;
//			assign(min, tmp);
//		}
	}
}
