import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		HashMap<String, String> hearMap = new HashMap<>();
		List<String> names = new ArrayList<String>();

		for (int i = 0; i < n; i++) {
			String name = br.readLine();
			hearMap.put(name, name);
		}

		for (int i = 0; i < m; i++) {
			String name = br.readLine();
			if (!hearMap.containsKey(name)) {
				continue;
			} else {
				names.add(name);
			}
		}

		Collections.sort(names);

		for (int i = 0; i < names.size(); i++) {
			sb.append(names.get(i)).append("\n");
		}

		System.out.println(names.size());
		System.out.println(sb);
	}
}