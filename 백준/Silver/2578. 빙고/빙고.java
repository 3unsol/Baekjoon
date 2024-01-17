import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] bingo;
    static int line, cnt;

    public static void main(String[] args) throws Exception {
        input();
        play();
    }

    static void input() throws Exception {

        bingo = new int[5][5];
        cnt = 1;

        for(int r = 0; r < 5; r++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int c = 0; c < 5; c++){
                bingo[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void play() throws Exception {

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++){

                int num = Integer.parseInt(st.nextToken());

                for(int r = 0; r < 5; r++){
                    for(int c = 0; c < 5; c++){

                        if(num == bingo[r][c]){
                            bingo[r][c] = 0;
                        }
                    }
                }

                col();
                row();
                rightDiagonal();
                leftDiagonal();

                if(line >= 3){
                    System.out.println(cnt);
                    return;
                }

                line = 0;
                cnt++;
            }
        }
    }

    static void col(){
        for(int c = 0; c < 5; c++){
            int sum = 0;
            for(int r = 0; r < 5; r++){
                sum += bingo[r][c];
            }
            if(sum == 0){
                line++;
            }
        }
    }

    static void row(){
        for(int r = 0; r < 5; r++){
            int sum = 0;
            for(int c = 0; c < 5; c++){
                sum += bingo[r][c];
            }
            if(sum == 0){
                line++;
            }
        }
    }

    static void leftDiagonal(){
        int count = 0;

        for(int i = 0; i < 5; i++){
            if(bingo[i][4 - i] == 0) count++;
            if(count == 5) line++;
        }
    }

    static void rightDiagonal(){
        int count = 0;

        for(int i = 0; i < 5; i++){
            if(bingo[i][i] == 0) count++;
            if(count == 5) line++;
        }
    }
}