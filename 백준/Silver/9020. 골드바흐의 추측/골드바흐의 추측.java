import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrime();

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            int n = Integer.parseInt(br.readLine());
            int ans = findPrime(n);
            System.out.println(ans + " " + (n - ans));
        }
    }

    static void makePrime() {

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(10001); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j <= 10000; j += i) {
                prime[j] = true;
            }
        }
    }

    static int findPrime(int n) {
        int start = n / 2;
        int end = n / 2;
        while(true) {

            if(!prime[start] && !prime[end]) return start;

            start--;
            end++;
        }
    }
}