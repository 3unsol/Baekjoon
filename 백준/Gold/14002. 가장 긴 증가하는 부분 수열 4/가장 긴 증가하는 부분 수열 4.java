import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        dp = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        findLCS();
    }

    static void findLCS() {
        // 최장 길이
        int max = 1;
        // 모든 배열 탐색
        for(int i = 0; i < N; i++) {
            // 일단 최소 하나
            dp[i] = 1;
            // i : 현재 인덱스, j : 내 앞에 애들 인덱스
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(max);

        // 수열 저장할 스택
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            // dp에 저장된 값이 최장 길이일 때
            if(dp[i] == max) {
                // 스택에 값 넣어주고
                stack.push(arr[i]);
                // 넣어줬으니 길이 줄이기
                max--;
            }
        }

        // 출력
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}