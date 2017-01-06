package edu.mst.algo.common;

public class Utils {

	public static int[] createIntArray(int count) {
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = i;
		}
		return array;
	}

	public static int[] createIntArray(int count, int value) {
		int[] array = new int[count];
		for (int i = 0; i < count; i++) {
			array[i] = value;
		}
		return array;
	}
}
