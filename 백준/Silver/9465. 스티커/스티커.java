import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, ans;
    static int[][] score, dp;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < testCase; tc++){
            input();
            findMaxScore();
            System.out.println(ans);
        }
    }

    static void input() throws Exception {

        n = Integer.parseInt(br.readLine());
        score = new int[2][n + 1];

        StringTokenizer st;

        for(int r = 0; r < 2; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= n; c++){
                score[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void findMaxScore() {

        for(int i = 2; i <= n; i++){
            score[0][i] += Math.max(score[1][i - 1], score[1][i - 2]);
            score[1][i] += Math.max(score[0][i - 1], score[0][i - 2]);
        }

        ans = Math.max(score[0][n], score[1][n]);
    }
}
