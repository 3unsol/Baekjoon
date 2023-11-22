import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int sequenceSize;
	static int[] sequence, LIS;

	public static void main(String[] args) throws Exception {
		input();
		lowerBound();
	}

	static void input() throws Exception {

		sequenceSize = Integer.parseInt(br.readLine());

		sequence = new int[sequenceSize];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < sequenceSize; i++){
			sequence[i] = Integer.parseInt(st.nextToken());
		}

		LIS = new int[sequenceSize];

	}

	static void lowerBound(){

		LIS[0] = sequence[0];
		int lengthOfLIS = 1;

		for(int i = 1; i < sequenceSize; i++){

			if(sequence[i] > LIS[lengthOfLIS - 1]){
				lengthOfLIS++;
				LIS[lengthOfLIS - 1] = sequence[i];
			}

			int start = 0;
			int end = lengthOfLIS;

			while(start < end){

				int mid = (start + end) >>> 1;

				if(sequence[i] > LIS[mid]){
					start = mid + 1;
				}
				else {
					end = mid;
				}
			}

			LIS[start] = sequence[i];
		}
		System.out.println(lengthOfLIS);
	}
}