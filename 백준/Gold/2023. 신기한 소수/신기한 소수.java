import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dfs(0, N);
        System.out.print(sb);
    }

    static void dfs(int num, int n) {
        // n자리수 완성
        if(n == 0) {
            sb.append(num).append("\n");
        }
        for(int i = 1; i < 10; i++) {
            // 10 곱해서 일의 자리수에 하나씩 넣어보기
            int tmp = 10 * num + i;
            // 만든 숫자가 소수라면 자리수 늘려서 만들러 가기
            if(n > 0 && isPrime(tmp)) {
                dfs(tmp, n - 1);
            }
        }
    }

    static boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i * i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}