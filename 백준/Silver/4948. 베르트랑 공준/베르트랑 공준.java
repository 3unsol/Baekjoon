import java.io.BufferedReader;
import java.io.InputStreamReader;

// 에라토스테네스의 체

public class Main {

    static int n;
    static boolean[] prime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrime();

        while(true) {

            n = Integer.parseInt(br.readLine());
            if(n == 0) return;

            int cnt = 0;
            for(int i = n + 1; i <= 2 * n; i++) {
                if(!prime[i]) cnt++;
            }

            System.out.println(cnt);
        }
    }

    static void makePrime() {
        prime = new boolean[123456 * 2 + 1];
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}