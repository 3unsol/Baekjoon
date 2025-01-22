import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == C) { // 하나가 C면 멈춤
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            // 이미 C 넘으면 그만
            if(arr[i] > C) break;

            // 두 개의 합
            for(int j = i + 1; j < N; j++) {
                if(arr[i] + arr[j] == C) {
                    System.out.println(1);
                    return;
                }
                // 세 개의 합 (나머지 하나는 이분탐색)
                int start = 0;
                int end = N - 1;
                while(start <= end) {
                    int mid = (start + end) / 2;
                    // 세 개의 합이 C일 때
                    if(arr[i] + arr[j] + arr[mid] == C) {
                        // 중복 금지
                        if(mid != i && mid != j) {
                            System.out.println(1);
                            return;
                        }
                    }
                    // C보다 크다면 줄이기
                    if(arr[i] + arr[j] + arr[mid] > C) {
                        end = mid - 1;
                    } else { // C보다 작다면 늘리기
                        start = mid + 1;
                    }
                }
            }
        }
        System.out.println(0);
    }
}