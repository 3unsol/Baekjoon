import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static final int INF = Integer.MAX_VALUE;
    static List<ArrayList<Node>> adjList = new ArrayList<>();
    static boolean[] isVisited;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
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

        dist = new int[N + 1];
        isVisited = new boolean[N + 1];

        Arrays.fill(dist, INF);

        System.out.println(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();
            if(isVisited[now.index]) continue;
            isVisited[now.index] = true;

            if(now.index == N) {
                return dist[now.index];
            }


            for(Node next : adjList.get(now.index)) {

                if(isVisited[next.index]) continue;
                if(dist[next.index] < dist[now.index] + next.cost) continue;

                dist[next.index] = dist[now.index] + next.cost;
                pq.offer(new Node(next.index, dist[next.index]));
            }
        }

        return -1;
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