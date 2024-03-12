import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] cards;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 카드 개수
        N = Integer.parseInt(br.readLine());
        // 카드팩 가격
        cards = new int[N + 1];
        // DP 배열
        dp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드팩 가격 입력
        for(int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 한 개는 한 개
        dp[1] = cards[1];

        // 두 개부터 N까지
        for(int i = 2; i <= N; i++) {
            // N 만들 수 있는 조합 중에 젤 큰 값
            int max = 0;
            // 두 수의 합이 N이 되는 애들 가격 중에 큰 애 찾기
            for(int j = 0; j <= i; j++) {
                max = Math.max(dp[i - j] + dp[j], max);
            }
            // N카드팩 사는 거랑 비교
            dp[i] = Math.max(max, cards[i]);
        }

        System.out.println(dp[N]);
    }
}