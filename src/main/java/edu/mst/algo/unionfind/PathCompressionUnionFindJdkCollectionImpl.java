package edu.mst.algo.unionfind;

import edu.mst.algo.common.Utils;

import java.util.ArrayDeque;

public class PathCompressionUnionFindJdkCollectionImpl implements UnionFind {

	private final int[] components;
	private ArrayDeque<Integer> path;

	public PathCompressionUnionFindJdkCollectionImpl(int[] components) {
		this.components = components;
		this.path = new ArrayDeque<Integer>(components.length);
	}

	@Override
	public int find(int element) {
		path.clear();
		int component = findRecursively(element);
		for (Integer pathElement : path) {
			components[pathElement.intValue()] = component;
		}
		return component;
	}

	private int findRecursively(int element) {
		if (components[element] < 0) {
			return element;
		}
		path.add(element);
		return findRecursively(components[element]);
	}


	@Override
	public void union(int element1, int element2) {
		components[element2] = element1;
	}

	public static PathCompressionUnionFindJdkCollectionImpl create(int count) {
		return new PathCompressionUnionFindJdkCollectionImpl(Utils.createIntArray(count, -1));
	}
}
