import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for(int i = 0; i < N; i++) {

            String str = br.readLine();

            if(str.equals("ENTER")) {
                cnt += map.size();
                map = new HashMap<>();
            } else {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }

        cnt += map.size();
        System.out.println(cnt);
    }
}