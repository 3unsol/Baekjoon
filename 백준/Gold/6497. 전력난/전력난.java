import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, total;
    static ArrayList<Node>[] adjList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) return;

            adjList = new ArrayList[N];
            for(int i = 0; i < N; i++) {
                adjList[i] = new ArrayList<>();
            }

            total = 0;

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                adjList[a].add(new Node(b, cost));
                adjList[b].add(new Node(a, cost));
                total += cost;
            }

            prim();
        }
    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N];

        pq.offer(new Node(1, 0));
        int dist = 0;

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

        System.out.println(total - dist);
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