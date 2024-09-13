import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M, sum;
    static Map<Character, Integer> map;
    static String[] dna;
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dna = new String[N];

        for(int i = 0; i < N; i++) {
            dna[i] = br.readLine();
        }

        count();

        System.out.println(ans);
        System.out.println(sum);
    }

    static void count() {

        for(int i = 0; i < M; i++) {

            map = new HashMap<>();

            for(int j = 0; j < N; j++) {
                char c = dna[j].charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            int max = 0;
            char ch = ' ';

            Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();

            while(it.hasNext()) {
                Map.Entry<Character, Integer> entrySet = (Map.Entry<Character, Integer>) it.next();
                int value = entrySet.getValue();
                char key = entrySet.getKey();

                if (max < value) {
                    max = value;
                    ch = key;
                } else if (max == value) {
                    char temp = key;

                    int num1 = Character.getNumericValue(ch);
                    int num2 = Character.getNumericValue(temp);

                    if (num1 > num2) {
                        ch = temp;
                    }
                }
            }

            sum += N - max;
            ans.append(ch);
        }
    }
}