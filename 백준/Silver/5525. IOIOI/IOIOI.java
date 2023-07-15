import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String str = "I";
        for(int i = 0; i < n; i++){
            str += "OI";
        }
        String s = br.readLine();
        int cnt = 0;
        for(int i = 0; i <= s.length() - str.length(); i++){
            if(s.charAt(i) == 'O') continue;
            boolean flag = true;
            for(int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != s.charAt(i + j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        System.out.println(cnt);
    }
}