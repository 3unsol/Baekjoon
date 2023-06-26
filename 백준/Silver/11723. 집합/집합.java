import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int bitSet = 0;
		while (n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num;
			switch (str) {
			case "add":
				num = Integer.parseInt(st.nextToken());
				bitSet |= (1 << (num - 1));
				break;
			case "remove":
				num = Integer.parseInt(st.nextToken());
				bitSet = bitSet & ~(1 << (num - 1));
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb.append((bitSet & (1 << (num - 1))) == 0 ? "0\n" : "1\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				bitSet ^= (1 << (num - 1));
				break;
			case "all":
				bitSet |= ~0;
				break;
			case "empty":
				bitSet &= 0;
				break;
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}