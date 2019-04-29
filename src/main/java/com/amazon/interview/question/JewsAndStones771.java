package com.amazon.interview.question;

public class JewsAndStones771 {
	public int numJewelsInStones(final String J, final String S) {
		int count = 0;

		final boolean[] diamonds = new boolean[256];
		for (int i = 0; i < J.length(); i++) {
			diamonds[J.charAt(i)] = true;
		}

		for (int i = 0; i < S.length(); i++) {
			if (diamonds[S.charAt(i)]) {
				count++;
			}
		}

		return count;
	}

	public static void main(final String[] args) {
		// TODO Auto-generated method stub

	}

}
