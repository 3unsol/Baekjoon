import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 에라토스테네스의 체
        // true : 소수X, false : 소수
        boolean prime[] = new boolean[1299710];
        for(int i = 2; i < 1299710; i++) {
            for(int j = i; i * j > 2 && i * j < 1299710; j++) {
                prime[i * j] = true;
            }
        }

        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            if(prime[N]) { // N이 소수가 아닐 때
                int start = N;
                int end = N;
                while(true) { // N보다 작은 소수 중 가장 큰 수
                    if(!prime[--start]) break;
                }
                while(true) { // N보다 큰 소수 중 가장 작은 수
                    if(!prime[++end]) break;
                }
                System.out.println(end - start);
            } else { // N이 소수일 때
                System.out.println(0);
            }
        }
    }
}