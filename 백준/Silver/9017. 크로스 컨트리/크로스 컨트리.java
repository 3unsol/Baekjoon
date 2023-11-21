import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br;
	static int N;
	static int[] race, teamHeadCount, teamScore, fifthScore;
	static boolean[] isOverSix;
	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= testCase; tc++){
			input();
			isPossible();
			race();
			System.out.println(check());
		}
	}

	static void input() throws Exception {

		N = Integer.parseInt(br.readLine());
		race = new int[N];
		teamHeadCount = new int[201];
		isOverSix = new boolean[201];
		teamScore = new int[201];
		fifthScore = new int[201];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++){
			int tmp = Integer.parseInt(st.nextToken());
			race[i] = tmp;
			teamHeadCount[tmp]++;
		}
	}
	static void isPossible(){
		for(int i = 1; i < 201; i++){
			if(teamHeadCount[i] >= 6){
				isOverSix[i] = true;
			}
		}
	}

	static void race(){
		int[] tmpCnt = new int[201];
		int rank = 1;
		for(int i = 0; i < N; i++){
			if(isOverSix[race[i]]) {
				tmpCnt[race[i]]++;
				if (tmpCnt[race[i]] <= 4) {
					teamScore[race[i]] += rank;
				} else if (tmpCnt[race[i]] == 5) {
					fifthScore[race[i]] = rank;
				}
				rank++;
			}
		}
	}

	static int check(){

		int minScore = Integer.MAX_VALUE;
		for(int i = 0; i < 201; i++){
			if(teamScore[i] == 0){
				teamScore[i] = Integer.MAX_VALUE;
			}
			minScore = Math.min(teamScore[i], minScore);
		}

		int min = Integer.MAX_VALUE;
		int winner = 0;
		for(int i = 0; i < 201; i++){
			if(teamScore[i] == minScore){
				if(min > fifthScore[i]){
					min = fifthScore[i];
					winner = i;
				}
			}
		}
		return winner;
	}
}