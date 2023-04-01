import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	static int[] p;
	static int[] rank;
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(rank[px] > rank[py]) {
			p[py] = px;
		}else {
			if(rank[px] == rank[py]) {
				rank[py]++;
			}
			p[px] = py;
		}
	}
	
	static int find(int x) {
		if(x != p[x]) {
			p[x] = find(p[x]);
		}
		return p[x];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int[][] edges = new int[e][3];
		for (int i = 0; i < e; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[v + 1];
		rank = new int[v + 1];

		for(int i = 0; i <= v; i++) {
			p[i] = i;
		}
		
		int ans = 0;
		int pick = 0;
		
		for(int i = 0; i < e; i++) {
			int px = find(edges[i][0]);
			int py = find(edges[i][1]);
			
			if(px != py) {
				union(px, py);
				ans += edges[i][2];
				pick++;
			}
			
			if(pick == (v - 1)) break;
		}
		System.out.println(ans);
	}
}
