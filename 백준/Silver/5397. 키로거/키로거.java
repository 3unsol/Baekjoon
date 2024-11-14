import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * ListIterator에 대해 공부해봅시다.
 * List 컬렉션에서 제공하는 인터페이스
 * 리스트를 양방향으로 탐색하고 수정할 수 있는 기능
 * 메서드 하나씩 살펴보기
 * next() : 다음 요소 반환 + 커서 다음 위치로
 * previous() : 이전 요소 반환 + 커서 이전 위치로
 * hasNext() : 커서 뒤에 요소 있는지 확인
 * hasPrevous() : 커서 앞에 요소 있는지 확인
 * remove() : 마지막 요소 제거
 */

public class Main {

    static String order;
    static LinkedList<Character> list;
    static ListIterator<Character> listIterator;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= testCase; tc++) {
            order = br.readLine();
            list = new LinkedList<>();

            // ListIterator 생성 방법
            listIterator = list.listIterator();

            for(int i = 0; i < order.length(); i++) {
                char now = order.charAt(i);
                if (now == '<') {
                    if(listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                } else if (now == '>') {
                    if(listIterator.hasNext()) {
                        listIterator.next();
                    }
                } else if (now == '-') {
                    if(listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                } else {
                    listIterator.add(now);
                }
            }
            // LinkedList는 ArrayList와 달리 get() 메서드에서 시간 복잡도가 O(L^2)
            // LinkedList는 인덱스 기반 접근이 비효율적이므로 for each문을 통해 접근하는 게 좋다.
            sb = new StringBuilder();
            for(char c : list) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}