import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static long total, dist;
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

            total += cost;
        }

        isVisited = new boolean[N + 1];

        prim();

        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total - dist);
    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.node]) {
                isVisited[now.node] = true;
                dist += now.cost;

                for(Node next : adjList[now.node]) {
                    if(!isVisited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }
    }
    static class Node implements Comparable<Node> {
        int node, cost;
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