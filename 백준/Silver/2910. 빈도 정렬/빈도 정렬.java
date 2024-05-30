import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        //LinkedHashMap : 순서가 있는 해시맵!!!
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            linkedHashMap.put(num, linkedHashMap.getOrDefault(num, 0) + 1);
        }

        // 맵을 리스트로 저장!!!
        List<Integer> list = new ArrayList<>(linkedHashMap.keySet());

        // 내림차순 정렬
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return linkedHashMap.get(o2) - linkedHashMap.get(o1);
            }
        });

        for(int num : list) {
            for(int i = 0; i < linkedHashMap.get(num); i++) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}