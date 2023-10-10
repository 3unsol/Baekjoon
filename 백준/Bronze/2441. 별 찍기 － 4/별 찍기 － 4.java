import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, cnt;
    public static void main(String[] args) throws IOException {
        input();
        star(n);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static void star(int num){
        char[][] map = new char[num][num];
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++) {
                if (i <= j) {
                    map[i][j] = '*';
                } else {
                    map[i][j] = ' ';
                }
            }
        }
        for(int i = 0; i < num; i++){
            for(int j = 0; j < num; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}