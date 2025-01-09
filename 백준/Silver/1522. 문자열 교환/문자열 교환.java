import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문자열에서 a의 총 개수가 만들어야 할 부분문자열의 크기
 * a개수 크기의 부분문자열에서 b의 개수가 최소인 것 찾기
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int aCount = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a') aCount++;
        }

        int min = Integer.MAX_VALUE;
        // aCount 크기만큼 원형으로 탐색
        for(int i = 0; i < str.length(); i++) {
            int bCount = 0;
            for(int j = i; j < i + aCount; j++) {
                if(str.charAt(j % str.length()) == 'b') bCount++;
            }
            min = Math.min(min, bCount);
        }
        System.out.println(min);
    }
}