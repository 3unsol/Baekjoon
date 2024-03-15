import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            N = Integer.parseInt(br.readLine());
            sb = new StringBuilder();
            perm(1, 1, 0, 1, "1");
            System.out.println(sb);
        }
    }

    // k : 넣을 숫자, next : 만든 숫자, result : 계산된 값, sign : 부호, str : 만든 문자열
    static void perm(int k, int next, int result, int sign, String str) {

        // 마지막 숫자까지 왔으면
        if(k == N) {
            result += (next * sign);
            // 결과가 0이면 출력
            if(result == 0) sb.append(str).append("\n");
            return;
        }

        perm(k + 1, next * 10 + (k + 1), result, sign, str + " " + (k + 1));
        perm(k + 1, k + 1, result + (next * sign), 1, str + "+" + (k + 1));
        perm(k + 1, k + 1, result + (next * sign), -1, str + "-" + (k + 1));
    }
}