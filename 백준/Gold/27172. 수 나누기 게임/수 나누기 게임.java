import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr, pos, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 입력값
            if(max < arr[i]) max = arr[i]; // 최대값 크기만큼 배열 만들기
        }

        pos = new int[max + 1];
        for(int i = 1; i <= N; i++) {
            pos[arr[i]] = i; // 인덱스 : 카드 숫자, 값 : 갖고 있는 사람
        }

        ans = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            for(int j = arr[i] * 2; j <= max; j += arr[i]) {
                if(pos[j] != 0) {
                    ans[i]++;
                    ans[pos[j]]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.print(sb);
    }
}