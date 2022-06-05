package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] dp = new int[9];
		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = Integer.parseInt(br.readLine());
		int g = (n - 2) * (m - 2);
		int[] ans = new int[g];
		int count = 0;
		int sh = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = 0; j < m - 2; j++) {
				dp[count] = arr[i][j];
				dp[count + 1] = arr[i][j + 1];
				dp[count + 2] = arr[i][j + 2];
				dp[count + 3] = arr[i + 1][j];
				dp[count + 4] = arr[i + 1][j + 1];
				dp[count + 5] = arr[i + 1][j + 2];
				dp[count + 6] = arr[i + 2][j];
				dp[count + 7] = arr[i + 2][j + 1];
				dp[count + 8] = arr[i + 2][j + 2];
				Arrays.sort(dp);
				ans[sh] = dp[4];
				sh++;
			}
		}
		int a = 0;
		for (int i = 0; i < sh; i++) {
			if (ans[i] >= x) {
				a++;
			}
		}
		System.out.println(a);

	}
}
