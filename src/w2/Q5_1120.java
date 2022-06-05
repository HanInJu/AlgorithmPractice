package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5_1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a, b;
		int min = 987654321, n, count;

		a = st.nextToken();
		b = st.nextToken();
		n = b.length() - a.length() + 1;

		for(int i = 0; i < n; i++) {
			count = 0;
			for(int j = 0; j < a.length(); j++) {
				if(a.charAt(j) != b.charAt(i+j)) {
					count++;
				}
			}
			min = Math.min(min, count);
		}

		System.out.println(min);
	}
}
