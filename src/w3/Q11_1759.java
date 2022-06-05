package w3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11_1759 {
	//C개 중 L개 뽑는데, aeiou 중 1개 이상 + 2개 이상의 자음, 오름차순, 중복X - 조합!
	private static int L, C;
	private static char[] passwords;
	private static char[] alphabets;
	private static StringBuilder sb = new StringBuilder();

	public static void recur(int cur, int start) {
		if(cur == L) {
			int vowels = 0, consonants = 0;
			StringBuilder password = new StringBuilder();
			for(char character : passwords) {
				if(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
					vowels++;
				}
				else {
					consonants++;
				}
				password.append(character);
			}
			if(vowels >= 1 && consonants >= 2) {
				sb.append(password).append("\n");
			}
			return;
		}

		for(int i = start; i<C; i++) {
			passwords[cur] = alphabets[i];
			recur(cur+1, i+1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		passwords = new char[L];
		alphabets = new char[C];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<C; i++) {
			alphabets[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alphabets);

		recur(0, 0);
		System.out.println(sb);
	}
}
