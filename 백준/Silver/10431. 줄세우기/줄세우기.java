import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			int[] arr = new int[20];
			int[] result = new int[20];
			for(int i = 0; i < 20; i++){
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int cnt = 0;
			result[0] = arr[0];
			for(int i = 1; i < 20; i++){
				for(int j = 0; j < i; j++){
					if(result[j] > arr[i]){
						for(int k = i; k > j; k--){
							result[k] = result[k - 1];
						}
						cnt += i - j;
						result[j] = arr[i];
						break;
					}else{
						result[i] = arr[i];
					}
				}
			}
			System.out.println(t + " " + cnt);
		}
	}
}