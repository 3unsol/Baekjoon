import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * A + B + C = K -> A + B = K - C
 * 삼중포문으로 하면 시간 초과 -> 이중포문으로 해결한다!
 */
public class Main {

    static int N;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // A + B 값 set에 저장
        for(int i = 0; i < N; i++) { // A
            for(int j = i; j < N; j++) { // B
                set.add(arr[i] + arr[j]);
            }
        }

        int max = 0;

        // K - C 가 set에 있는지 확인 후 젤 큰 값 저장
        for(int i = 0; i < N; i++) { // K
            for(int j = 0; j < N; j++) { // C
                if(set.contains(arr[i] - arr[j])) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
    }
}