import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/**
 * 필드 돌면서 bfs 돌기
 * 상하좌우로 같은 색 있으면 넣고 .으로 바꾸기
 * depth >= 4 면 cnt++ (한 라운드에 한 번만...)
 * 밑에가 .이면 그 자리로 이동
 *
 */

public class Main {

    static char[][] field;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static boolean[][] isVisited;
    static boolean flag;
    static int cnt;

    public static void main(String[] args) throws Exception {
        input();
        stage();
        System.out.println(cnt);
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];

        for(int r = 0; r < 12; r++){
            String str = br.readLine();
            for(int c = 0; c < 6; c++){
                field[r][c] = str.charAt(c);
            }
        }
    }

    // 필드 돌면서 bfs
    static void stage(){

        isVisited = new boolean[12][6];
        flag = false;

        for(int r = 0; r < 12; r++){
            for(int c = 0; c < 6; c++){
                if(field[r][c] != '.' && !isVisited[r][c]){
                    bfs(r, c);
                }
            }
        }

        if(flag){
            cnt++;
        }else{
            return;
        }

        fall();
        stage();
    }

    // 현재 좌표랑 같은 색깔의 뿌요면 depth 늘려서 q에 넣기
    // 뽑았을 때 depth > 4면 터트리기
    static void bfs(int r, int c){

        Queue<Puyo> q = new LinkedList<>();
        List<Puyo> list = new ArrayList<>();

        q.offer(new Puyo(r, c));
        list.add(new Puyo(r, c));
        isVisited[r][c] = true;

        while(!q.isEmpty()){

            Puyo now = q.poll();

            for(int dir = 0; dir < 4; dir++) {

                int nr = now.r + dr[dir];
                int nc = now.c + dc[dir];

                if (canMove(nr, nc) && !isVisited[nr][nc] && field[nr][nc] == field[now.r][now.c]) {
                    q.offer(new Puyo(nr, nc));
                    list.add(new Puyo(nr, nc));
                    isVisited[nr][nc] = true;
                }

            }
        }

        if(list.size() >= 4){
            for(int i = 0; i < list.size(); i++){
                Puyo puyo = list.get(i);
                field[puyo.r][puyo.c] = '.';
            }
            flag = true;
        }
    }

    // 떨어트리기
    static void fall(){

        for(int c = 0; c < 6; c++){
            for(int r = 0; r < 11; r++){

                if(field[r + 1][c] == '.'){

                    for(int nr = r; nr >= 0; nr--){

                        if(field[nr][c] != '.'){
                            field[nr + 1][c] = field[nr][c];
                            field[nr][c] = '.';
                        }
                    }
                }
            }
        }

    }

    // 범위 확인
    static boolean canMove(int r, int c){
        return r >= 0 && c >= 0 && r < 12 && c < 6;
    }

    // q에 넣을 뿌요
    static class Puyo{
        int r;
        int c;

        Puyo(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}