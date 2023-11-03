import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dayDp = new int[31][2];
		dayDp[1][0] = 1;
		dayDp[2][1] = 1;
		dayDp[3][0] = 1;
		dayDp[3][1] = 1;
		dayDp[4][0] = 1;
		dayDp[4][1] = 2;
		dayDp[5][0] = 2;
		dayDp[5][1] = 3;
		for(int i = 6; i <= 30; i++){
			dayDp[i][0] = dayDp[i - 1][0] + dayDp[i - 2][0];
			dayDp[i][1] = dayDp[i - 1][1] + dayDp[i - 2][1];
		}
		int aNum = dayDp[D][0];
		int bNum = dayDp[D][1];
		int idx = 1;
		while(true){
			int A = aNum * idx;
			if((K - A) % bNum == 0){
				System.out.println(idx);
				System.out.println((K - A) / bNum);
				break;
			}else{
				idx++;
			}
		}
	}
}