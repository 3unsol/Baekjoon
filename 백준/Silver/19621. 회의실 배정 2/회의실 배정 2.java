import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] info;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회의 개수
        N = Integer.parseInt(br.readLine());
        // 0 : 시작, 1 : 끝, 2 : 인원
        info = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
            info[i][2] = Integer.parseInt(st.nextToken());
        }

        if(N == 1) {
            System.out.println(info[0][2]);
            return;
        }

        dp = new int[N];

        // 회의 하나일 때는 걔가 최대 인원
        dp[0] = info[0][2];
        // 두 개일 때는 둘 중 큰 게 최대 인원
        dp[1] = Math.max(dp[0], info[1][2]);

        // 해당 회의를 넣으려면 그 전 회의는 빼야 함
        // 전 회의를 넣으려면 지금 회의 못 넣음
        for(int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + info[i][2], dp[i - 1]);
        }

        System.out.println(dp[N - 1]);
    }
}