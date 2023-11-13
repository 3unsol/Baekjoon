import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int day, max;
	static long profit;
	static int[] stock;
	public static void main(String[] args) throws Exception {
		// 입력값
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 1; t <= testCase; t++){
			day = Integer.parseInt(br.readLine());
			stock = new int[day];
			profit = 0;
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < day; i++){
				stock[i] = Integer.parseInt(st.nextToken());
			}
			max = stock[day - 1];
			doStock();
			System.out.println(profit);
		}
	}

	static void doStock(){
		for(int i = day - 2; i >= 0; i--){
			if(stock[i] < max){
				profit += max - stock[i];
			}else if(stock[i] > max){
				max = stock[i];
			}
		}
	}
}