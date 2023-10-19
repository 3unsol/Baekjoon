import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;

    public static void main(String[] args) throws IOException {
        input();
        star();
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }

    static void star(){
        for(int i = n; i > 0; i--){
            for(int j = 1; j <= n - i; j++){
                System.out.print(' ');
            }
            for(int j = 2 * i - 1; j >= 1; j--){
                System.out.print('*');
            }
            System.out.println();
        }
        for(int i = n - 1; i > 0; i--){
            for(int j = i - 1; j >= 1; j--){
                System.out.print(' ');
            }
            for(int j = 0; j <= 2 * (n - i); j++){
                System.out.print('*');
            }
            System.out.println();
        }
    }
}