import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {

    static int n;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        // 인덱스 활용하기 쉽게 1 ~ n까지 계단 값 입력
        stairs = new int[n + 1];
        for(int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }
        // 동적 계산법
        int[] dp = new int[n + 1];
        // 하나 오를 땐 첫 계단 저장
        dp[1] = stairs[1];
        // 2계단 이상일 때
        if(n >= 2){
            // 2계단까지는 어차피 무조건 올라야 함
            dp[2] = stairs[1] + stairs[2];
            // 3계단부터 비교 시작
            // 일단 마지막 계단은 무조건 밟아야 함
            // 그 전까지 오는 과정에서 바로 전 계단 밟는 게 좋은지, 안 밟는 게 좋은지 비교
            // 근데 바로 전 계단도 dp로 보면 이게 지금 3번째 계단인지 알 수가 없다.
            // 바로 전 계단은 그냥 값을 더해줘야 함 (여기 이해는 했으나 내가 스스로 생각은 못할 듯..)
            for(int i = 3; i <= n; i++){
                dp[i] = stairs[i] + Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]);
            }
        }
        System.out.println(dp[n]);
    }
}