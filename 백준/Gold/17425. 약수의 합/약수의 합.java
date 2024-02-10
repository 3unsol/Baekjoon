import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int INF = 1000001; // N은 최대 1,000,000
    static long[] fx = new long[1000001]; // 약수의 합을 담을 배열
    static long[] gx = new long[1000001]; // 약수의 합의 누적합을 담을 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1은 모든 수의 약수니까 1로 채워놓기
        Arrays.fill(fx, 1);

        // 약수의 합 만들기
        // 2의 배수부터 백만까지 약수 채우기 시작
        for(int i = 2; i < INF; i++) {
            // j: i의 배수를 만들기 위한 변수
            // j값은 i일 때 더해줄 거니까 i만 더해준다.
            for(int j = 1; j * i < INF; j++) {
                fx[i * j] += i;
            }
        }

        // 약수의 합들 누적합으로 저장
        for(int i = 1; i < INF; i++) {
            gx[i] = gx[i - 1] + fx[i];
        }

        // testCase
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= testCase; tc++) {
            sb.append(gx[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.println(sb);
    }
}