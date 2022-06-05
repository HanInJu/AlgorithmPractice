package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Q9 {
	static StringBuilder sbb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> ts = new TreeSet<>();

		String str = br.readLine();
		int len = str.length();
		for(int i = 1; i < len-1; i++) {
			for(int j = i+1; j < len; j++) {

				String sa = sbb.append(str, 0, i).reverse().toString();
				sbb.setLength(0);
				String sb = sbb.append(str, i, j).reverse().toString();
				sbb.setLength(0);
				String sc = sbb.append(str.substring(j)).reverse().toString();
				sbb.setLength(0);

				ts.add(sa+sb+sc);
			}

		}
		System.out.println(ts.iterator().next());
	}
}
