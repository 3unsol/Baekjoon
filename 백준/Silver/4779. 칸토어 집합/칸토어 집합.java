import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static int n;
	static StringBuilder sb;

	// 배열로 만들었더니 스캐너든 버퍼드든 무한 입력을 받았다...
	// 배열 버리고 stringbuilder 사용
	// 미리 '-' 만들어놓고
	// 가운데를 ' '로 설정하는 방법 -> sb.setCharAt()이라는 게 있다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str;
		while ((str = br.readLine()) != null) { // 입력값 몇 갠지 안 알려줬을 때
			int n = Integer.parseInt(str); // n값
			sb = new StringBuilder(); // 답
			int length = (int) Math.pow(3, n); // 3의 n제곱
			for (int i = 0; i < length; i++) { // 배열 돌면서
				sb.append("-");
			}
			cantor(0, length); // 재귀
			System.out.println(sb);
		}
	}

	// 칸토어 집합
	// start : 시작할 곳
	// cutSize : 자를 크기
	static void cantor(int start, int cutSize) {
		if (cutSize == 1) { // 1이면 끝
			return;
		}
		int tmpSize = cutSize / 3; // 지금 자를 크기
		for (int i = start + tmpSize; i < start + (2 * tmpSize); i++) { // 가운데 부분 공백 만들기
			sb.setCharAt(i, ' ');
		}
		cantor(start, tmpSize); // 왼쪽
		cantor(start + (2 * tmpSize), tmpSize); // 오른쪽
	}
}