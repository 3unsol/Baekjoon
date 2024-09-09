import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int r = 0; r < N; r++) {
            String str = br.readLine();
            int cloud = -1;
            for(int c = 0; c < M; c++) {
                if(str.charAt(c) == 'c'){
                    sb.append("0 ");
                    cloud = c;
                }
                else if(cloud == -1) {
                    sb.append(-1).append(" ");
                }
                else {
                    sb.append(c - cloud).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}