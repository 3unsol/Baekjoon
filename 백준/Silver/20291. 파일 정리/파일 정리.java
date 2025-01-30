import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ".");
            String name = st.nextToken();
            String extension = st.nextToken();
            hashMap.put(extension, hashMap.getOrDefault(extension, 0) + 1);
        }
        Set<String> str = hashMap.keySet();
        List<String> list = new ArrayList<>(str);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " " + hashMap.get(list.get(i)));
        }
    }
}