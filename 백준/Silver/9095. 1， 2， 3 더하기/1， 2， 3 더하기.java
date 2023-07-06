import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int tc = 0; tc < testCase; tc++){
            int n = sc.nextInt();
            int[] dp = new int[12];
                dp[1] = 1;
                dp[2] = 2;
                dp[3] = 4;
                dp[4] = 7;
            for(int i = 5; i < 12; i++){
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            System.out.println(dp[n]);
        }
    }
}