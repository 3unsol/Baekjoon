import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, H;
    static int[] down, up;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        down = new int[H + 1];
        up = new int[H + 1];

        // 종유석, 석순 크기대로 몇 개 있는지 저장
        for(int i = 0; i < N / 2; i++) {
            down[Integer.parseInt(br.readLine())]++;
            up[Integer.parseInt(br.readLine())]++;
        }

        // 누적합 (해당 인덱스를 뚫었을 때 몇 개 뚫어야하는지 저장하기 위해 거꾸로 저장해준다.
        // 4, 5, 6층에 석순이 있다면
        // 4층은 3개 뚫어야 함. 5층까지 2개 + 4층에 있는 나
        // 그래서 거꾸로 누적합 저장하는 것!!!
        for(int i = H; i > 1; i--) {
            down[i - 1] += down[i];
            up[i - 1] += up[i];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i = 1; i <= H; i++) {

            int tmpSum = down[i] + up[H - i + 1];

            if(min > tmpSum) {
                min = tmpSum;
                cnt = 1;
            } else if (min == tmpSum) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}