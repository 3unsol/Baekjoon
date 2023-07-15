import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            int c = Integer.parseInt(br.readLine());
            if(c != 0){
                heap.offer(c);
            }else{
                if(heap.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(heap.poll());
                }
            }
        }
    }
}