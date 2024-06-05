import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, M, startCity, endCity, cnt;
    static ArrayList<Node>[] adjList;
    static boolean[] isVisited;
    static int[] cost, parents;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];
        adjList = new ArrayList[N + 1];
        cost = new int[N + 1];
        parents = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            cost[i] = INF;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adjList[start].add(new Node(end, dist));
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        dijkstra();

        System.out.println(cost[endCity]);

        cnt = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(endCity);
        while(parents[endCity] != 0) {
            cnt++;
            stack.push(parents[endCity]);
            endCity = parents[endCity];
        }

        System.out.println(cnt);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }

    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.offer(new Node(startCity, 0));
        cost[startCity] = 0;

        while(!pq.isEmpty()) {

            Node now = pq.poll();

            if(!isVisited[now.city]) {
                isVisited[now.city] = true;

                for(Node next : adjList[now.city]) {

                    if(cost[next.city] > cost[now.city] + next.dist) {
                        cost[next.city] = cost[now.city] + next.dist;
                        pq.offer(new Node(next.city, cost[next.city]));
                        parents[next.city] = now.city;
                    }

                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int city, dist;
        Node(int city, int dist) {
            this.city = city;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }
}