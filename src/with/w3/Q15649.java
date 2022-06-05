package with.w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {
	public static int n, m;
	public static int[] indexes = new int[1000];
	public static boolean[] visited = new boolean[1000];

	public static void recursion(int cursor) {
		if(cursor == m) {
			for(int i = 0; i<m; i++) {
				System.out.print(indexes[i] + " ");
			}
			System.out.println();
			return;
		}

		for(int i = 1; i<=n; i++) {
			if(visited[i]) {
				continue;
			}

			indexes[cursor] = i;
			visited[i] = true;
			recursion(cursor + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// n개에서 m개 뽑기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		recursion(0);
	}
}
