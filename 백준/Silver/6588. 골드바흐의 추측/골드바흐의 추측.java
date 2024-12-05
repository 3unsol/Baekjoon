import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int answer;
    static boolean[] isNotPrime;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        findPrime();
        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            check(3, num);
        }
        System.out.print(sb);
    }

    static void check(int num, int target) {
        if(!isNotPrime[num] && !isNotPrime[target - num]) {
            sb.append(target).append(" = ").append(num).append(" + ").append(target - num).append("\n");
            return;
        }
        check(num + 2, target);
    }

    static void findPrime() {
        isNotPrime = new boolean[1000000];
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i = 2; i < Math.sqrt(isNotPrime.length); i++) {
            if(isNotPrime[i]) continue;
            for(int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}