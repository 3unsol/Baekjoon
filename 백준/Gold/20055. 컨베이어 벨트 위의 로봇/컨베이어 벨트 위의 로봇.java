import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N : 컨베이어 벨트 길이, K : 내구도 0인 칸의 개수 한계
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // durability : 각 칸의 초기 내구도
        int[] durability = new int[N * 2];


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 2 * N; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        // 로봇 유무 (로봇은 N에서 내림)
        boolean[] hasRobot = new boolean[N];

        // 움직인 횟수
        int ans = 0;

        while(true) {

            // 종료 조건
            int cnt = 0;
            for(int i = 0; i < 2 * N; i++) {
                if(durability[i] == 0) cnt++;
            }
            if(cnt >= K) break;

            // 벨트 회전
            int tmp = durability[2 * N - 1];
            for(int i = 2 * N - 1; i > 0; i--) {
                durability[i] = durability[i - 1];
            }
            durability[0] = tmp;

            for(int i = N - 1; i > 0; i--) {
                hasRobot[i] = hasRobot[i - 1];
            }
            hasRobot[0] = false;
            hasRobot[N - 1] = false;

            // 로봇 이동
            for(int i = N - 1; i > 0; i--) {
                if(hasRobot[i - 1] && !hasRobot[i] && durability[i] >= 1) {
                    durability[i]--;
                    hasRobot[i] = true;
                    hasRobot[i - 1] = false;
                }
            }

            // 로봇 올리기
            if(durability[0] > 0) {
                hasRobot[0] = true;
                durability[0]--;
            }

            ans++;
        }

        System.out.println(ans);
    }
}