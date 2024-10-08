import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sb.append((int) (Math.pow(2, N) - 1)).append("\n");
        hanoi(N,1, 2, 3);
        System.out.println(sb);
    }

    /**
     * @param N // 원판 개수
     * @param start // 출발
     * @param mid // 옮길 장소
     * @param end // 목적지
     */
    static void hanoi(int N, int start, int mid, int end) {

        if(N == 1) {
            sb.append(start + " " + end + "\n");
            return;
        }

        // N - 1개를 start에서 mid로 이동
        hanoi(N - 1, start, end, mid);

        sb.append(start + " " + end + "\n");

        // N - 1개를 mid에서 end로 이동
        hanoi(N - 1, mid, start, end);

    }
}