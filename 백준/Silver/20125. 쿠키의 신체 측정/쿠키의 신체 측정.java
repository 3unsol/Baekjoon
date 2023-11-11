import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, waistLength, leftArm, rightArm, leftLeg, rightLeg;
	static char[][] cookie;
	static Node head, heart, waist;
	public static void main(String[] args) throws Exception {
		input();
		checkCookie();
		System.out.println(heart.r + 1 + " " + (heart.c + 1));
		System.out.println(leftArm + " " + rightArm + " " + waistLength + " " + leftLeg + " " + rightLeg);
	}

	static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cookie = new char[N][N];
		for(int r = 0; r < N; r++){
			String str = br.readLine();
			for(int c = 0; c < N; c++){
				cookie[r][c] = str.charAt(c);
			}
		}

		outer: for(int r = 0; r < N; r++){
			for(int c = 0; c < N; c++){
				if(cookie[r][c] == '*'){
					head = new Node(r, c);
					heart = new Node(r + 1, c);
					waist = new Node(r + 2, c);
					break outer;
				}
			}
		}
	}

	static void checkCookie(){
		// 팔
		int left = N;
		int right = 0;
		for(int c = 0; c < N; c++){
			if(cookie[heart.r][c] == '*'){
				left = Math.min(left, c);
				right = Math.max(right, c);
			}
		}
		leftArm = heart.c - left;
		rightArm = right - heart.c;

		// 허리
		int core = 0;
		for(int r = waist.r; r < N; r++){
			if(cookie[r][waist.c] =='*'){
				core = Math.max(core, r);
				waistLength++;
			}
		}

		// 다리
		Node leftStart = new Node(core + 1, waist.c - 1);
		Node rightStart = new Node(core + 1, waist.c + 1);
		for(int r = leftStart.r; r < N; r++){
			if(cookie[r][leftStart.c] == '*'){
				leftLeg++;
			}else{
				break;
			}
		}
		for(int r = rightStart.r; r < N; r++){
			if(cookie[r][rightStart.c] == '*'){
				rightLeg++;
			}else{
				break;
			}
		}
	}
	static class Node{
		int r;
		int c;
		public Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}