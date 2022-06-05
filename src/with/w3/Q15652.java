package with.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15652 {
	public static int n,m;
	public static int[] indexes = new int[1000];

	public static void recursion(int cur, int start) {
		if(cur == m) {
			for(int i = 0; i<m; i++) {
				System.out.print(indexes[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = start; i<=n; i++) {
			indexes[cur] = i;
			recursion(cur+1, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n개에서 m개 뽑기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		recursion(0, 1);
	}
}
