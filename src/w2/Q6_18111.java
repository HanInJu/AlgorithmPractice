package w2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q6_18111 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] ground;
		List<Integer> heights = new ArrayList<>();
		int n,m,b, myInventory, minTime, maxHeight, blockToAdd, blockToSub, totalTime;

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		ground = new int[n][m];

		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<m; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
				if(!heights.contains(ground[i][j])) {
					heights.add(ground[i][j]);
				}
			}
		}

		minTime = 987654321;
		maxHeight = -1;
		outerFor : for(int height : heights) {
			blockToAdd = 0;
			blockToSub = 0;
			myInventory = b;

			for(int i = 0; i<n; i++) {
				for(int j = 0; j<m; j++) {
					if(height - ground[i][j] > 0) {
						blockToAdd += height - ground[i][j];
						myInventory -= height - ground[i][j];
						if(myInventory < 0) {
							continue outerFor;
						}
					}
					else if(height - ground[i][j] < 0) {
						blockToSub += Math.abs(height - ground[i][j]);
						myInventory += Math.abs(height - ground[i][j]);
					}
				}
			}

			totalTime = blockToAdd + (blockToSub * 2);

			if(totalTime < minTime) {
				minTime = totalTime;
				maxHeight = height;
			}
			else if(totalTime == minTime) {
				if(maxHeight < height) {
					maxHeight = height;
				}
			}
		}

		System.out.println(minTime + " " + maxHeight);
	}
}

