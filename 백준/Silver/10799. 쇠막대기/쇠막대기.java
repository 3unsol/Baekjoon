import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1. '(' -> stick++
 * 2. ')'
 * 2-1. 레이저? -> ans += stick
 * 2-2. 쇠막대끝? -> ans + 1
 */
public class Main {
    static int stick, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            char order = str.charAt(i);

            if(order == '(') {
                stick++;
            } else {
                stick--;
                if(str.charAt(i - 1) == '(') {
                    ans += stick;
                } else {
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}