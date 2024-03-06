import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, diff;
    static int[][] taste;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        taste = new int[N][2];
        isVisited = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        diff = Integer.MAX_VALUE;
        comb(0);
        System.out.println(diff);
    }

    static void comb(int k) {

        if(k == N) {

            int sour = 1;
            int bitter = 0;
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                if(isVisited[i]) {
                    sour *= taste[i][0];
                    bitter += taste[i][1];
                    cnt++;
                }
            }
            if(cnt == 0) return;
            diff = Math.min(diff, Math.abs(sour - bitter));
            return;
        }

        isVisited[k] = true;
        comb(k + 1);
        isVisited[k] = false;
        comb(k + 1);
    }
}