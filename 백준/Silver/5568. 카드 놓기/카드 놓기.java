import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int N, K;
    static int[] cards;
    static boolean[] isUsed;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        cards = new int[N];
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(br.readLine());
        }

        isUsed = new boolean[N];

        perm(0, "");

        System.out.println(set.size());
    }

    static void perm(int depth, String str) {

        if(depth == K) {
            set.add(str);
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                perm(depth + 1, str + cards[i]);
                isUsed[i] = false;
            }
        }
    }
}