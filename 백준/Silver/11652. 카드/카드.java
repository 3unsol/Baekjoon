import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long max = 0;
        Map<Long, Long> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            long num = sc.nextLong();
            map.put(num, map.getOrDefault(num, 0l) + 1);
            max = Math.max(max, map.get(num));
        }

        List<Long> list = new ArrayList<>();
        for(Map.Entry<Long, Long> entry : map.entrySet()){
            if(entry.getValue() == max){
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);

        System.out.println(list.get(0));
    }
}