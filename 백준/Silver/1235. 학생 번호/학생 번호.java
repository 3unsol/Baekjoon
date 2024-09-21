import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int N, K, length;
    static String[] numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new String[N];

        for(int i = 0; i < N; i++) {
            numbers[i] = br.readLine();
        }

        length = numbers[0].length();

        find();

        System.out.println(K);
    }

    static void find() {

        int ten = 1;

        while(true) {

            if(K == length) break;

            Set<String> set = new HashSet<>();

            for(int i = 0; i < N; i++) {
                String now = numbers[i].substring(length - ten);
                if(set.contains(now)) break;
                set.add(now);
            }

            if(set.size() == N) {
                K = ten;
                return;
            } else {
                ten++;
            }
        }
    }
}