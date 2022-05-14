package w1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q13_2503 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;
		List<Baseball> baseballData = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			baseballData.add(new Baseball(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())));
		}

		System.out.println(startGame(baseballData, n));
	}

	public static int startGame(List<Baseball> baseballData, int n) {
		int answer = 0;

		for(int i = 123; i <= 987; i++) {
			if(!isValidNumber(i)) {
				continue;
			}
			int passedTestNumber = 0;

			for(int j = 0; j < baseballData.size(); j++) {
				Baseball current = baseballData.get(j);
				String baseballNumber = String.valueOf(current.number);
				String targetNumber = String.valueOf(i);

				int triedStrikeCount = 0;
				for(int k = 0; k < 3; k++) {
					if(baseballNumber.charAt(k) == targetNumber.charAt(k)) {
						triedStrikeCount++;
					}
				}

				int triedBallCount = 0;
				for(int x = 0; x < 3; x++) {
					for(int y = 0; y < 3; y++) {
						if(baseballNumber.charAt(x) == targetNumber.charAt(y)) {
							if(x != y) {
								triedBallCount++;
							}
						}
					}
				}

				if((current.strike == triedStrikeCount) && (current.ball == triedBallCount)) {
					passedTestNumber++;
				}
			}

			if(passedTestNumber == n) {
				answer++;
			}
		}

		return answer;
	}

	public static boolean isValidNumber(int number) {
		int one = number % 10;
		int tenth = (number / 10) % 10;
		int hundredth = (number / 10) / 10;

		if((one == 0) || (tenth == 0) || (hundredth == 0)) {
			return false;
		}
		return (one != tenth) && (one != hundredth) && (tenth != hundredth);
	}

	static class Baseball {
		int number;
		int strike;
		int ball;

		public Baseball(int number, int strike, int ball) {
			this.number = number;
			this.strike = strike;
			this.ball = ball;
		}
	}

}
