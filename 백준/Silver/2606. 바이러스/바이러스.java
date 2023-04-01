
import java.util.Scanner;

public class Main {
	
	static int n;
	static int[][] graph;
	static boolean[] visited;
	static int cnt;
	
	static void dfs(int v) {
		visited[v] = true;
		for(int i = 1; i <= n; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
				cnt++;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		int a = 0; 
		int b = 0;
		for(int i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = graph[b][a] = 1;
		}
		cnt = 0;
		dfs(1);
		System.out.println(cnt);
	}
}
