import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int V, E, P;
    static final int INF = 987654321;
    static int[] dist;
    static boolean[] isVisited;
    static List<ArrayList<Node>> adjList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList.get(start).add(new Node(end, cost));
            adjList.get(end).add(new Node(start, cost));
        }

        int min = dijkstra(1, V);
        int geonwoo = dijkstra(1, P) + dijkstra(P, V);

        if (min >= geonwoo) {
            System.out.println("SAVE HIM");
        } else {
            System.out.println("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end) {

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        isVisited = new boolean[V + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.num]) {
                isVisited[now.num] = true;
                for(Node next : adjList.get(now.num)) {
                    if(dist[next.num] > dist[now.num] + next.cost) {
                        dist[next.num] = dist[now.num] + next.cost;
                        pq.offer(new Node(next.num, dist[next.num]));
                    }
                }
            }
        }

        return dist[end];
    }
    static class Node implements Comparable<Node> {
        int num, cost;
        Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}