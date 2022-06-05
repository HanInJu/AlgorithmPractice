package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t, i, n, m;
		String str;
		int[] arr = new int[5001];

		for (i = 1; i <= 5000; i++) {
			boolean[] chk = new boolean[10];
			t = i;
			while (true) {
				if (t == 0) {
					arr[i] = 1;
					break;
				}
				if (chk[t % 10])
					break;
				chk[t % 10] = true;
				t /= 10;
			}
		}
		for (i = 2; i <= 5000; i++)
			arr[i] += arr[i - 1];
		while ((str = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(str);
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			sb.append(arr[m] - arr[n - 1]).append("\n");
		}
		System.out.println(sb);
	}
}
