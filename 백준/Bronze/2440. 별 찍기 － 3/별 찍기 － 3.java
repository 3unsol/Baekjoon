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
        if(num == 0){
            return;
        }else {
            for (int i = 0; i < num; i++) {
                System.out.print("*");
            }
            System.out.println();
            star(num - 1);
        }
    }
}