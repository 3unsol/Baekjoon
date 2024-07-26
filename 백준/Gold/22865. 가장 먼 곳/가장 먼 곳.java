import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, A, B, C, land;
    static final int INF = 987654321;
    static List<ArrayList<Node>> adjList = new ArrayList<>();
    static int[] dist, ans;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            adjList.get(d).add(new Node(e, l));
            adjList.get(e).add(new Node(d, l));
        }

        ans = new int[N + 1];
        Arrays.fill(ans, INF);

        dijkstra(A);
        dijkstra(B);
        dijkstra(C);

        int max = 0;

        for(int i = 1; i <= N; i++) {
            if(i != A && i != B && i != C) {
                if(max < ans[i]) {
                    max = ans[i];
                    land = i;
                }
            }
        }

        System.out.println(land);
    }

    static void dijkstra(int start) {

        dist = new int[N + 1];
        Arrays.fill(dist, INF);

        isVisited = new boolean[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.val]) {
                isVisited[now.val] = true;

                for(Node next : adjList.get(now.val)) {
                    if(dist[next.val] > dist[now.val] + next.cost) {
                        dist[next.val] = dist[now.val] + next.cost;
                        pq.offer(new Node(next.val, dist[next.val]));
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            if(ans[i] > dist[i]) {
                ans[i] = dist[i];
            }
        }
    }

    static class Node implements Comparable<Node> {
        int val, cost;
        Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}