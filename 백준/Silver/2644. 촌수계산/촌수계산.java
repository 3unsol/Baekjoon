import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static List<ArrayList<Integer>> list = new ArrayList<>();
    static int start, end;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int parents = Integer.parseInt(st.nextToken());
            int son = Integer.parseInt(st.nextToken());

            list.get(parents).add(son);
            list.get(son).add(parents);
        }

        isVisited = new boolean[N + 1];

        dfs(start, 0);

        if(!isVisited[end]) System.out.println(-1);
    }

    static void dfs(int n, int dist) {

        isVisited[n] = true;

        if(n == end) {
            System.out.println(dist);
            return;
        }

        for(int num : list.get(n)) {
            if(!isVisited[num]) {
                dfs(num, dist + 1);
            }
        }
    }
}