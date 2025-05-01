import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 인접한 칸에서 바다 개수가 3개 이상이면 사라짐
 * 1-1. 미리 바꾸면 안 됨 -> 맵 새로 만들기? 좌표 저장하기? 훔냠,,,
 * 2. 모든 섬을 포함하는 가장 작은 직사각형만 출력
 * 2-1. 좌표 r, c값 최대 최소 갱신하기?
 * 3. 지도에 없는 부분은 모두 바다!!!
 */

public class Main {

    static int N, M, minR, minC, maxR, maxC;
    static char[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static boolean[][] isLand;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for(int r = 0; r < N; r++) {
            String  str = br.readLine();
            for(int c = 0; c < M; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        isLand = new boolean[N][M];
        minR = N;
        minC = M;
        maxR = 0;
        maxC = 0;

        after50years();

        StringBuilder sb = new StringBuilder();

        for(int r = minR; r <= maxR; r++) {
            for(int c = minC; c <= maxC; c++) {
                if(isLand[r][c]) sb.append('X');
                else sb.append(".");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void after50years() {
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                if(map[r][c] == 'X') {
                    int seaCnt = 0;
                    for(int dir = 0; dir < 4; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        if(!canMove(nr, nc) || map[nr][nc] == '.') {
                            seaCnt++;
                        }
                    }
                    // 인근 바다가 3개 이하일 때
                    if(seaCnt < 3) {
                        isLand[r][c] = true;
                        minR = Math.min(minR, r);
                        minC = Math.min(minC, c);
                        maxR = Math.max(maxR, r);
                        maxC = Math.max(maxC, c);
                    }
                }
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
