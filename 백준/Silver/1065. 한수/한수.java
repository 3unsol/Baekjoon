import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int number, cnt;
	
	public static void main(String[] args) throws Exception {
		
		input();
		find();
		System.out.println(cnt);
		
	}
	
	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		number = Integer.parseInt(br.readLine());
	}
	
	static void find() {
		
		if(number <= 99) {
			cnt = number;
			return;
		}
		
		else {
			cnt = 99;
			for(int i = 100; i <= number; i++) {
				int a = i / 100;
				int b = (i / 10) % 10;
				int c = i % 10;
				if(a - b == b - c) {
					cnt++;
				}
			}
		}
	}
}