import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 용액 개수
        N = Integer.parseInt(br.readLine());
        // 용액들
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 두 포인터
        int start = 0;
        int end = N - 1;
        
        // 최소 차이
        int min = Integer.MAX_VALUE;

        // 최소 차이일 때 인덱스
        int solution1 = 0;
        int solution2 = 0;

        // 이분탐색
        while(start < end) {

            // 두 용액의 합
            int sum = arr[start] + arr[end];
            
            // 0이면 그만
            if(sum == 0) {
                System.out.println(arr[start] + " " + arr[end]);
                return;
            };

            // 두 용액의 합이 작으면 갱신
            if(min > Math.abs(sum)) {

                min = Math.abs(sum);

                solution1 = start;
                solution2 = end;
            }

            // 두 용액의 합이 0보다 크면 end값 줄여주기
            if(sum > 0) {
                end--;
                
                // 0보다 작으면 start값 늘려주기
            } else if(sum < 0) {
                start++;
            }

        }

        System.out.println(arr[solution1] + " " + arr[solution2]);
    }
}