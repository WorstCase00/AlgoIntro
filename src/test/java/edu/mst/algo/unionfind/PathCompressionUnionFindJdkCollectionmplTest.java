package edu.mst.algo.unionfind;

public class PathCompressionUnionFindJdkCollectionmplTest extends BaseUnionFindTest {

	@Override
	UnionFind createSubject(int count) {
		return PathCompressionUnionFindJdkCollectionImpl.create(count);
	}
}
