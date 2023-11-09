import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[] lamp;

	public static void main(String[] args) throws Exception{
		input();
		binarySearch();
	}

	static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		lamp = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++){
			lamp[i] = Integer.parseInt(st.nextToken());
		}
	}

	static void binarySearch(){
		int start = 1;
		int end = N;
		while(start <= end){
			int mid = (start + end) / 2;
			if(canLight(mid)){
				end = mid - 1;
				ans = mid;
			}else{
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}

	static boolean canLight(int h){
		int prev = 0;
		for(int i = 0; i < M; i++){
			// 내 앞에 조명이 비친 곳까지 닿는지 확인
			if(lamp[i] - h <= prev){
				prev = lamp[i] + h;
			}else{
				return false;
			}
		}
		// 마지막 가로등이 비추는 곳이 굴다리 길이보다 같거나 커야 함
		return N - prev <= 0;
	}
}