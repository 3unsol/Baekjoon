import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<Node>[] adjList;
    static boolean[] canGo, isVisited;
    static long[] dist;
    static final long INF = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N];
        canGo = new boolean[N];
        isVisited = new boolean[N];
        dist = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
            dist[i] = INF;
            int flag = Integer.parseInt(st.nextToken());
            if(flag == 0) canGo[i] = true;
        }

        canGo[N - 1] = true;

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            if(!canGo[start] || !canGo[end]) continue;

            adjList[start].add(new Node(end, distance));
            adjList[end].add(new Node(start, distance));
        }

        dijkstra();

        if(dist[N - 1] == INF) System.out.println(-1);
        else System.out.println(dist[N - 1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty()){

            Node now = pq.poll();

            if(isVisited[now.number]) continue;
            isVisited[now.number] = true;

            for(Node next : adjList[now.number]) {
                if(dist[next.number] > dist[now.number] + next.distance) {
                    dist[next.number] = dist[now.number] + next.distance;
                    pq.offer(new Node(next.number, dist[next.number]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int number;
        long distance;
        Node(int number, long distance) {
            this.number = number;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if(this.distance - o.distance > 0) return 1;
            else return -1;
        }
    }
}