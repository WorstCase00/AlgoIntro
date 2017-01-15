package edu.mst.algo.unionfind;

public class PathCompressionUnionFindTroveImplTest extends BaseUnionFindTest {

	@Override
	UnionFind createSubject(int count) {
		return PathCompressionUnionFindTroveImpl.create(count);
	}
}
