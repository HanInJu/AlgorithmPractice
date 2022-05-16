package with.w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5_A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n, m, k;

		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		k = Long.parseLong(st.nextToken());

		m = m + k - 3;
		m = (m + 100000*n - 1) % n + 1;

		System.out.println(m);
	}
}
