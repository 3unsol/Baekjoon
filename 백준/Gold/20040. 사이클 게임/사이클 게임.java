import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, ans;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 점
        N = Integer.parseInt(st.nextToken());
        // 선분 개수
        M = Integer.parseInt(st.nextToken());

        // 부모
        parents = new int[N];
        // 부모 나로 채우기
        for(int i = 0; i < N; i++) {
            parents[i] = i;
        }

        for(int i = 1; i <= M; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b, i);

            if(ans != 0) {
                System.out.println(ans);
                return;
            }
        }

        System.out.println(ans);
    }

    static void union(int a, int b, int cnt) {

        int pA = find(a);
        int pB = find(b);

        if(pA == pB) {
            ans = cnt;
            return;
        }

        if(pA > pB) {
            parents[pA] = pB;
        } else if(pA < pB) {
            parents[pB] = pA;
        }
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return find(parents[x]);
    }
}