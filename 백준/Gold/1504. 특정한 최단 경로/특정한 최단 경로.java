import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, a, b;
    static List<ArrayList<Node>> adjList = new ArrayList<>();
    static boolean[] isVisited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(start).add(new Node(end, cost));
            adjList.get(end).add(new Node(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distN = dijkstra(N);
        int[] distA = dijkstra(a);

        int minSum = findMinSum(dist1, distN);

        if(minSum == INF || distA[b] == INF) {
            System.out.println(-1);
            return;
        }

        System.out.println(minSum + distA[b]);
    }

    static int findMinSum(int[] dist1, int[] distN) {

        int sum1 = 0;
        int sum2 = 0;

        if(dist1[a] == INF || distN[b] == INF) {
            sum1 = INF;
        } else {
            sum1 = dist1[a] + distN[b];
        }

        if(dist1[b] == INF || distN[a] == INF) {
            sum2 = INF;
        } else {
            sum2 = dist1[b] + distN[a];
        }

        int minSum = Math.min(sum1, sum2);

        return minSum;
    }

    static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(isVisited[now.index]) continue;

            isVisited[now.index] = true;

            for(Node next : adjList.get(now.index)) {

                if(isVisited[next.index]) continue;
                if(dist[next.index] < dist[now.index] + next.cost) continue;

                dist[next.index] = dist[now.index] + next.cost;
                pq.offer(new Node(next.index, dist[next.index]));
            }
        }

        return dist;
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        Node (int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}