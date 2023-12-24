import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static int N, ans;
    static boolean[][] board;
    static int[] dc = {-1, 0, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];

        putQueen(0);

        System.out.println(ans);
    }

    // r : 퀸을 놓으려는 행
    static void putQueen(int r) {

        // 마지막 행까지 왔다면 N개의 퀸을 놓은 것
        if(r == N){
            ans++;
        }
        else{
            // r행에 열마다 퀸을 놓아보자
            for(int col = 0; col < N; col++){

                boolean canPut = true; // 다음 방향을 보지 않고 끝내기 위한 플래그

                for(int dir = 0; dir < 3; dir++){ // 델타 방향 정하는 반복문

                    int depth = 1; // 델타 방향으로 나아가기 위한 변수
                    if(!canPut) break; // 다음 방향 보지 않고 끝내기

                    while(true){ // 델타 방향으로 나아가는 반복문

                        int nr = r + depth * -1;
                        int nc = col + depth * dc[dir];

                        if(!canMove(nr, nc)) break;

                        if(board[nr][nc]){ // 범위 외 or 퀸이 있으면 못 놓음
                            canPut = false;
                            break;
                        }
                        depth++;
                    }
                }

                if(canPut){
                    board[r][col] = true;
                    putQueen(r + 1);
                    board[r][col] = false;
                }
            }
        }
    }

    static boolean canMove(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}