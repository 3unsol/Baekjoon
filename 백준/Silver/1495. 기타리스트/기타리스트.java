import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, S, M;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 음악 개수
        S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // 최대 볼륨

        dp = new int[M + 1]; // 인덱스 : 볼륨 크기, 값 : 음악 번호
        for(int i = 0; i <= M; i++) {
            dp[i] = -1;
        }
        dp[S] = 0; // 첫 번째 음악은 시작 볼륨

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= N; i++) {
            int range = Integer.parseInt(st.nextToken()); // 조절 가능 범위
            List<Integer> list = new ArrayList<>(); // 가능한 모든 볼륨을 담을 리스트
            for(int j = 0; j <= M; j++) {
                if(dp[j] == i - 1) { // 이전 음악 가능한 볼륨 크기
                    int up = j + range; // 상한선
                    int down = j - range; // 하한선
                    if(up <= M) {
                        list.add(up);
                    }
                    if(0 <= down) {
                        list.add(down);
                    }
                }
            }
            for(int vol : list) {
                dp[vol] = i; // dp배열에 가능하다고 표시
            }
        }
        for(int i = M; i >= 0; i--) {
            if(dp[i] == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}