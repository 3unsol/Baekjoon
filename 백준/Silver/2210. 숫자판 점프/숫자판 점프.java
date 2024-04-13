import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map = new int[5][5];
    static int[] numbers = new int[6];
    static List<String> list = new ArrayList<>();
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < 5; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < 5; r++) {
            for(int c = 0; c < 5; c++) {
                dfs(r, c, 1);
            }
        }

        System.out.println(list.size());
    }

    static void dfs(int r, int c, int dist) {

        // 숫자 6개 완성
        if(dist > 6) {

            // 문자열로 만들기
            String str = "";
            for(int i = 0; i < 6; i++) {
                str += Integer.toString(numbers[i]);
            }

            // indexOf(str) -> str이 있는 인덱스 값 반환, 없으면 -1
            if(list.indexOf(str) == -1) {
                list.add(str);
            }
            return;
        }

        // 숫자 만들기
        numbers[dist - 1] = map[r][c];

        // 사방탐색
        for(int dir = 0; dir < 4; dir++) {

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(nr >= 0 && nc >= 0 && nr < 5 && nc < 5) {
                dfs(nr, nc, dist + 1);
            }
        }

    }
}