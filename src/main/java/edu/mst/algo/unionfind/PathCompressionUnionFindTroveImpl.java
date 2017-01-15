package edu.mst.algo.unionfind;

import edu.mst.algo.common.Utils;
import gnu.trove.TIntCollection;
import gnu.trove.iterator.TIntIterator;
import gnu.trove.list.array.TIntArrayList;

public class PathCompressionUnionFindTroveImpl implements UnionFind {

	private final int[] components;
	private TIntCollection path;

	public PathCompressionUnionFindTroveImpl(int[] components) {
		this.components = components;
		this.path = new TIntArrayList(components.length);
	}

	@Override
	public int find(int element) {
		path.clear();
		int component = findRecursively(element);
		TIntIterator iterator = path.iterator();
		while (iterator.hasNext()) {
			components[iterator.next()] = component;
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

	public static PathCompressionUnionFindTroveImpl create(int count) {
		return new PathCompressionUnionFindTroveImpl(Utils.createIntArray(count, -1));
	}
}
