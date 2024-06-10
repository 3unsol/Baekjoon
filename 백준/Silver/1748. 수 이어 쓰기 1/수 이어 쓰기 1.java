import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0; // 자릿수
        int plus = 1; // 자릿수마다 더하는 값
        int num = 10; // 다음 자릿수 확인용으로 늘려주는 값

        for(int i = 1; i <= N; i++) {
            if(i % num == 0) { // 자릿수가 바뀌면
                plus++;
                num *= 10;
            }
            cnt += plus;
        }

        System.out.println(cnt);
    }
}