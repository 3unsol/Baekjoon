import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] dp = new int[30][30];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < testCase; tc++){

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // M개 중에서 N개 뽑기
            System.out.println(comb(M, N));

        }
    }

    static int comb(int n, int r){

        // 이미 올린 경우
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        // n C 0 = n C n = 1
        if(n == r || r == 0){
            return dp[n][r] = 1;
        }

        // n+1 C r+1 = n C r + n C r+1
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
