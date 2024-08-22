import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 이해 못 했음...
 * 왜 3차원 좌표를 각 좌표대로 나눠서 정렬하고 넣으면 똑같이 나오는 거지????
 * ????
 * 모르겠음...ㅠ
 * 암튼 해보겠다
 */
public class Main {

    static int N;
    static List<int[]> planets = new ArrayList<>();
    static ArrayList<Matrix>[] adjList;
    static long dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        // 행성 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets.add(new int[] {i, x, y, z});
        }

        // ***행성 간 거리 입력***
        adjList = new ArrayList[N];
        for(int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }
        for(int i = 1; i <= 3; i++) {
            int idx = i;
            Collections.sort(planets, Comparator.comparingInt((int[] o) -> o[idx]));
            for(int j = 1; j < N; j++) {
                int[] p1 = planets.get(j);
                int[] p2 = planets.get(j - 1);
                int dist = Math.abs(p1[idx] - p2[idx]);
                adjList[p1[0]].add(new Matrix(p2[0], dist));
                adjList[p2[0]].add(new Matrix(p1[0], dist));
            }
        }

        prim();
        System.out.println(dist);
    }

    static void prim() {
        PriorityQueue<Matrix> pq = new PriorityQueue<>();
        boolean[] isVisited = new boolean[N];
        pq.offer(new Matrix(0, 0));

        while(!pq.isEmpty()) {

            Matrix now = pq.poll();

            if(!isVisited[now.node]) {
                isVisited[now.node] = true;
                dist += now.cost;

                for(Matrix next : adjList[now.node]) {
                    if(!isVisited[next.node]) {
                        pq.offer(next);
                    }
                }
            }
        }

    }

    static class Matrix implements Comparable<Matrix> {
        int node, cost;
        Matrix(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
        @Override
        public int compareTo(Matrix o) {
            return this.cost - o.cost;
        }
    }
}