import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] arr, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        cnt = new int[N + 1]; // 개수 저장
        tree = new ArrayList[N + 1]; // 트리 만들기

        // 빈 바구니 만들기
        for(int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            // 무방향그래프
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        arr = new int[Q]; // 구하려는 정점

        for(int i = 0; i < Q; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(R, -1); // 시작점 임의의 정점

        for(int x : arr) {
            System.out.println(cnt[x]);
        }
    }

    /**
     * @param x // 현재 노드
     * @param prev // 상위 노드
     */
    static void dfs(int x, int prev) {

        cnt[x] = 1; // 루트도 간선에 포함

        for(int y : tree[x]) {
            if(y == prev) continue; // 방문한 곳 ㄴㄴ
            dfs(y, x);
            cnt[x] += cnt[y]; // 상위 노드에 간선 개수 누적해서 더함
        }

    }
}