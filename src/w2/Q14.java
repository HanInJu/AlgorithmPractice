package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int n = 1;
		if (s.length() < 4) {
			char c = s.charAt(0);
			for (; n < s.length(); n++) {
				if (s.charAt(n) != c) {
					break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if (n == s.length()) {
			sb.append(s).append(" ").append(s);
		} else {
			for (int i = 1; i <= 999; i++) {
				if (s.startsWith(Integer.toString(i))) {
					String str = s;
					for (int j = i; j <= 999; j++) {
						if (str.startsWith(Integer.toString(j))) {
							str = str.substring(Integer.toString(j).length());
						} else {
							break;
						}
						if (str.length() == 0) {
							sb.append(i).append(" ").append(j);
							break;
						}
					}
					if (sb.length() != 0) {
						break;
					}
				}
			}
		}
		System.out.print(sb);
	}
}
