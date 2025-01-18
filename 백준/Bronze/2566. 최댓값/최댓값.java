import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = 0;
        int r = 1;
        int c = 1;

        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(max < now) {
                    max = now;
                    r = i + 1;
                    c = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.println(r + " " + c);
    }
}