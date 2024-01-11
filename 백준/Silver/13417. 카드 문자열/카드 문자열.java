import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static List<Character> card;
    static Deque<Character> deque;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++){
            input();
            order();
            makeStr();
            System.out.println(sb);
        }
    }

    static void input() throws Exception {

        N = Integer.parseInt(br.readLine());
        card = new ArrayList<>();
        String str = br.readLine();

        for(int i = 0; i < N * 2 - 1; i++){
            char c = str.charAt(i);
            if(c != ' '){
                card.add(c);
            }
        }
    }

    static void order() {

        deque = new ArrayDeque<>();
        deque.offer(card.get(0));

        for(int i = 1; i < N; i++) {
            if (card.get(i) > deque.peek()) {
                deque.offerLast(card.get(i));
            } else {
                deque.offerFirst(card.get(i));
            }
        }
    }

    static void makeStr() {

        sb = new StringBuilder();

        while(!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
    }
}