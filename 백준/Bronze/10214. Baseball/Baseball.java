import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t = 0; t < testCase; t++){
			int yonsei = 0;
			int korea = 0;
			for(int i = 0; i < 9; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				yonsei += Integer.parseInt(st.nextToken());
				korea += Integer.parseInt(st.nextToken());
			}
			if(yonsei > korea){
				System.out.println("Yonsei");
			}else if(korea > yonsei){
				System.out.println("Korea");
			}else{
				System.out.println("Draw");
			}
		}
	}
}