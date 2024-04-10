import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 암호
        String password = br.readLine();

        // i자리일 때 가능한 암호의 개수
        int[] dp =  new int[password.length() + 1];
        dp[0] = 1;

        // 암호 자리수만큼 보기
        for(int i = 1; i <= password.length(); i++) {

            // 한 자리수 보기
            int one = password.charAt(i - 1) - '0';

            // 1-9 사이면 개수 똑같음
            if(one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            // 두 자리수 보기
            if(i == 1) continue;
            // 10의 자리
            int ten = password.charAt(i - 2) - '0';
            // 앞 자리 0 불가
            if(ten == 0) continue;
            // 10의 자리 수 + 1의 자리 수로 두 자리 숫자 만들기
            int num = ten * 10 + one;
            // 알파벳 범위 안에 있다면 2자리 수 뺀 값도 더해주기
            if(num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[password.length()]);
    }
}