import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<String, Integer> map = new HashMap<>();

        int total = 0;
        String name;

        while((name = br.readLine()) != null) {
            total++;
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for(String tree : list) {
            int cnt = map.get(tree) * 100;
            sb.append(tree + " " + String.format("%.4f", (double)cnt / (double)total) + "\n");
        }

        System.out.print(sb);
    }
}