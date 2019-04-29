package com.amazon.interview.question;

public class KEmptySlots683 {

	public int kEmptySlots(final int[] flowers, final int k) {
		if (flowers.length < k) {
			return -1;
		}

		final boolean[] bloomed = new boolean[flowers.length];
		boolean result = true;

		for (int i = 0; i < flowers.length; i++) {
			bloomed[flowers[i] - 1] = true;
			final int leftPosition = flowers[i] - 2 - k;
			// Check left
			if (leftPosition >= 0 && bloomed[leftPosition]) {
				for (int j = leftPosition + 1; j < flowers[i] - 1; j++) {
					if (true == bloomed[j]) {
						result = false;
						break;
					}
				}

				if (result) {
					return i + 1;
				}
			}

			final int rightPosition = flowers[i] + k;
			result = true;
			// Check right
			if (rightPosition < flowers.length && bloomed[rightPosition]) {
				for (int j = flowers[i]; j < rightPosition; j++) {
					if (true == bloomed[j]) {
						result = false;
						break;
					}
				}
				if (result) {
					return i + 1;
				}
			}

		}

		return -1;
	}

	public static void main(final String[] args) {
		final int[] flowers = { 6, 5, 8, 9, 7, 1, 10, 2, 3, 4 };
		final KEmptySlots683 solution = new KEmptySlots683();
		System.err.println("Solutions : " + solution.kEmptySlots(flowers, 2));

	}

}
