import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, myScore, P, rank, sameRank;
	static Integer[] score;

	public static void main(String[] args) throws Exception {
		input();
	}

	static void input() throws Exception {

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		myScore = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		if(N == 0){
			System.out.println(1);
			return;
		}

		score = new Integer[N];
		st = new StringTokenizer(br.readLine());
		rank = 1;
		sameRank = 0;

		for(int i = 0; i < N; i++){
			int tempScore = Integer.parseInt(st.nextToken());
			if(tempScore > myScore){
				rank++;
			} else if(tempScore == myScore){
				sameRank++;
			}
		}

		if(rank + sameRank > P){
			System.out.println(-1);
			return;
		}

		System.out.println(rank);
	}
}