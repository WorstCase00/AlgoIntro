package edu.mst.algo.unionfind;

import edu.mst.Utils;

public class FastUnionFind implements UnionFind {


	private final int[] components;

	public FastUnionFind(int[] components) {
		this.components = components;
	}

	@Override
	public int find(int element) {
		if (components[element] < 0) {
			return element;
		}
		return find(components[element]);
	}

	@Override
	public void union(int element1, int element2) {
		components[element2] = element1;

	}

	public static FastUnionFind create(int count) {
		return new FastUnionFind(Utils.createIntArray(count, -1));
	}
}
