package with.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15651 {
	public static int n, m;
	public static int[] indexes = new int[1000];
	public static StringBuilder sb = new StringBuilder();

	public static void recursion(int cursor) {
		if(cursor == m) {
			for(int i = 0; i<m; i++) {
				sb.append(indexes[i]).append(" ");
				// System.out.print(indexes[i] + " ");
			}
			sb.append("\n");
			// System.out.println();
			return;
		}

		for(int i = 1; i <= n; i++) {
			indexes[cursor] = i;
			recursion(cursor + 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n개에서 m개 뽑기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		recursion(0);
		System.out.print(sb);
	}
}
