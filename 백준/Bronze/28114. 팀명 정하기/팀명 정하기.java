import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        int[] year = new int[3];
        int[] solve = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken()) % 100;
            String name = st.nextToken();
            year[i] = y;
            solve[i] = s;
            map.put(s, name);
        }

        Arrays.sort(solve);
        Arrays.sort(year);

        for (int i = 0; i < 3; i++) {
            sb.append(year[i]);
        }
        sb.append("\n");
        for (int i = 2; i >= 0; i--) {
            sb.append(map.get(solve[i]).charAt(0));
        }
        System.out.print(sb);

    }
	
}