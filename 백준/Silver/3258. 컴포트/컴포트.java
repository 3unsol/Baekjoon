import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, Z, M, K;
	static List<Integer> obs = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		input();
		System.out.println(find());
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Z = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
				obs.add(num);
		}
	}

	static int find() {
		if (M == 0) {
			return 1;
		} else {
			int idx = 1;
			while (true) {
				if(K == Z - 1){
					return Z - 1;
				}
				int now = idx + K;
				if (now > N) {
					now %= N;
				}
				if(now == 1){
					K++;
					idx = 1;
					continue;
				}
				if (now == Z) {
					return K;
				} else if (obs.contains(now)) {
					K++;
					idx = 1;

				} else {
					idx = now;
				}
			}
		}
	}
}