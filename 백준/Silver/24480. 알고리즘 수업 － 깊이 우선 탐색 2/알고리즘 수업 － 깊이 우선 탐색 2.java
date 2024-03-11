import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, R, rank;
    static int[] isVisited;
    static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i = 0; i <= N; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        isVisited = new int[N + 1];
        isVisited[R] = 1;
        rank = 1;

        dfs(R);

        for(int i = 1; i <= N; i++) {
            System.out.println(isVisited[i]);
        }
    }

    static void dfs(int num) {

        for(int next : list.get(num)) {
            if(isVisited[next] == 0) {
                isVisited[next] = ++rank;
                dfs(next);
            }
        }
    }
}