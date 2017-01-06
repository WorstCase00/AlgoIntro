package edu.mst.algo.unionfind;

public class FastUnionFindTest extends BaseUnionFindTest {

	@Override
	UnionFind createSubject(int count) {
		return FastUnionFind.create(count);
	}
}
