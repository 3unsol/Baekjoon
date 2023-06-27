import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> indexMap = new HashMap<>();
		HashMap<Integer, String> nameMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			indexMap.put(name, i);
			nameMap.put(i, name);
		}
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (isNum(str)) {
				System.out.println(nameMap.get(Integer.parseInt(str)));
			} else {
				System.out.println(indexMap.get(str));
			}
		}
	}

	public static boolean isNum(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}
}