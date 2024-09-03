import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true) {

            String str = br.readLine();
            if(str == null) break;

            st = new StringTokenizer(str, " ");

            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;

            for(int i = 0; i < t.length(); i++) {
                if(t.charAt(i) == s.charAt(idx)) {
                    idx++;
                }
                if(idx == s.length()) break;
            }

            if(idx == s.length()) sb.append("Yes");
            else sb.append("No");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}