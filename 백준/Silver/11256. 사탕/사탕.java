import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int j, n;
    static List<Integer> box;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= testCase; tc++) {
            st = new StringTokenizer(br.readLine());

            j = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            box = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                box.add(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
            }

            Collections.sort(box, Collections.reverseOrder());

            int cnt = 1;

            for(int i = 0; i < n; i++) {

                if(j <= 0) {
                    sb.append(cnt).append("\n");
                    break;
                }

                if(box.get(i) < j) {
                    cnt++;
                }

                j -= box.get(i);
            }
        }
        System.out.print(sb);
    }
}