import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	// Node : 나와 연결 된 정점과 가중치를 담을 클래스
	// v : 나와 연결된 정점
	// w : v와의 가중치
	// Comparable을 이용하여 가중치 순으로 정렬하게 만들어준다.
	static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// 이렇게 쓰면 오름차순
			// 반대로 쓰면 내림차순
			return this.w - o.w;
		}

	}

	static int V; // 정점의 개수
	static int E; // 간선의 개수

	static ArrayList<ArrayList<Node>> EdgeList; // 간선 정보를 담을 리스트
	static int[] dist; // 가중치를 담을 배열

	// 다익스트라
	// k : 시작 정점
	static void dijkstra(int k) {
		PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐를 이용한다.

		dist = new int[V + 1]; // 가중치 배열을 생성한다.
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 초기화를 해준다.

		boolean[] visited = new boolean[V + 1]; // 방문했는지 확인할 배열.

		pq.offer(new Node(k, 0)); // 시작과 시작의 가중치를 0이라 설정해주고 pq에 넣는다.
		dist[k] = 0; // 시작의 가중치 또한 0으로 입력해준다.

		while (!pq.isEmpty()) { // pq가 빌 때까지 확인한다.
			Node curr = pq.poll(); // pq에서 노드 하나를 뽑아낸다.

			if (visited[curr.v])
				continue; // 그게 이미 방문한 노드면 컨티뉴
			visited[curr.v] = true; // 뽑았으니 방문했다고 표시해준다.
			dist[curr.v] = curr.w; // 이미 curr.w에는 지금까지의 가중치가 담겨있다. dist배열에 넣어준다.

			for (Node node : EdgeList.get(curr.v)) { // curr와 연결된 노드를 돌면서
				pq.offer(new Node(node.v, curr.w + node.w)); // 지금까지의 가중치 + 본인의 가중치를 새로 만들어서 넣어준다.
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		E = sc.nextInt();
		int K = sc.nextInt();

		EdgeList = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			EdgeList.add(new ArrayList<Node>());
		}

		for (int i = 0; i < E; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int w = sc.nextInt();
			EdgeList.get(st).add(new Node(ed, w));
		}

		dijkstra(K);

		for (int i = 1; i < dist.length; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}

	}
}
