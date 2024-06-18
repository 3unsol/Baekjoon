import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int E = sc.nextInt();
        int S = sc.nextInt();
        int M = sc.nextInt();

        int e = 1, s = 1, m = 1, cnt = 1;

        while(true) {

            if(e == E && s == S && m == M) break;

            e++;
            s++;
            m++;
            cnt++;

            if(e == 16) e = 1;
            if(s == 29) s = 1;
            if(m == 20) m = 1;
        }

        System.out.println(cnt);
    }
}