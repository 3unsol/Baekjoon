import java.io.*;
import java.util.*;

public class Main {

    static int N, M, R, cnt;
    static int[] isVisited;
    static List<ArrayList<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        isVisited = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(adjList.get(i));
        }

        dfs(R);

        for(int i = 1; i <= N; i++) {
                System.out.println(isVisited[i]);
        }
    }

    static void dfs(int num) {
        isVisited[num] = ++cnt;
        for(int next : adjList.get(num)) {
            if(isVisited[next] == 0) {
                dfs(next);
            }
        }
    }
}