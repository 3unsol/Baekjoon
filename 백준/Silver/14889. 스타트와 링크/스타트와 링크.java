import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, min, diff;
    static int[][] map;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new boolean[N];

        StringTokenizer st;

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        min = Integer.MAX_VALUE;

        comb(0, 0);

        System.out.println(min);
    }

    /**
     * 조합
     * @param idx : 넣을 자리 인덱스
     * @param depth : visited를 true로 만든 개수
     */
    static void comb(int idx, int depth) {

        // start 팀원 완성
        if(depth == N / 2) {
            diff = calc();
            min = Math.min(diff, min);
            return;
        }

        // 조합 만들기 (true : start 팀원)
        for(int i = idx; i < N; i++) {
            if(isVisited[i]) break;
            isVisited[i] = true;
            comb(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }

    static int calc() {

        int start = 0;
        int link = 0;

        // 모든 조합 탐색
        for(int i = 0; i < N - 1; i++) {
            for(int j = i + 1; j < N; j++) {
                if(isVisited[i] && isVisited[j]) {
                    start += map[i][j];
                    start += map[j][i];
                } else if(!isVisited[i] && !isVisited[j]) {
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        return Math.abs(start - link);
    }
}