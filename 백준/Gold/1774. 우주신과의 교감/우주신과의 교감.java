import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static Star[] stars;
    static ArrayList<Matrix>[] adjList;
    static boolean[][] isConnected;
    static double dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 행성 좌표
        stars = new Star[N + 1];
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new Star(x, y);
        }

        // 이미 연결된 행성
        isConnected = new boolean[N + 1][N + 1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());
            isConnected[s1][s2] = isConnected[s2][s1] = true;
        }

        // 행성 간의 거리 저장
        adjList = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(isConnected[i][j]) {
                    adjList[i].add(new Matrix(j, 0));
                    adjList[j].add(new Matrix(i, 0));
                } else {
                    Star s1 = stars[i];
                    Star s2 = stars[j];
                    double cost = Math.sqrt(Math.pow(s1.x - s2.x, 2) + Math.pow(s1.y - s2.y, 2));
                    adjList[i].add(new Matrix(j, cost));
                    adjList[j].add(new Matrix(i, cost));
                }
            }
        }

        prim();

        System.out.printf("%.2f", dist);
    }

    static void prim() {
        PriorityQueue<Matrix> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N + 1];

        pq.offer(new Matrix(1, 0));

        while(!pq.isEmpty()) {

            Matrix now = pq.poll();

            if(!isVisited[now.node]) {
                dist += now.cost;
                isVisited[now.node] = true;

                for(Matrix next : adjList[now.node]) {
                    if(!isVisited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }
    }

    static class Star {
        int x, y;
        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Matrix implements Comparable<Matrix> {
        int node;
        double cost;
        Matrix(int node, double cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Matrix o) {
            double result = this.cost - o.cost;
            if(result >= 0.0) return 1;
            else return -1;
        }
    }
}