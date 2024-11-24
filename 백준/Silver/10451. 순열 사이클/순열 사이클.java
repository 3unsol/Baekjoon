import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, cnt;
    static int[] arr;
    static boolean[] isVisited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            cnt = 0;
            isVisited = new boolean[N + 1];
            for(int i = 1; i <= N; i++) {
                if(!isVisited[i]) {
                    checkCycle(i);
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    static void checkCycle(int num) {
        isVisited[num] = true;
        if(!isVisited[arr[num]]) {
            checkCycle(arr[num]);
        }
    }
}