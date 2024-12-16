import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int N;
    static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        if(N <= 10) {
            System.out.println(N);
            return;
        } else if (N >= 1023) {
            System.out.println(-1);
            return;
        }

        for(int i = 0; i < 10; i++) {
            comb(i);
        }

        Collections.sort(list);
        System.out.println(list.get(N));
    }

    static void comb(long number) {

        list.add(number);

        long val = number % 10;
        if(val == 0) return;

        for(long i = val - 1; i >= 0; i--) {
            long num = number * 10 + i;
            comb(num);
        }
    }
}