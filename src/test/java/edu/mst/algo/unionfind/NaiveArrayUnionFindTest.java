package edu.mst.algo.unionfind;

public class NaiveArrayUnionFindTest extends BaseUnionFindTest {

	UnionFind createSubject(int count) {
		return NaiveArrayUnionFind.create(count);
	}

}