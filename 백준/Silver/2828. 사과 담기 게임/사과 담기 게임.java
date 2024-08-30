import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 한 사과가 바닥에 떨어지는 즉시 다른 사과가 떨어짐
     * 떨어지는 모든 사과 받기 (그리디)
     */
    static int N, M;
    static int[] screen, basket;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 스크린 크기
        M = Integer.parseInt(st.nextToken()); // 바구니 크기

        screen = new int[N];
        basket = new int[M];

        int start = 0; // 바구니 시작
        int end = M - 1; // 바구니 끝

        int cnt = Integer.parseInt(br.readLine()); // 사과 개수
        int sum = 0; // 이동 거리

        for(int i = 0; i < cnt; i++) {

            int idx = Integer.parseInt(br.readLine()) - 1;

            if(idx < start) { // 사과가 바구니 왼쪽에 있으면
                int diff = start - idx; // 바구니 시작을 idx로 이동
                sum += diff; // 이동 거리에 더해주기
                start = idx;
                end = idx + M - 1;
            } else if(idx > end) { // 사과가 바구니 오른쪽에 있으면
                int diff = idx - end;
                sum += diff;
                end = idx;
                start = idx - M + 1;
            }
        }

        System.out.println(sum);
    }
}