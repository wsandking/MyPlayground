package com.amazon.interview.question;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels763 {

	public List<Integer> partitionLabels(final String S) {
		if (null == S || 0 == S.length()) {
			return null;
		}

		final List<Integer> list = new ArrayList<Integer>();

		final int[][] docs = new int[256][2];
		for (int i = 0; i < docs.length; i++) {
			for (int j = 0; j < docs[0].length; j++) {
				docs[i][j] = -1;
			}
		}

		for (int i = 0; i < S.length(); i++) {
			if (-1 == docs[S.charAt(i)][0]) {
				docs[S.charAt(i)][0] = i;
				docs[S.charAt(i)][1] = i;
			} else {
				docs[S.charAt(i)][1] = i;
			}
		}

		int leftBoundary = 0;
		int rightBoundary = 0;

		for (int i = 0; i < S.length(); i++) {
			if (docs[S.charAt(i)][0] > rightBoundary) {
				list.add(rightBoundary - leftBoundary + 1);
				leftBoundary = i;
				rightBoundary = docs[S.charAt(i)][1];
			}
			if (docs[S.charAt(i)][1] > rightBoundary) {
				rightBoundary = docs[S.charAt(i)][1];
			}

		}

		list.add(rightBoundary - leftBoundary + 1);

		return list;
	}

	public static void main(final String args[]) {

	}

}
