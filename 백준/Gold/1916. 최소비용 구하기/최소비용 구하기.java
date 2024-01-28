import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, start, end;
    static int[] dist;
    static boolean[] isVisited;
    static List<ArrayList<Node>> idjList = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N + 1];
        isVisited = new boolean[N + 1];

        Arrays.fill(dist, INF);

        for(int i = 0; i <= N; i++){
            idjList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            idjList.get(startIndex).add(new Node(endIndex, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){

            int nowIndex = pq.poll().index;

            if(nowIndex == end){
                System.out.println(dist[end]);
                return;
            }

            if(isVisited[nowIndex]) continue;
            isVisited[nowIndex] = true;

            for(Node next : idjList.get(nowIndex)){
                if(dist[next.index] > dist[nowIndex] + next.cost){
                    dist[next.index] = dist[nowIndex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;
        Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}