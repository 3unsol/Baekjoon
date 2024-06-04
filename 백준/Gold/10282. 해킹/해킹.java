import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, D, C;
    static ArrayList<Node>[] adjlist;
    static boolean[] isVisited;
    static int[] cost;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            D = Integer.parseInt(st.nextToken()); // 의존 개수
            C = Integer.parseInt(st.nextToken()); // 시작 컴퓨터

            adjlist = new ArrayList[N + 1]; // 인접 배열
            isVisited = new boolean[N + 1]; // 방문 배열
            cost = new int[N + 1]; // 비용 배열
            
            for(int i = 0; i <= N; i++) {
                adjlist[i] = new ArrayList<>(); // 빈 바구니 추가
                cost[i] = INF; // cost 배열 INF로 채우기
            }

            for(int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                adjlist[b].add(new Node(a, sec));
            }

            dijkstra();

            int cnt = 0;
            int time = 0;

            for(int i = 1; i <= N; i++) {
                if(cost[i] != INF) {
                    cnt++;
                    time = Math.max(time, cost[i]);
                }
            }

            System.out.println(cnt + " " + time);
        }
    }

    static void dijkstra() {

        PriorityQueue<Node> pq = new PriorityQueue();

        pq.offer(new Node(C, 0));
        cost[C] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.num]) {

                isVisited[now.num] = true;

                for(Node node : adjlist[now.num]) {

                    if(cost[node.num] > cost[now.num] + node.cost) {
                        cost[node.num] = cost[now.num] + node.cost;
                        pq.offer(new Node(node.num, cost[node.num]));
                    }
                }
            }
        }
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