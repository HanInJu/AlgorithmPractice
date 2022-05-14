package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3_2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] pos = new int[9];
		int limit = 100;
		int sum = 0;

		for(int i = 0; i < 9; i++) {
			pos[i] = Integer.parseInt(br.readLine());
			sum += pos[i];
		}

		int plus = sum - limit;
		int xi = -1, yi = -1, x;

		for(int i = 0; i < 9; i++) {
			x = pos[i];
			for(int j = i; j < 9; j++) {
				if((pos[j] == plus - x) && (pos[j] != x)) {
					xi = i;
					yi = j;
					break;
				}
			}
			if(xi != -1) {
				break;
			}
		}
		int notReal1 = pos[xi];
		int notReal2 = pos[yi];

		Arrays.sort(pos);

		for(int i = 0; i<9; i++) {
			if(pos[i] != notReal1 && pos[i] != notReal2) {
				System.out.println(pos[i]);
			}
		}
	}

}
