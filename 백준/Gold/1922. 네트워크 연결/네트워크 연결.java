import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result;
    static ArrayList<Node>[] adjList;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

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

        System.out.println(result);
    }

    static void prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        isVisited = new boolean[N + 1];

        pq.offer(new Node(1, 0));

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.node]) {
                isVisited[now.node] = true;
                result += now.cost;

                for(Node next : adjList[now.node]) {
                    if(!isVisited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }
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