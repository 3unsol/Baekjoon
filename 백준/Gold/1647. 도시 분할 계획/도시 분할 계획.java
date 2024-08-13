import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최소 스패닝 트리
 * n개의 정점을 가진 그래프의 최소 간선의 수는 n-1
 * 모든 정점이 연결되어야 하고 사이클이 있으면 안 됨
 * 그 중 간선 가중치 합이 최소인 트리
 * 프림 또는 크루스칼 알고리즘 사용
 * 프림 : PQ, 크루스칼 : 유니온 파인드
 * 가장 큰 비용의 간선을 없애면 정답
 */
public class Main {

    static int N, M, ans;
    static ArrayList<Node>[] adjList;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[a].add(new Node(b, cost));
            adjList[b].add(new Node(a, cost));
        }

        prim();

        System.out.println(ans);
    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        isVisited = new boolean[N + 1];

        pq.offer(new Node(1, 0)); // 1부터 시작

        int dist = 0; // 가중치 합의 최솟값
        int max = 0; // 가장 큰 가중치 값

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.node]) {
                isVisited[now.node] = true;

                dist += now.cost;
                max = Math.max(max, now.cost);

                for(Node next : adjList[now.node]) {
                    if(!isVisited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }

        ans = dist - max;
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}