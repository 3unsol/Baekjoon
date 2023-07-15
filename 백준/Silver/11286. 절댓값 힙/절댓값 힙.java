import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 절대값 비교해서 작은 게 앞으로
                if(Math.abs(o1) > Math.abs(o2)){
                    return Math.abs(o1) - Math.abs(o2);
                    // 절대값이 같으면 작은 수(음수)를 앞으로
                }else if(Math.abs(o1) == Math.abs(o2)){
                    return o1 - o2;
                }
                return -1;
            }
        });
        for(int i = 0; i < n; i++){
            int c = Integer.parseInt(br.readLine());
            // 정수라면 heap에 입력
            if(c != 0){
                heap.offer(c);
                // 0이라면
            }else{
                // heap이 비었을 때
                if(heap.isEmpty()){
                    // 0 출력
                    System.out.println(0);
                    // heap이 안 비었다면
                }else{
                    // 맨 앞 뽑아서 출력
                    System.out.println(heap.poll());
                }
            }
        }
    }
}