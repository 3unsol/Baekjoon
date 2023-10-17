import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    public static void main(String[] args) throws IOException {
        input();
        star();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
    }

    static void star(){
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print(' ');
            }
            for(int j = 0; j < 2 * i - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            for(int j = 2 * i - 1; j >= 1; j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}