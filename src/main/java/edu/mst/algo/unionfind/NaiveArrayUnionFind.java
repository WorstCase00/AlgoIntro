package edu.mst.algo.unionfind;


import edu.mst.algo.common.Utils;

public class NaiveArrayUnionFind implements UnionFind {

	private final int[] components;

	private NaiveArrayUnionFind(int[] components) {
		this.components = components;
	}

	@Override
	public int find(int element) {
		return components[element];
	}

	@Override
	public void union(int element1, int element2) {
		for (int i = 0; i < components.length; i++) {
			if (components[i] == components[element2]) {
				components[i] = components[element1];
			}
		}
	}

	public static NaiveArrayUnionFind create(int count) {
		return new NaiveArrayUnionFind(Utils.createIntArray(count));
	}
}
