import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        long cnt = 0;

        // 숫자 하나 고정하고 나머지 두 개는 이분탐색
        for(int i = 0; i < N; i++) {

            // 이미 0이 넘으면 앞으로의 조합도 0이 넘음
            if(arr[i] > 0) break;

            // i와 그 뒤 숫자들을 조합
            int start = i + 1;
            int end = N - 1;

            while(start < end) {
                
                // 세 수의 합
                int sum = arr[i] + arr[start] + arr[end];

                // 세 수의 합이 0일 때
                if(sum == 0) {
                    // 두 수가 같을 때 -> 그 사이의 값들도 다 같음 -> N개 중 2개 고르는 개수 더해줌
                    if(arr[start] == arr[end]) {
                        cnt += comb(end - start + 1);
                        break;
                    }

                    // 왼쪽, 오른쪽에서의 동일한 숫자의 개수
                    int left = 1;
                    int right = 1;
                    
                    // 작은 수가 동일한 경우 모두 세기
                    while(arr[start] == arr[start + 1]) {
                        left++;
                        start++;
                    }
                    // 큰 수가 동일한 경우 모두 세기
                    while(arr[end] == arr[end - 1]) {
                        right++;
                        end--;
                    }

                    // 그 곱이 조합의 개수로 더해짐
                    cnt += left * right;
                }

                // 세 수의 합이 0이 아닐 때 인덱스 이동
                if(sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }

        System.out.println(cnt);
    }

    static int comb(int N) {
        return N * (N - 1) / 2;
    }
}