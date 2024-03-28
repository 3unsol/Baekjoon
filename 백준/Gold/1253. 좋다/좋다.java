import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 개수
        int N = Integer.parseInt(br.readLine());
        // 숫자 배열
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 숫자 입력
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 숫자 정렬
        Arrays.sort(arr);

        // 모든 숫자 돌면서
        for(int i = 0; i < N; i++) {

            // 하나씩 타겟으로 설정
            int target = arr[i];
            // 두 포인터를 위한 인덱스 2개
            int start = 0;
            int end = N - 1;

            // 이분탐색 시작
            while(start < end) {

                // 두 수의 합
                int sum = arr[start] + arr[end];

                // 타겟과 같다면
                if(sum == target) {
                    // 다른 수로 본인을 만들어야 함!!! 본인이면 안 됨
                    if(i == start) {
                        start++;
                    } else if(i == end) {
                        end--;
                    } else {
                        cnt++;
                        break;
                    }
                }

                // 타겟보다 크면 end값 줄여주고 작으면 start값 늘려주기
                if(sum > target) {
                    end--;
                } else if(sum < target){
                    start++;
                }
            }
        }

        System.out.println(cnt);
    }
}