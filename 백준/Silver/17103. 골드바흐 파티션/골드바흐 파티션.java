import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static boolean[] isNotPrime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makePrime();

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            int N = Integer.parseInt(br.readLine());
            findPrime(N);
        }
        System.out.print(sb);
    }

    static void makePrime() {
        isNotPrime = new boolean[1000001];
        isNotPrime[0] = isNotPrime[1] = true;

        for(int i = 2; i < Math.sqrt(isNotPrime.length); i++) {
            if(isNotPrime[i]) continue;
            for(int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }

    static void findPrime(int N) {
        int cnt = 0;
        for(int i = 2; i <= N / 2; i++) {
            if(!isNotPrime[i] && !isNotPrime[N - i]) {
                cnt++;
            }
        }
        sb.append(cnt).append("\n");
    }
}