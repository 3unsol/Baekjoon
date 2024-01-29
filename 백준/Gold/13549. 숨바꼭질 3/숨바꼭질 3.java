import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int start, end;
    static final int MAX = 100000;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        isVisited = new boolean[MAX + 1];

        bfs();
    }

    static void bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        isVisited[start] = true;

        while(!pq.isEmpty()){

            Node now = pq.poll();
            isVisited[now.val] = true;

            if(now.val == end) {
                System.out.println(now.cost);
                return;
            }

            if(now.val - 1 >= 0 && !isVisited[now.val - 1]){
                pq.offer(new Node(now.val - 1, now.cost + 1));
            }

            if(now.val + 1 <= MAX && !isVisited[now.val + 1]){
                pq.offer(new Node(now.val + 1, now.cost + 1));
            }

            if(now.val * 2 <= MAX && !isVisited[now.val * 2]){
                pq.offer(new Node(now.val * 2, now.cost));
            }
        }
    }

    static class Node implements Comparable<Node> {
        int val;
        int cost;

        Node(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}