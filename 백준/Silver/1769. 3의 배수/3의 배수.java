import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static String X;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = br.readLine();
        recur(X);
    }

    static void recur(String N) {

        while(true) {

            if(N.length() == 1) break;

            long sum = 0;

            for(int i = 0; i < N.length(); i++) {
                sum += Integer.parseInt(String.valueOf(N.charAt(i)));
            }

            cnt++;
            N = String.valueOf(sum);
        }

        System.out.println(cnt);
        if(Integer.parseInt(N) % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

}