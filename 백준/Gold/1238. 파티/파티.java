import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, party;
    static List<ArrayList<Node>> comeback = new ArrayList<>();
    static List<ArrayList<Node>> go = new ArrayList<>();
    static boolean[] isVisited;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        party = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++){
            comeback.add(new ArrayList<>());
            go.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            comeback.get(start).add(new Node(end, cost));
            go.get(end).add(new Node(start, cost));
        }

        int[] comebackDist = dijkstra(comeback);
        int[] goDist = dijkstra(go);

        int max = 0;

        for(int i = 1; i <= N; i++) {
            max = Math.max(max, comebackDist[i] + goDist[i]);
        }

        System.out.println(max);
    }

    static int[] dijkstra(List<ArrayList<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        isVisited = new boolean[N + 1];
        int dist[] = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(party, 0));
        dist[party] = 0;

        while(!pq.isEmpty()){

            Node now = pq.poll();
            if(isVisited[now.index]) continue;
            isVisited[now.index] = true;

            for(Node next : list.get(now.index)) {

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