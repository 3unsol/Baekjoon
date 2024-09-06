import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int burgerCnt, sideCnt, drinkCnt;
    static List<Integer> burger, side, drink;
    static int total;

    public static void main(String[] args) throws Exception {

        st = new StringTokenizer(br.readLine());

        burgerCnt = Integer.parseInt(st.nextToken());
        sideCnt = Integer.parseInt(st.nextToken());
        drinkCnt = Integer.parseInt(st.nextToken());

        burger = new ArrayList<>();
        side = new ArrayList<>();
        drink = new ArrayList<>();

        input(burgerCnt, burger);
        input(sideCnt, side);
        input(drinkCnt, drink);

        System.out.println(total);

        int minCnt = Math.min(Math.min(burgerCnt, sideCnt), drinkCnt);

        for(int i = 0; i < minCnt; i++) {
            int sum = burger.get(i) + side.get(i) + drink.get(i);
            total -= sum * 0.1;
        }

        System.out.println(total);
    }

    static void input(int num, List<Integer> list) throws Exception {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            list.add(Integer.parseInt(st.nextToken()));
            total += list.get(i);
        }
        Collections.sort(list, Collections.reverseOrder());
    }

}