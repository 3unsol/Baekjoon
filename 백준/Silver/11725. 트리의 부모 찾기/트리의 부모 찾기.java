import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer>[] edges;
	static boolean[] isVisited;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		input();
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N + 1];
		
		// 그릇이 될 빈 리스트 만들어주기
		for(int i = 0; i <= N; i++) {
			edges[i] = new ArrayList<>();
		}
		
		// 간선 정보 리스트에 담기
		for(int i = 0; i < N - 1; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			edges[node1].add(node2);
			edges[node2].add(node1);
			
		}
		
		isVisited = new boolean[N + 1];
		parents = new int[N + 1];
		
		// 루트 노드는 1
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 2; i <= N; i++) {
			sb.append(parents[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int node) {
		
		isVisited[node] = true;
		
		for(int v : edges[node]) {
			
			if(!isVisited[v]) {
				parents[v] = node;
				dfs(v);
			}
		}
	}

}