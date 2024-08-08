import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 신발끈 공식
    // 다각형의 넓이를 구할 때는 다각형의 각 꼭짓점의 좌푯값을 교차하여 곱하면 된다.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N + 1][2]; // 각 꼭짓점의 좌표 + 마지막에 첫번째 좌표 저장 (교차곱을 위해)

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long sum = 0;
        for(int i = 0; i < N; i++) {
            sum += (long) arr[i][0] * arr[i + 1][1] - (long) arr[i + 1][0] * arr[i][1];
        }

        sum = Math.abs(sum); // 넓이니까 양수
        System.out.printf("%.1f", (double) sum / 2); // 소수점 첫 째 자리까지
    }
}