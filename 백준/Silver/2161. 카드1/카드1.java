import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++){
			q.offer(i);
		}
		while(!q.isEmpty()){
			int tmp = q.poll();
			System.out.print(tmp + " ");
			if(q.size() != 0){
				tmp = q.poll();
				q.offer(tmp);
			}
		}
	}
}