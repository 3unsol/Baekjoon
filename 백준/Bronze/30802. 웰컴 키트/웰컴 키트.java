import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int tShirts = 0;

        for(int i = 0; i < 6; i++) {
            if(size[i] == 0) continue;
            tShirts += size[i] / T;
            if(size[i] % T > 0) tShirts++;
        }

        int penBundle = N / P;
        int pen = N % P;

        System.out.println(tShirts);
        System.out.println(penBundle + " " + pen);
    }
}