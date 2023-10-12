import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        input();

    }

    static void input() throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            for(int j = n - i; j > 0; j--){
                System.out.print(' ');
            }
            for(int j = 0; j < 2 * i - 1; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
}