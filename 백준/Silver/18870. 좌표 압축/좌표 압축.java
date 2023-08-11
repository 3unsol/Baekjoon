import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] sorted = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = sorted[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sorted);
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(sorted[i])) {				
				map.put(sorted[i], rank);
				rank++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(map.get(arr[i])).append(" ");
		}
		System.out.println(sb);
	}
}
