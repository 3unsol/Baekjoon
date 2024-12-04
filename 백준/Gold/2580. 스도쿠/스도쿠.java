import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int r = 0; r < 9; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < 9; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);
    }

    static void sudoku(int row, int col) {

        // 해당 row 다 봤다면 다음 row로 넘어가기
        if(col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 9번째 row까지 다 봤다면 출력
        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for(int r = 0; r < 9; r++) {
                for(int c = 0; c < 9; c++) {
                    sb.append(map[r][c]).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        // 해당 좌표값이 0이라면
        if(map[row][col] == 0) {
            // 좌표에 1~9까지 다 넣어보기
            for(int i = 1; i <= 9; i++) {
                if(check(row, col, i)) {
                    // 맵에 좌표 넣어주고 다음 칸 확인
                    map[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            // 다시 돌려놓기
            map[row][col] = 0;
            return;
        }

        // 해당 좌표값이 숫자면 다음 좌표 확인
        sudoku(row, col + 1);
    }

    static boolean check(int row, int col, int val) {

        // 행 검사
        for(int i = 0; i < 9; i++) {
            if(map[row][i] == val) return false;
        }

        // 열 검사
        for(int i = 0; i < 9; i++) {
            if(map[i][col] == val) return false;
        }

        // 정사각 검사
        int R = (row / 3) * 3;
        int C = (col / 3) * 3;
        for(int r = R; r < R + 3; r++) {
            for(int c = C; c < C + 3; c++) {
                if(map[r][c] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}