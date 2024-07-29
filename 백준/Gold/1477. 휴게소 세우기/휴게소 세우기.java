import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, L;
    static int[] restArea;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        restArea = new int[N + 2]; // 시작과 끝도 넣기 위해 N + 2로 초기화

        restArea[0] = 0; // 시작
        restArea[N + 1] = L; // 끝

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            restArea[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(restArea);

        int start = 1;
        int end = L - 1;

        while(start <= end) {

            int mid = (start + end) / 2;

            int sum = 0;

            for(int i = 1; i < restArea.length; i++) {
                sum += (restArea[i] - restArea[i - 1] - 1) / mid; // 지금 휴게소 사이에 몇 개의 휴게소 설치 가능한지
            }

            if(sum > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);
    }
}