import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 케이스
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 1; t <= testCase; t++) {
            // 명령어
            String p = br.readLine();
            // 정수 개수
            int n = Integer.parseInt(br.readLine());
            // 덱 생성
            Deque<Integer> deque = new ArrayDeque<>();
            // ','로 끊어서 저장
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            for(int i = 0; i < n; i++){
                    deque.offer(Integer.parseInt(st.nextToken()));
            }
            // 명령어 실행
            // 방향 플래그
            boolean isBack = false;
            boolean flag = false;
            for(int i = 0; i < p.length(); i++){
                // 방향 바꾸기
                if(p.charAt(i) == 'R'){
                    isBack = !isBack;
                    // 첫번째 수 꺼내기
                }else{
                    if(deque.size() == 0){
                        flag = true;
                        break;
                    }
                    if(isBack){
                        deque.pollLast();
                    }else {
                        deque.pollFirst();
                    }
                }
            }
            if(flag){
                System.out.println("error");
            }else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!deque.isEmpty()){
                    if(isBack) {
                        sb.append(deque.pollLast());
                    }else{
                        sb.append(deque.pollFirst());
                    }
                    if(deque.size()!=0){
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}