package w2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Condo[] arr = new Condo[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Condo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			Condo cur = arr[i];
			boolean checked = true;
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (cur.c > arr[j].c && cur.d >= arr[j].d) {
					checked = false;
					break;
				}
				if (cur.d > arr[j].d && cur.c >= arr[j].c) {
					checked = false;
					break;
				}
			}
			if (checked)
				cnt++;
		}
		System.out.println(cnt);
	}

	static class Condo {
		int d;
		int c;

		public Condo(int d, int c) {
			this.d = d;
			this.c = c;
		}
	}
}
