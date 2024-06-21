import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static long max;
    static int[] score;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        score = new int[N + K - 1]; // 원형이기 때문에 뒤에 K만큼 꼬리 배열을 만들어줌

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < K - 1; i++) {
            score[N + i] = score[i];
        }

        long sum = 0;
        for(int i = 0; i < K; i++) {
            sum += score[i];
        }

        max = sum;

        for(int end = K; end < score.length; end++) {
            int start = end - K;

            sum -= score[start];
            sum += score[end];

            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}