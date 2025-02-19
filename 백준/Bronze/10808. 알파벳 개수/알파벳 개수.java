import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] cnt = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            cnt[c]++;
        }
        for(int i = 0; i < 26; i++) {
            System.out.print(cnt[i] + " ");
        }
    }
}