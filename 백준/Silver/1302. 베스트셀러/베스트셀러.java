import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> books = new HashMap<>();

        int max = 0;

        for(int i = 0; i < n; i++){
            String title = sc.next();
                books.put(title, books.getOrDefault(title, 0) + 1);
                max = Math.max(max, books.get(title));
        }

        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : books.entrySet()){
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}